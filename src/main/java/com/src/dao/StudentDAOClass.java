package com.src.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.src.model.Student;

public class StudentDAOClass implements StudentDAOInterface {
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public int insertStudent(Student s) {
		// TODO Auto-generated method stub
		String sqlquery="insert into student121 values('"+s.getStudentid()+"','"+s.getStudentpassword()+"','"+s.getStudentname()+"','"+s.getStudentaddress()
		+"',"+s.getStudentage()+","+s.getStudentmobileno()+")";
		return jdbctemplate.update(sqlquery);
	}

	public int deleteStudent(final Student s) {
		String sqlquery="delete from student121 where stdid='"+s.getStudentid()+"'";
		return jdbctemplate.update(sqlquery);
	}

	public int editStudent(final Student s) {
		String sqlquery="update student121 set stdpwd='"+s.getStudentpassword()+"',stdname='"+s.getStudentname()+"',stdadd='"+s.getStudentaddress()
		+"',stdage="+s.getStudentage()+",stdmob="+s.getStudentmobileno()+" where stdid='"+s.getStudentid()+"'";
		return jdbctemplate.update(sqlquery);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Student> getAllStudents() {
		final List<Student> students =new ArrayList<Student>();
		String sqlquery="select * from student121";
		
		return jdbctemplate.query(sqlquery,new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				while(rs.next())
				{
					Student s =new Student();
					s.setStudentid(rs.getString(1));
					s.setStudentpassword(rs.getString(2));
					s.setStudentname(rs.getString(3));
					s.setStudentaddress(rs.getString(4));
					s.setStudentage(rs.getInt(5));
					s.setStudentmobileno(rs.getLong(6));
					
					students.add(s);
				}
				
				return students;
			}
			
		});				
	
		
	}

	public Student getStudentById(String sid) {
		
		String sqlquery="select * from student121 where stdid='"+sid+"'";
		return jdbctemplate.query(sqlquery, new ResultSetExtractor<Student>() {
			Student s=new Student();
			@Override
			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next())
				{
					
					s.setStudentid(rs.getString(1));
					s.setStudentpassword(rs.getString(2));
					s.setStudentname(rs.getString(3));
					s.setStudentaddress(rs.getString(4));
					s.setStudentage(rs.getInt(5));
					s.setStudentmobileno(rs.getLong(6));
					return s;
				}
				else
				{
					return s;
				}
				
			}
			
			
		});
		
		

}

	@Override
	public boolean validateStudent(Student s) {
		String sqlquery="select * from student121 where stdid='"+s.getStudentid()+"' and stdpwd='"+s.getStudentpassword()+"'";
		return jdbctemplate.query(sqlquery, new ResultSetExtractor<Boolean>() {

			@Override
			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next())
				{
					return true;
				}
				else
				{
					return false;
				}
				
			}
			
			
		});
	}
}
