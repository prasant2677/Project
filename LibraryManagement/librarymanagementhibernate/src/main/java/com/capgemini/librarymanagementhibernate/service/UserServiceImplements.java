package com.capgemini.librarymanagementhibernate.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementhibernate.dao.UserDao;
import com.capgemini.librarymanagementhibernate.dao.UserDaoImplements;
import com.capgemini.librarymanagementhibernate.dto.BookDTO;
import com.capgemini.librarymanagementhibernate.dto.BorrowedBooks;
import com.capgemini.librarymanagementhibernate.dto.RequestDTO;
import com.capgemini.librarymanagementhibernate.dto.UserDTO;
import com.capgemini.librarymanagementhibernate.factory.UserFactory;

public class UserServiceImplements implements UserService {
	private UserDao dao = UserFactory.getUserDao();
	@Override
	public boolean register(UserDTO info) {
		// TODO Auto-generated method stub
		return dao.register(info);
	}

	@Override
	public UserDTO auth(String email, String password) {
		// TODO Auto-generated method stub
		return dao.auth(email, password);
	}

	@Override
	public boolean addBook(BookDTO book) {
		// TODO Auto-generated method stub
		return dao.addBook(book);
	}

	

	@Override
	public boolean updateBook(BookDTO bean) {
		// TODO Auto-generated method stub
		return dao.updateBook(bean);
	}

	@Override
	public boolean removeBook(int bid) {
		// TODO Auto-generated method stub
		return dao.removeBook(bid);
	}



	@Override
	public LinkedList<BookDTO> getBooksInfo() {
		// TODO Auto-generated method stub
		return dao.getBooksInfo();
	}

	@Override
	public List<UserDTO> showUsers() {
		// TODO Auto-generated method stub
		return dao.showUsers();
	}

	@Override
	public List<RequestDTO> showRequests() {
		// TODO Auto-generated method stub
		return dao.showRequests();
	}

	@Override
	public List<BorrowedBooks> borrowedBook(int uId) {
		// TODO Auto-generated method stub
		return dao.borrowedBook(uId);
	}

	@Override
	public LinkedList<BookDTO> getBookIds() {
		// TODO Auto-generated method stub
		return dao.getBookIds();
	}

	@Override
	public boolean bookIssue(int bId, int uId) {
		// TODO Auto-generated method stub
		return dao.bookIssue(bId, uId);
	}

	@Override
	public boolean requestBook(int userId, int bookId) {
		// TODO Auto-generated method stub
		return dao.requestBook(userId, bookId);
	}

	@Override
	public boolean returnBook(int bId, int uId) {
		// TODO Auto-generated method stub
		return dao.returnBook(bId, uId);
	}

	@Override
	public LinkedList<BookDTO> searchBookTitle(String bname) {
		// TODO Auto-generated method stub
		return dao.searchBookTitle(bname);
	}

	@Override
	public LinkedList<BookDTO> searchBookAuthor(String bAuthor) {
		// TODO Auto-generated method stub
		return dao.searchBookAuthor(bAuthor);
	}

	@Override
	public LinkedList<BookDTO> searchBookType(int bid) {
		// TODO Auto-generated method stub
		return dao.searchBookType(bid);
	}


}


