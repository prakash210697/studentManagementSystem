package com.src.dao;

import java.util.List;

import com.src.model.Student;

public interface StudentDAOInterface {
	
	public boolean validateStudent(Student s);
	public int insertStudent(Student s);
	public int deleteStudent(Student s);
	public int editStudent(Student s);	
	public List<Student> getAllStudents();
	public Student getStudentById(String sid);
	

}
