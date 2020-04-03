package com.capgemini.librarymanagementsystem.dto;

import java.io.Serializable;

public class AdminDTO implements Serializable{

	private int a_id;
	private String a_name;
	private String a_password;
	private String a_email;
	private String a_mobileno;
	
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_password() {
		return a_password;
	}
	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	public String getA_email() {
		return a_email;
	}
	public void setA_email(String a_email) {
		this.a_email = a_email;
	}
	public String getA_mobileno() {
		return a_mobileno;
	}
	public void setA_mobileno(String a_mobileno) {
		this.a_mobileno = a_mobileno;
	}
	
	
	
}
