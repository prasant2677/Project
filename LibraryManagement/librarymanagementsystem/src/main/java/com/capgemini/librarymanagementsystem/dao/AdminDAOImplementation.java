package com.capgemini.librarymanagementsystem.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.database.DataBase;
import com.capgemini.librarymanagementsystem.dto.AdminDTO;
import com.capgemini.librarymanagementsystem.dto.BookDTO;
import com.capgemini.librarymanagementsystem.dto.RequestDTO;
import com.capgemini.librarymanagementsystem.dto.StudentDTO;
import com.capgemini.librarymanagementsystem.exception.AdminException;

public class AdminDAOImplementation implements AdminDAO {

	public boolean register(AdminDTO admin) {

		for(AdminDTO adm : DataBase.ADMINS) {
			if(adm.getA_email().equals(admin.getA_email())) {
				return false;
			}
		}
		DataBase.ADMINS.add(admin);
		return true;
	}

	public AdminDTO auth(String email, String password) {

		for(AdminDTO adm : DataBase.ADMINS) {
			if(adm.getA_email().equals(email) && adm.getA_password().equals(password)) {
				System.out.println("Login Successful");
				return adm;
			}
		}
		throw new AdminException("Invalid Credentials");
		}


	public boolean addBook(BookDTO book) {
		for(BookDTO bookDto : DataBase.BOOKS) {
			if(bookDto.getBook_id() == book.getBook_id()  ) {
				return false;
			}
		}
		DataBase.BOOKS.add(book);
		return true;
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
			throw new AdminException("Book is Not Found");
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
			throw new AdminException("Book is Not Found");
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
			throw new AdminException("Book is Not Found");
		}
		else
		{
			return searchList;
		}	
		
	}

	public int updateBook(int bookId) {

		int status=0;
		for(int i=0;i<=DataBase.BOOKS.size()-1;i++)
		{
			BookDTO retrievedBook=DataBase.BOOKS.get(i);
			int retrievedId=retrievedBook.getBook_id();
			if(bookId==retrievedId)
			{
				status++;
				break;
			}
		}
		 throw new AdminException("Book is Not Found");
		
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

	public boolean removeBook(int bookId) {
		boolean status=false;
		for(int i=0;i<=DataBase.BOOKS.size()-1;i++)
		{
			BookDTO retrievedBook=DataBase.BOOKS.get(i);
			int retrievedId=retrievedBook.getBook_id();
			if(bookId==retrievedId)
			{
				status=true;
				DataBase.BOOKS.remove(i);
				
			}
		}
		return status;
	}

	public List<StudentDTO> showStudents() {
		List<StudentDTO> show = new LinkedList<StudentDTO>();

		for (StudentDTO info : DataBase.STUDENTS) {
			info.getS_id();
			info.getS_name();
			info.getS_email();
			info.getS_booksBorrowed();
			show.add(info);
		}
		return show;
	}
		
	public List<RequestDTO> showRequests() {
		List<RequestDTO> show = new LinkedList<RequestDTO>();
		for (RequestDTO requestInfo : DataBase.REQUESTS) {
			requestInfo.getBookInfo();
			requestInfo.getStudentInfo();
			requestInfo.isIssued();
			requestInfo.isReturned();
			show.add(requestInfo);
		}
		return show;
	}
		

	public boolean bookIssue(StudentDTO student, BookDTO book) {
		boolean isValid = false;

//		UserInfo userInfo = new UserInfo();
//		BookInfo bookInfo = new BookInfo();
		RequestDTO requestInfo = new RequestDTO();

		int noOfBooksBorrowed = student.getS_booksBorrowed();
		for (RequestDTO info : DataBase.REQUESTS) {
			if (info.getStudentInfo().getS_id() == student.getS_id()) {
				if (info.getBookInfo().getBook_id() == book.getBook_id()) {
					requestInfo = info;

					isValid = true;

				}
			}
		}

		if (isValid)

		{
			for (BookDTO info2 : DataBase.BOOKS) {
				if (info2.getBook_id() == book.getBook_id()) {
					book = info2;
				}

			}

			for (StudentDTO studentInfo : DataBase.STUDENTS) {
				if (studentInfo.getS_id() == student.getS_id()) {
					student = studentInfo;
					noOfBooksBorrowed = student.getS_booksBorrowed();

				}

			}

			if (noOfBooksBorrowed < 3) {
				
				boolean isRemoved = DataBase.BOOKS.remove(book);
				if (isRemoved) {
					
					noOfBooksBorrowed++;
					System.out.println(noOfBooksBorrowed);
					student.setS_booksBorrowed(noOfBooksBorrowed);
					// DataBase.REQUESTDB.remove(requestInfo);
					requestInfo.setIssued(true);
					return true;
				} else {
					throw new AdminException("Book can't be borrowed");
				}

			} else {
				throw new AdminException("Student Exceeds maximum limit");
			}

		} else {
			throw new AdminException("Book data or Student data is incorrect");

		}
	}
		
	public boolean isBookReceived(StudentDTO student, BookDTO book) {
		boolean isValid = false;
		RequestDTO requestInfo1 = new RequestDTO();
		for (RequestDTO requestInfo : DataBase.REQUESTS) {

			if (requestInfo.getBookInfo().getBook_id() == book.getBook_id()
					&& requestInfo.getStudentInfo().getS_id() == student.getS_id() && requestInfo.isReturned() == true) {
				isValid = true;
				requestInfo1 = requestInfo;
				//DataBase.REQUESTDB.remove(requestInfo);
			}
		}
		if (isValid) {
//			for (BookInfo info2 : DataBase.BOOKDB) {
//				if (info2.getIsbn() == book.getIsbn()) {
//					//book = info2;
//					DataBase.BOOKDB.add(info2);
//				}
//			}
			
			book.setAuthor(requestInfo1.getBookInfo().getAuthor());
			book.setBook_name(requestInfo1.getBookInfo().getBook_name());
			//book.setPrice(requestInfo1.getBookInfo().getPrice());
			DataBase.BOOKS.add(book);
			DataBase.REQUESTS.remove(requestInfo1);
			

			for (StudentDTO userInfo2 : DataBase.STUDENTS) {
				if (userInfo2.getS_id() == student.getS_id()) {
					student = userInfo2;
				}

			}

			
			int noOfBooksBorrowed = student.getS_booksBorrowed();
			noOfBooksBorrowed--;
			student.setS_booksBorrowed(noOfBooksBorrowed);
			return true;

		}

		return false;
	}
		
	

}
