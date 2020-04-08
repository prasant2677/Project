package com.capgemini.librarymanagementhibernate.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementhibernate.dto.BookDTO;
import com.capgemini.librarymanagementhibernate.dto.BorrowedBooks;
import com.capgemini.librarymanagementhibernate.dto.RequestDTO;
import com.capgemini.librarymanagementhibernate.dto.UserDTO;

public interface UserService {
	boolean register(UserDTO info);
	UserDTO auth(String email, String password);
	boolean addBook(BookDTO book);
	LinkedList<BookDTO> searchBookTitle(String bname);
	LinkedList<BookDTO> searchBookAuthor(String bAuthor);
	LinkedList<BookDTO> searchBookType(int bid);
	boolean updateBook(BookDTO bean);
	List<BorrowedBooks> borrowedBook(int uId);
	boolean removeBook(int bid);
	LinkedList<BookDTO> getBookIds();
	LinkedList<BookDTO> getBooksInfo();
	List<UserDTO> showUsers();
	List<RequestDTO> showRequests();
	boolean bookIssue(int bId,int uId);
	boolean requestBook(int userId, int bookId);
	boolean returnBook(int bId,int uId);

}
