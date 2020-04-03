package com.capgemini.librarymanagementjdbc.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.capgemini.librarymanagementjdbc.dto.BookDTO;

public class RequestDTO implements Serializable {
	
	private int userId;
	private String name;
	private int bookId;
	private String bookName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
	
}
