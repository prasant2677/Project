package com.capgemini.librarymanagementjdbc.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.librarymanagementjdbc.exception.Exception;

public class Validation {

		public boolean validatedId(int id) throws Exception {
			String idRegEx = "[0-9]{1}[0-9]{5}" ;
			boolean result = false;
			if (Pattern.matches(idRegEx, String.valueOf(id))) {
				result = true;
			} else {
				throw new Exception("Id should contains exactly 6 digits");
			}
			return result;
		}
		public boolean validatedName(String name) throws Exception {
			String nameRegEx = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$" ;
			boolean result = false;
			Pattern pattern = Pattern.compile(nameRegEx);
			Matcher matcher = pattern.matcher(name);
			if (matcher.matches()) {
				result = true;
			} else {
				throw new Exception("Name should contains only Alpabates");
			}
			return result;
		}

		public boolean validatedMobile(String mobile) throws Exception {
			String mobileRegEx = "(0/91)?[6-9][0-9]{9}" ;
			boolean result = false;
			Pattern pattern = Pattern.compile(mobileRegEx);
			Matcher matcher = pattern.matcher(mobile);
			if (matcher.matches()) {
				result = true;
			} else {
				throw new Exception("Mobile Number will start between  9 & 6 and It should contains 10 numbers ");
			}
			return result;
		}
		public boolean validatedEmail(String email) throws Exception {
			String emailRegEx = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
			boolean result = false;
			Pattern pattern = Pattern.compile(emailRegEx);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				result = true;
			} else {
				throw new Exception("Enter proper email ");
			}
			return result;
		}

		public boolean validatedPassword(String password) throws Exception {
			String passwordRegEx = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})" ;
			boolean result = false;
			if (Pattern.matches(passwordRegEx, String.valueOf(password))) { 
				result = true;
			} else {
				throw new Exception("Password should contain atleast 8 characters ,one uppercase,one lowercase and one symbol "); 
			}

			return result;
		}
		public  boolean validatedDate(String date) throws Exception {
			String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$"; 
			boolean result = false;
			Pattern pattern = Pattern.compile(regex); 
			Matcher matcher = pattern.matcher((CharSequence)date); 
			if(matcher.matches()) {
				result = true;
			} else {
				throw new Exception("Enter proper Date Format");
			}
			return result;
		}
		public boolean validatedBookId(int id) throws Exception {
			String idRegEx = "[1-9]{1}[0-9]{3}" ;
			boolean result = false;
			if (Pattern.matches(idRegEx, String.valueOf(id))) {
				result = true;
			} else {
				throw new Exception("Id should contains exactly 4  digits");
			}
			return result;
		}

}
