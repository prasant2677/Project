package com.capgemini.librarymanagementsystem.controller;

import java.util.Scanner;

import com.capgemini.librarymanagementsystem.dto.AdminDTO;
import com.capgemini.librarymanagementsystem.dto.StudentDTO;
import com.capgemini.librarymanagementsystem.factory.StudentFactory;
import com.capgemini.librarymanagementsystem.service.StudentService;

public class StudentControl {
	
	public static void main(String[] args) {
		
		System.out.println("****************Welcome to the Digital Library****************");
		
		Scanner scan=new Scanner(System.in);
		StudentService service = StudentFactory.getStudentService();
		System.out.println("Press 1 to REGISTER");
		System.out.println("Press 2 to LOGIN");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter ID");
			int regid=scan.nextInt();

			System.out.println("Enter NAME");
			String regname=scan.next();

			System.out.println("Enter EMAIL");
			String regemail=scan.next();

			System.out.println("Enter MOBILE NO");
			long regmobileno = scan.nextLong();

			System.out.println("Enter PASSWORD");
			String regpassword = scan.next();
			
			StudentDTO dto=new StudentDTO();
			dto.setS_id(regid);
			dto.setS_email(regemail);
			dto.setS_name(regname);
			//dto.setS_mobileno(regmobileno);
			dto.setS_password(regpassword);
			
			boolean check = service.register(dto);
			if(check) {
				System.out.println("Registered");
			} else {
				System.out.println("Email already exists");
			}
			break;
			
		case 2:
			System.out.println("Enter the EMAIL ID");
			String email=scan.next();
			System.out.println("Enter the PASSWORD");
			String password=scan.next();

			try {
				StudentDTO auth = service.auth(email, password);
				System.out.println("LOGGED IN");
			} catch(Exception e) {
				System.out.println("Invalid Credentials");
			}
			break;
		default:
			System.out.println("Invalid Option");
			break;
		
		
	}

}
}
