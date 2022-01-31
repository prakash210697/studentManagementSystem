package com.src.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.src.dao.StudentDAOInterface;
import com.src.model.Student;

@Controller
public class MyController {
	
	@Autowired
	StudentDAOInterface sdao;
	
	@RequestMapping("/")
	public String homePage()
	{
		return "index";
	}
	
	@RequestMapping("/login")
	public String loginPage(@RequestParam("uname") String u,@RequestParam("pwd") String p,Model m)
	{
		
		Student s =new Student();
		s.setStudentid(u);
		s.setStudentpassword(p);
		
		boolean result=sdao.validateStudent(s);
		
		if(result)
		{
			
			
			return "redirect:view";
		}
		else
		{
			m.addAttribute("msg","invalid username or password");
			return "../../index";
		}
	}
	
	@RequestMapping("/view")
	public String viewPage(Model m)
	{	
				
			List<Student> students=sdao.getAllStudents();
			m.addAttribute("students",students);
			return "main";
		
	}
	
	@RequestMapping("/register")
	public String registerPage(Model m)
	{
		m.addAttribute("command",new Student());
		return "register";
	}
	
	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute("std") Student std)
	{
		sdao.insertStudent(std);
		return "../../index";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id)
	{
		Student s=new Student();
		s.setStudentid(id);
		sdao.deleteStudent(s);
		return "redirect:/view";
	}
	
	@RequestMapping("/edit/{id}")
	public String editStudent(@PathVariable String id,Model m)
	{		
		Student s=sdao.getStudentById(id);
		System.out.println(s);
		m.addAttribute("command",s);
		return "updatestudent";
	}
	
	@RequestMapping("/editstudent")
	public String updateStudent(@ModelAttribute("std")Student s)
	{		
		sdao.editStudent(s);
		return "redirect:/view";
	}

}
