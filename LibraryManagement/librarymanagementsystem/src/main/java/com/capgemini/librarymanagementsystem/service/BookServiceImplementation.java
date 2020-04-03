package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dao.BookDAO;
import com.capgemini.librarymanagementsystem.dto.BookDTO;
import com.capgemini.librarymanagementsystem.factory.BookFactory;

public class BookServiceImplementation implements BookService {

	private BookDAO dao = BookFactory.getBookDAO();
	public boolean addBook(BookDTO dto) {
		
		return dao.addBook(dto) ;
	}

	public BookDTO issueBook(String book_name, int book_id) {

		return dao.issueBook(book_name, book_id);
	}

	public boolean returnBook(int book_id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<BookDTO> search(int book_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(String book_name, int book_id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	

}
