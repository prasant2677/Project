package com.capgemini.librarymanagementjdbc.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementjdbc.dto.BookDTO;
import com.capgemini.librarymanagementjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementjdbc.dto.BorrowedBooks;
import com.capgemini.librarymanagementjdbc.dto.RequestDTO;
import com.capgemini.librarymanagementjdbc.dto.UserDTO;

public interface UserService {
	
	boolean register(UserDTO user);
	UserDTO login(String email,String password);
	boolean addBook(BookDTO book);
	boolean updateBook(BookDTO book);
	LinkedList<BookDTO> searchBookById(int bId);
	LinkedList<BookDTO> searchBookByTitle(String bookName);
	LinkedList<BookDTO> searchBookByAuthor(String author);
	LinkedList<BookDTO> getBooksInfo();
	boolean request(int userId, int bookId);
	boolean issueBook(int bId,int uId);
	List<BorrowedBooks> borrowedBook(int bId);
	boolean returnBook(int bId,int uId);
	boolean removeBook(int bId);
	LinkedList<UserDTO> showUsers();
	LinkedList<RequestDTO> showRequest();
	LinkedList<BookIssueDetails> bookHistoryDetails(int uId);
	LinkedList<BookDTO> getBookIds();


}
