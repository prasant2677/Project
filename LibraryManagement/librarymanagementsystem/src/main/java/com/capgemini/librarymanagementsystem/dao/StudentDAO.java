package com.capgemini.librarymanagementsystem.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BookDTO;
import com.capgemini.librarymanagementsystem.dto.RequestDTO;
import com.capgemini.librarymanagementsystem.dto.StudentDTO;

public interface StudentDAO {
	boolean register(StudentDTO std);
	StudentDTO auth(String email,String password);
	LinkedList<BookDTO> searchBookTitle(String bookName);
	LinkedList<BookDTO> searchBookAuthor(String bookAuthor);
	LinkedList<BookDTO> searchBookType(String bookType);
	LinkedList<Integer> getBookIds();
	LinkedList<BookDTO> getBooksInfo();
	RequestDTO requestBook(StudentDTO student, BookDTO book);
	RequestDTO returnBook(StudentDTO student, BookDTO book);
	
	

}
