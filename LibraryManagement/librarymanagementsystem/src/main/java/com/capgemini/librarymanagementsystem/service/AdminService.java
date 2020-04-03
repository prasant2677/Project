package com.capgemini.librarymanagementsystem.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.AdminDTO;
import com.capgemini.librarymanagementsystem.dto.BookDTO;
import com.capgemini.librarymanagementsystem.dto.RequestDTO;
import com.capgemini.librarymanagementsystem.dto.StudentDTO;

public interface AdminService {
	
	boolean register(AdminDTO admin);
	AdminDTO auth(String email,String password);
	//List<BookDTO> search(BookDTO book);
	boolean addBook(BookDTO book);
	LinkedList<BookDTO> searchBookTitle(String bookTitle);
	LinkedList<BookDTO> searchBookAuthor(String bookAuthor);
	LinkedList<BookDTO> searchBookType(String bookType);
	int updateBook(int bookId);
	boolean removeBook(int bookId);
	LinkedList<Integer> getBookIds();
	LinkedList<BookDTO> getBooksInfo();
	
	List<StudentDTO> showStudents();
	List<RequestDTO> showRequests();
	boolean bookIssue(StudentDTO student,BookDTO book);
	boolean isBookReceived(StudentDTO student,BookDTO book);
	
}
