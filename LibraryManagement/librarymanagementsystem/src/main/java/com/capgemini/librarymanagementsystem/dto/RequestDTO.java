package com.capgemini.librarymanagementsystem.dto;

import java.time.LocalDate;

public class RequestDTO {
	
	private BookDTO bookInfo;
	private StudentDTO studentInfo;
	private boolean isIssued;
	private boolean isReturned;
	private LocalDate issuedDate;
	private LocalDate returnedDate;
	
	public boolean isIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	public BookDTO getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookDTO bookInfo) {
		this.bookInfo = bookInfo;
	}
	public StudentDTO getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(StudentDTO studentInfo) {
		this.studentInfo = studentInfo;
	}

}
