package com.capgemini.librarymanagementsystem.database;

import java.util.LinkedList;

import com.capgemini.librarymanagementsystem.dto.AdminDTO;
import com.capgemini.librarymanagementsystem.dto.BookDTO;
import com.capgemini.librarymanagementsystem.dto.RequestDTO;
import com.capgemini.librarymanagementsystem.dto.StudentDTO;

public class DataBase {
	
	public static final LinkedList<AdminDTO> ADMINS= new LinkedList<AdminDTO>();
	public static final LinkedList<StudentDTO> STUDENTS= new LinkedList<StudentDTO>();
	public static final LinkedList<BookDTO> BOOKS= new LinkedList<BookDTO>();
	public static final LinkedList<RequestDTO> REQUESTS= new LinkedList<RequestDTO>();
	
	}
