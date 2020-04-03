package com.capgemini.librarymanagementsystem.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.database.DataBase;
import com.capgemini.librarymanagementsystem.dto.BookDTO;
import com.capgemini.librarymanagementsystem.dto.RequestDTO;
import com.capgemini.librarymanagementsystem.dto.StudentDTO;
import com.capgemini.librarymanagementsystem.exception.AdminException;
import com.capgemini.librarymanagementsystem.exception.StudentException;

public class StudentDAOImplementation implements StudentDAO{

	
	public boolean register(StudentDTO std) {
		
		for(StudentDTO dto : DataBase.STUDENTS) {
			if(dto.getS_email().equals(std.getS_email())) {
				return false;
			}
		}
		DataBase.STUDENTS.add(std);
		return true;
	}

	public StudentDTO auth(String email, String password) {

		for(StudentDTO dto : DataBase.STUDENTS) {
			if(dto.getS_email().equals(email) && dto.getS_password().equals(password)) {
				System.out.println("Login Successful");
				return dto;
			}
			
		}
		throw new StudentException("Invalid Email or Password");
		
	}

	public LinkedList<BookDTO> searchBookTitle(String bookName) {
		LinkedList<BookDTO> searchList=new LinkedList<BookDTO>();
		for(int i=0;i<=DataBase.BOOKS.size()-1;i++)
		{
			BookDTO retrievedBook=DataBase.BOOKS.get(i);
			String retrievedBookName=retrievedBook.getBook_name();
			if(bookName.equals(retrievedBookName))
			{
				searchList.add(retrievedBook);	
				return searchList;	
			}
		}
		if(searchList.size()==0)
		{
			throw new StudentException("Book is Not Found");
		}
		else
		{
			return searchList;
		}		

	}

	public LinkedList<BookDTO> searchBookAuthor(String bookAuthor) {
		LinkedList<BookDTO> searchList=new LinkedList<BookDTO>();
		for(int i=0;i<=DataBase.BOOKS.size()-1;i++)
		{
			BookDTO retrievedBook=DataBase.BOOKS.get(i);
			String retrievedBookAuthor=retrievedBook.getAuthor();
			if(bookAuthor.equals(retrievedBookAuthor))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new StudentException("Book is Not Found");
		}
		else
		{
			return searchList;
		}
		
	}

	public LinkedList<BookDTO> searchBookType(String bookType) {
		LinkedList<BookDTO> searchList=new LinkedList<BookDTO>();
		for(int i=0;i<=DataBase.BOOKS.size()-1;i++)
		{
			BookDTO retrievedBook=DataBase.BOOKS.get(i);
			String retrievedBookType=retrievedBook.getCategory();
			if(bookType.equals(retrievedBookType))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new StudentException("Book is Not Found");
		}
		else
		{
			return searchList;
		}
	}

	public LinkedList<Integer> getBookIds() {
		LinkedList<Integer> idList=new LinkedList<Integer>();
		for(int i=0;i<=DataBase.BOOKS.size()-1;i++)
		{
			BookDTO retrievedBook=DataBase.BOOKS.get(i);
			int retrievedBookId=retrievedBook.getBook_id();
			idList.add(retrievedBookId);
		}
		return idList;
	}

	public LinkedList<BookDTO> getBooksInfo() {
		
		return DataBase.BOOKS;
	}

	public RequestDTO requestBook(StudentDTO student, BookDTO book) {
		boolean flag = false, isRequestExists = false;
		RequestDTO requestInfo = new RequestDTO();
		StudentDTO userInfo2 = new StudentDTO();
		BookDTO bookInfo2 = new BookDTO();

		for (RequestDTO requestInfo2 : DataBase.REQUESTS) {
			if (book.getBook_id() == requestInfo2.getBookInfo().getBook_id()) {
				isRequestExists = true;

			}

		}

		if (!isRequestExists) {
			for (StudentDTO user : DataBase.STUDENTS) {
				if (user.getS_id() == student.getS_id()) {
					for (BookDTO book1 : DataBase.BOOKS) {
						if (book1.getBook_id() == book.getBook_id()) {
							userInfo2 = user;
							bookInfo2 = book1;
							flag = true;
						}
					}
				}
			}
			if (flag == true) {
				requestInfo.setBookInfo(bookInfo2);
				requestInfo.setStudentInfo(userInfo2);
				DataBase.REQUESTS.add(requestInfo);
				return requestInfo;
			}

		}

		throw new StudentException("Invalid request or you cannot request that book");
	}

	public RequestDTO returnBook(StudentDTO student, BookDTO book) {
		//RequestInfo info = new RequestInfo();
				for (RequestDTO requestInfo : DataBase.REQUESTS) {
					
					  if (requestInfo.getBookInfo().getBook_id() == book.getBook_id() &&
					  requestInfo.getStudentInfo().getS_id() == student.getS_id() &&
					  requestInfo.isIssued() == true) {
					 
//					if (requestInfo.isIssued() == true) {
						System.out.println("Returning Issued book only");
						requestInfo.setReturned(true);
					//	info = requestInfo;

						return requestInfo;
					}

				}

				throw new StudentException("Invalid return ");
			}
}
