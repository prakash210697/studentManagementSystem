package com.src.model;

public class Student {
	
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentpassword=" + studentpassword + ", studentname="
				+ studentname + ", studentaddress=" + studentaddress + ", studentage=" + studentage
				+ ", studentmobileno=" + studentmobileno + "]";
	}
	private String studentid;
	private String studentpassword;
	private String studentname;
	private String studentaddress;
	private int studentage;
	private long studentmobileno;
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getStudentpassword() {
		return studentpassword;
	}
	public void setStudentpassword(String studentpassword) {
		this.studentpassword = studentpassword;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentaddress() {
		return studentaddress;
	}
	public void setStudentaddress(String studentaddress) {
		this.studentaddress = studentaddress;
	}
	public int getStudentage() {
		return studentage;
	}
	public void setStudentage(int studentage) {
		this.studentage = studentage;
	}
	public long getStudentmobileno() {
		return studentmobileno;
	}
	public void setStudentmobileno(long studentmobileno) {
		this.studentmobileno = studentmobileno;
	}
	public Student(String studentid, String studentpassword, String studentname, String studentaddress, int studentage,
			long studentmobileno) {
		super();
		this.studentid = studentid;
		this.studentpassword = studentpassword;
		this.studentname = studentname;
		this.studentaddress = studentaddress;
		this.studentage = studentage;
		this.studentmobileno = studentmobileno;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
