package com.capgemini.librarymanagementsystem.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dto.AdminDTO;
import com.capgemini.librarymanagementsystem.dto.BookDTO;
import com.capgemini.librarymanagementsystem.dto.RequestDTO;
import com.capgemini.librarymanagementsystem.dto.StudentDTO;
import com.capgemini.librarymanagementsystem.factory.AdminFactory;

public class AdminServiceImplementation implements AdminService {

	private AdminDAO dao=AdminFactory.getAdminDao();
	
	public boolean register(AdminDTO admin) {
		return dao.register(admin);
	}

	public AdminDTO auth(String email, String password) {

		return dao.auth(email, password);
	}

	public boolean addBook(BookDTO book) {
		return dao.addBook(book);
	}

	public LinkedList<BookDTO> searchBookTitle(String bookTitle) {
		return dao.searchBookTitle(bookTitle);
	}

	public LinkedList<BookDTO> searchBookAuthor(String bookAuthor) {
		return dao.searchBookAuthor(bookAuthor);
	}

	public LinkedList<BookDTO> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public int updateBook(int bookId) {
		return dao.updateBook(bookId);
	}

	public boolean removeBook(int bookId) {
		return dao.removeBook(bookId);
	}

	public LinkedList<Integer> getBookIds() {
		return dao.getBookIds();
	}

	public LinkedList<BookDTO> getBooksInfo() {
		return dao.getBooksInfo();
	}

	public List<StudentDTO> showStudents() {
		// TODO Auto-generated method stub
		return dao.showStudents();
	}

	public List<RequestDTO> showRequests() {
		// TODO Auto-generated method stub
		return dao.showRequests();
	}

	public boolean bookIssue(StudentDTO student, BookDTO book) {
		// TODO Auto-generated method stub
		return dao.bookIssue(student, book);
	}

	public boolean isBookReceived(StudentDTO student, BookDTO book) {
		// TODO Auto-generated method stub
		return dao.isBookReceived(student, book);
	}

	

}
