package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BookDTO;

public interface BookDAO {
	
	boolean addBook(BookDTO dto);
	BookDTO issueBook(String book_name,int book_id);
	boolean returnBook(int book_id);
	List<BookDTO> search(int book_id);
	boolean delete(String book_name,int book_id);
    
}
