package com.capgemini.librarymanagementjdbc.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementjdbc.dao.UserDAO;
import com.capgemini.librarymanagementjdbc.dto.BookDTO;
import com.capgemini.librarymanagementjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementjdbc.dto.BorrowedBooks;
import com.capgemini.librarymanagementjdbc.dto.RequestDTO;
import com.capgemini.librarymanagementjdbc.dto.UserDTO;
import com.capgemini.librarymanagementjdbc.factory.UserFactory;

public class UserServiceImplementation implements UserService {
	
	private UserDAO dao = UserFactory.getUserDao();

	@Override
	public boolean register(UserDTO user) {
		// TODO Auto-generated method stub
		return dao.register(user);
	}

	@Override
	public UserDTO login(String email, String password) {
		// TODO Auto-generated method stub
		return dao.login(email, password);
	}

	@Override
	public boolean addBook(BookDTO book) {
		// TODO Auto-generated method stub
		return dao.addBook(book);
	}

	@Override
	public boolean updateBook(BookDTO book) {
		// TODO Auto-generated method stub
		return dao.updateBook(book);
	}

	@Override
	public LinkedList<BookDTO> searchBookById(int bId) {
		// TODO Auto-generated method stub
		return dao.searchBookById(bId);
	}

	@Override
	public LinkedList<BookDTO> searchBookByTitle(String bookName) {
		// TODO Auto-generated method stub
		return dao.searchBookByTitle(bookName);
	}

	@Override
	public LinkedList<BookDTO> searchBookByAuthor(String author) {
		// TODO Auto-generated method stub
		return dao.searchBookByAuthor(author);
	}

	@Override
	public LinkedList<BookDTO> getBooksInfo() {
		// TODO Auto-generated method stub
		return dao.getBooksInfo();
	}

	@Override
	public boolean request(int userId,int bookId) {
		// TODO Auto-generated method stub
		return dao.request(userId,bookId);
	}

	@Override
	public boolean issueBook(int bId, int uId) {
		// TODO Auto-generated method stub
		return dao.issueBook(bId, uId);
	}

	@Override
	public List<BorrowedBooks> borrowedBook(int uId) {
		// TODO Auto-generated method stub
		return dao.borrowedBook(uId);
	}

	@Override
	public boolean returnBook(int bId,int uId) {
		// TODO Auto-generated method stub
		return dao.returnBook(bId,uId);
	}

	@Override
	public boolean removeBook(int bId) {
		// TODO Auto-generated method stub
		return dao.removeBook(bId);
	}

	@Override
	public LinkedList<UserDTO> showUsers() {
		// TODO Auto-generated method stub
		return dao.showUsers();
	}

	@Override
	public LinkedList<RequestDTO> showRequest() {
		// TODO Auto-generated method stub
		return dao.showRequest();
	}

	@Override
	public LinkedList<BookIssueDetails> bookHistoryDetails(int uId) {
		// TODO Auto-generated method stub
		return dao.bookHistoryDetails(uId);
	}

	@Override
	public LinkedList<BookDTO> getBookIds() {
		// TODO Auto-generated method stub
		return dao.getBookIds();
	}

}
