package com.capgemini.librarymanagementsystem.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dao.StudentDAO;
import com.capgemini.librarymanagementsystem.dto.BookDTO;
import com.capgemini.librarymanagementsystem.dto.RequestDTO;
import com.capgemini.librarymanagementsystem.dto.StudentDTO;
import com.capgemini.librarymanagementsystem.factory.StudentFactory;

public class StudentServiceImplementation implements StudentService {
	
	private StudentDAO dao=StudentFactory.getStudentDAO();

	public boolean register(StudentDTO std) {

		return dao.register(std);
	}

	public StudentDTO auth(String email, String password) {

		return dao.auth(email, password);
	}


	public LinkedList<BookDTO> searchBookTitle(String bookName) {
		return dao.searchBookTitle(bookName);
	}

	public LinkedList<BookDTO> searchBookAuthor(String bookAuthor) {
		return dao.searchBookAuthor(bookAuthor);
	}

	public LinkedList<BookDTO> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public LinkedList<Integer> getBookIds() {
		return dao.getBookIds();
	}

	public LinkedList<BookDTO> getBooksInfo() {
		return dao.getBooksInfo();
	}

	public RequestDTO requestBook(StudentDTO student, BookDTO book) {
		// TODO Auto-generated method stub
		return dao.requestBook(student, book);
	}

	public RequestDTO returnBook(StudentDTO student, BookDTO book) {
		// TODO Auto-generated method stub
		return dao.returnBook(student, book);
	}
	
	

}
