package com.capgemini.librarymanagementsystem.factory;

import com.capgemini.librarymanagementsystem.dao.BookDAO;
import com.capgemini.librarymanagementsystem.dao.BookDAOImplementation;
import com.capgemini.librarymanagementsystem.service.BookService;
import com.capgemini.librarymanagementsystem.service.BookServiceImplementation;

public class BookFactory {
	
	public static BookDAO getBookDAO() {
		
		return new BookDAOImplementation();
	}
	
	public static BookService getBookService() {
		
		return new BookServiceImplementation();
	}
	
	

}
