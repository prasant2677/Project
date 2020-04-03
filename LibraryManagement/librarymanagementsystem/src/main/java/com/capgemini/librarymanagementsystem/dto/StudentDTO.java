package com.capgemini.librarymanagementsystem.dto;

import java.io.Serializable;
import java.util.Date;

public class StudentDTO implements Serializable{
	
	private int s_id;
	private String s_name;
	private String s_password;
	private String s_email;
	private String s_mobileno;
	private String s_department;
	private Date s_issueDate;
	private Date s_returnDate;
	private int s_booksBorrowed;
	
	
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_password() {
		return s_password;
	}
	public void setS_password(String s_password) {
		this.s_password = s_password;
	}
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	public String getS_mobileno() {
		return s_mobileno;
	}
	public void setS_mobileno(String s_mobileno) {
		this.s_mobileno = s_mobileno;
	}
	public String getS_department() {
		return s_department;
	}
	public void setS_department(String s_department) {
		this.s_department = s_department;
	}
	public Date getS_issueDate() {
		return s_issueDate;
	}
	public void setS_issueDate(Date s_issueDate) {
		this.s_issueDate = s_issueDate;
	}
	public Date getS_returnDate() {
		return s_returnDate;
	}
	public void setS_returnDate(Date s_returnDate) {
		this.s_returnDate = s_returnDate;
	}
	public int getS_booksBorrowed() {
		return s_booksBorrowed;
	}
	public void setS_booksBorrowed(int s_booksBorrowed) {
		this.s_booksBorrowed = s_booksBorrowed;
	}
	
	
	
	
	

}
