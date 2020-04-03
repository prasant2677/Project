package com.capgemini.librarymanagementsystem.validation;


	
	 import java.util.regex.Matcher;
	import java.util.regex.Pattern;

import com.capgemini.librarymanagementsystem.exception.ValidationException;


	public class ValidationAdminStudent {
		public boolean validatedId(int id) throws ValidationException {
			String idRegEx = "[0-9]{1}[0-9]{5}" ;
			boolean result = false;
			if (Pattern.matches(idRegEx, String.valueOf(id))) {
				result = true;
			} else {
				throw new ValidationException("Id should contains exactly 6 digits");
			}
			return result;
		}
		public boolean validatedName(String name) throws ValidationException {
			String nameRegEx = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$" ;
			boolean result = false;
			Pattern pattern = Pattern.compile(nameRegEx);
			Matcher matcher = pattern.matcher(name);
			if (matcher.matches()) {
				result = true;
			} else {
				throw new ValidationException("Name should contains only Alpabates");
			}
			return result;
		}

		public boolean validatedMobile(String mobile) throws ValidationException {
			String mobileRegEx = "(0/91)?[6-9][0-9]{9}" ;
			boolean result = false;
			Pattern pattern = Pattern.compile(mobileRegEx);
			Matcher matcher = pattern.matcher(mobile);
			if (matcher.matches()) {
				result = true;
			} else {
				throw new ValidationException("Mobile Number will start between  9 & 6 and It should contains 10 numbers ");
			}
			return result;
		}
		public boolean validatedEmail(String email) throws ValidationException {
			String emailRegEx = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
			boolean result = false;
			Pattern pattern = Pattern.compile(emailRegEx);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				result = true;
			} else {
				throw new ValidationException("Enter proper email ");
			}
			return result;
		}

		public boolean validatedPassword(String password) throws ValidationException {
			String passwordRegEx = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})" ;
			boolean result = false;
			if (Pattern.matches(passwordRegEx, String.valueOf(password))) { 
				result = true;
			} else {
				throw new ValidationException("Password should contain atleast 8 characters ,one uppercase,one lowercase and one symbol "); 
			}

			return result;
		}
	}


