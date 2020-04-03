package com.capgemini.librarymanagementjdbc.controller;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementjdbc.dao.UserDAO;
import com.capgemini.librarymanagementjdbc.dto.BookDTO;
import com.capgemini.librarymanagementjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementjdbc.dto.BorrowedBooks;
import com.capgemini.librarymanagementjdbc.dto.RequestDTO;
import com.capgemini.librarymanagementjdbc.dto.UserDTO;
import com.capgemini.librarymanagementjdbc.factory.UserFactory;
import com.capgemini.librarymanagementjdbc.service.UserService;
import com.capgemini.librarymanagementjdbc.validation.Validation;

public class ProjectController {

	public static void main(String[] args) {
		doReg();
	}
	public static void doReg() {
		boolean flag = false;

		int regId = 0; 
		String regFirstName = null; 
		//String regLastName = null; 
		String regMobile = null;
		String regEmail = null;
		String regPassword = null;

		int addBookId = 0;
		String addBookName = null; 
		String addBookAuthorName = null; 
		String addBookCategory = null;
		String addBookPublisher = null;

		int updateBookId = 0;
		String updateBookName = null; 
		String updateBookAuthorName = null; 
		String updateBookCategory = null;
		String updateBookPublisher = null;

		boolean loginStatus = true;
		Validation validation = new Validation();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("----------WELCOME TO LIBRARY-----------");
			System.out.println("Press 1 to Register");
			System.out.println("Press 2 to Login");
			System.out.println("Press 3 to EXIT");
			System.out.println("---------------------------------------");

			UserService service1= UserFactory.getUserService();
			//do {
			try {
				int choice = scanner.nextInt();
				switch(choice) {
				case 1:
					do {
						try {
							System.out.println("Enter ID :");
							regId = scanner.nextInt();
							validation.validatedId(regId);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Id should contains only digits");
						} catch (Exception e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);

					do {
						try {
							System.out.println("Enter First Name :");
							regFirstName = scanner.next();
							validation.validatedName(regFirstName);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Name should contains only Alphabates");
						} catch (Exception e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);
					
					do {
						try {
							System.out.println("Enter Email :");
							regEmail = scanner.next();
							validation.validatedEmail(regEmail);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Email should be proper ");
						} catch (Exception e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);

					do {
						try {
							System.out.println("Enter Password :");
							regPassword = scanner.next();
							validation.validatedPassword(regPassword);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Enter correct Password ");
						} catch (Exception e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);

					do {
						try {
							System.out.println("Enter Mobile :");
							regMobile = scanner.next();
							validation.validatedMobile(regMobile);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Mobile Number  should contains only numbers");
						} catch (Exception e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);
					System.out.println("Enter the role");
					String regRole = scanner.next();

					UserDTO ai = new UserDTO();
					ai.setUserId(regId);
					ai.setName(regFirstName);
					//ai.setLastName(regLastName);
					ai.setEmail(regEmail);
					ai.setPassword(regPassword);
					ai.setMobileno(regMobile);
					ai.setRole(regRole);
					boolean check=service1.register(ai);
					if(check) {
						System.out.println("Registered");
					}else {
						System.out.println("Already user is registered");
					}
					break;
				case 2:
					System.out.println("Enter Email for Login");
					String email=scanner.next();
					System.out.println("Enter Password");
					String password=scanner.next();
					try {
						UserDTO loginInfo=service1.login(email, password);
						if(loginInfo.getEmail().equals(email) && loginInfo.getPassword().equals(password)) {
							System.out.println("Logged In");
						}
						if(loginInfo.getRole().equals("admin")) {
							do {
								try {
									System.out.println("------------------------------------");
									System.out.println("Press 1 to Add book");
									System.out.println("Press 2 to Update the book");
									System.out.println("Press 3 to Remove book");
									System.out.println("Press 4 to get All the Book Ids");
									System.out.println("Press 5 to Search the Book by Id");
									System.out.println("Press 6 to Search the Book by Author");
									System.out.println("Press 7 to Search the Book by Title");
									System.out.println("Press 8 to Get All the Books Information");
									System.out.println("Press 9 to Issue Book");
									System.out.println("Press 10 to Show Users");
									System.out.println("Press 11 to Show Requests");
									System.out.println("Press 12 Receive Returned Book");
									System.out.println("Press 13 to check user book history");
									System.out.println("Press 14 to Log out");
									System.out.println("------------------------------------");
									int choice1 = scanner.nextInt();
									switch (choice1) {
									case 1:

										do {
											try {
												System.out.println("Enter Book-Id:");
												addBookId=scanner.nextInt();
												validation.validatedId(addBookId);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Id should contains only digits");
											} catch (Exception e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);


										do {
											try {
												System.out.println("Enter Book Name :");
												addBookName=scanner.next();
												validation.validatedName(addBookName);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (Exception e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter Author Name :");
												addBookAuthorName=scanner.next();
												validation.validatedName(addBookAuthorName);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (Exception e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter Category Name :");
												addBookCategory=scanner.next();
												validation.validatedName(addBookCategory);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (Exception e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter Publisher Name :");
												addBookPublisher=scanner.next();
												validation.validatedName(addBookPublisher);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (Exception e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);
										/*
										 * System.out.println("enter no of copies"); int addCopies = scanner.nextInt();
										 */
										BookDTO bi =new BookDTO();
										bi.setBookId(addBookId);
										bi.setBookName(addBookName);
										bi.setAuthor(addBookAuthorName);
										bi.setCategory(addBookCategory);
										bi.setPublishername(addBookPublisher);
										//bi.setCopies(addCopies);
										boolean check2=service1.addBook(bi);
										if(check2) {
											System.out.println("Added Book");
										}else {
											System.out.println("Book not added");
										}
										break;	
									case 2:
										do {
											try {
												System.out.println("Enter the updated id :");
												updateBookId=scanner.nextInt();
												validation.validatedId(updateBookId);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Id should contains only digits");
											} catch (Exception e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);


										do {
											try {
												System.out.println("Enter BookName to be Updtaed :");
												updateBookName=scanner.next();
												validation.validatedName(updateBookName);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (Exception e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter BookAuthor to be Updtaed :");
												updateBookAuthorName=scanner.next();
												validation.validatedName(updateBookAuthorName);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (Exception e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter BookCategory to be Updtaed :");
												updateBookCategory=scanner.next();
												validation.validatedName(updateBookCategory);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (Exception e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter BookPublisher to be Updtaed :");
												updateBookPublisher=scanner.next();
												validation.validatedName(updateBookPublisher);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (Exception e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);

										BookDTO bean2 = new BookDTO();
										bean2.setBookId(updateBookId);
										bean2.setBookName(updateBookName);
										bean2.setAuthor(updateBookAuthorName);
										bean2.setCategory(updateBookCategory);
										bean2.setPublishername(updateBookPublisher);

										boolean updated = service1.updateBook(bean2);
										if (updated) {
											System.out.println("Book is Updated");
										} else {
											System.out.println("Book is not Updated");
										}
										break;
									case 3:
										System.out.println("Enter Book-Id to Remove:");
										int removeId=scanner.nextInt();
										boolean check3=service1.removeBook(removeId);
										if(check3) {
											System.out.println("Removed Book");
										}else {
											System.out.println("Book not removed");
										}
										break;

									case 4:
										LinkedList<BookDTO> info = service1.getBookIds();
										for (BookDTO bookBean : info) {

											if (bookBean != null) {
												System.out.println("-------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBookId());
											} else {
												System.out.println("Books Ids is not present");
											}
										}
										break;
									case 5:
										System.out.println("Search the book by the Book-Id:");
										int id = scanner.nextInt();

										BookDTO bean4 = new BookDTO();
										bean4.setBookId(id);
										List<BookDTO> bookid = service1.searchBookById(id);
										for (BookDTO bookBean : bookid) {

											if (bookBean != null) {
												System.out.println("----------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBookId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublishername());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("----------------------------------------");
											} else {
												System.out.println("No books are available written by this author");
											}
										}
										break;
									case 6:
										System.out.println("Search the book by the Author Name:");
										String author = scanner.next();

										BookDTO bean5 = new BookDTO();
										bean5.setAuthor(author);
										List<BookDTO> bookauthor = service1.searchBookByAuthor(author);
										for (BookDTO bookBean : bookauthor) {

											if (bookBean != null) {
												System.out.println("----------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBookId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublishername());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("----------------------------------------");
											} else {
												System.out.println("No books are available written by this author");
											}
										}
										break;
									case 7:
										System.out.println("  Search the book by the Book_Title :");
										String btitle = scanner.next();

										BookDTO bean6 = new BookDTO();
										bean6.setAuthor(btitle);
										List<BookDTO> booktitle = service1.searchBookByTitle(btitle);
										for (BookDTO bookBean : booktitle) {	
											if (bookBean != null) {
												System.out.println("----------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBookId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublishername());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("----------------------------------------");
											} else {
												System.out.println("No books are available with this title.");
											}
										}
										break;

									case 8:
										LinkedList<BookDTO> info1 = service1.getBooksInfo();
										for (BookDTO bookBean : info1) {

											if (bookBean != null) {
												System.out.println("-------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBookId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublishername());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("----------------------------------------------");
											} else {
												System.out.println("Books info is not present");
											}
										}
										break;

									case 9:
										System.out.println("Enter Book Id");
										int issueId=scanner.nextInt();
										System.out.println("Enter User Id");
										int userId = scanner.nextInt();
										boolean check4=service1.issueBook(issueId,userId);
										if(check4) {
											System.out.println("-----------------------------------------------");
											System.out.println("Book Issued");
										}else {
											System.out.println("-----------------------------------------------");
											System.out.println("Book not issued");
										}
										break;
									case 10:
										try {
											System.out.println("--------Users of Library are------------");

											List<UserDTO> usersInfo = service1.showUsers();
											for (UserDTO usersBean : usersInfo) {
												if (usersBean != null) {
													System.out.println("---------------------------------------");
													System.out.println("User_Id is ---->"+usersBean.getUserId());
													System.out.println("User Firstname is ---->"+usersBean.getName());
													//System.out.println("User Lastname is ---->"+usersBean.getLastName());
													System.out.println("User Email is ---->"+usersBean.getEmail());
													//System.out.println("User Password is ---->"+usersBean.getPassword());
													System.out.println("User Mobile is ---->"+usersBean.getMobileno());
													System.out.println("User Role is ---->"+usersBean.getRole());
													System.out.println("---------------------------------------");
												} else {
													System.out.println("No user are there");
												}
											}
										} catch (Exception e) {
											System.out.println("No Users present in library");
										}
										break;
									case 11:
										try {
											System.out.println("*****Requests for Books are *****");
											System.out.println("-------------------------------------");
											List<RequestDTO> requestInfos = service1.showRequest();
											for (RequestDTO infos : requestInfos) {
												System.out.println("---------------------------------------");
												System.out.println("Book id ---------- " + infos.getBookId());
												System.out.println("User id----------- " + infos.getUserId());
												/*
												 * System.out.println("Book Issued ------" + infos.getbId());
												 * System.out.println("Book Returned------" + infos.getBookName());
												 */
												System.out.println("---------------------------------------");

											}
										} catch (Exception e) {
											System.out.println("no books present in library");
										}
										break;
									case 12:
										System.out.println("******Receive Returned Book******");
										System.out.println("-----------------------");
										System.out.println("Enter User Id");
										int user1 = scanner.nextInt();
										System.out.println("Enter Book Id");
										int book1 = scanner.nextInt();

										UserDTO user = new UserDTO();
										BookDTO book = new BookDTO();
										user.setUserId(user1);
										book.setBookId(book1);
										boolean isReceive = service1.returnBook(user1, book1);
										if(isReceive) {
											System.out.println(" Received Returned book");
										}else {
											System.out.println("Invalid ! Admin unable to receive");
										}
										break;

									case 13:
										System.out.println("Enter the User Id");
										int user_Id = scanner.nextInt();

										List<BookIssueDetails> uid = service1.bookHistoryDetails(user_Id);
										for (BookIssueDetails issueDetails : uid) {
											if(issueDetails != null) {
												System.out.println("-----------------------------------------------");
												System.out.println("No of books Borrowed :"+issueDetails.getUserId());
											} else {
												System.out.println("-----------------------------------------------");
												System.out.println("Respective user hasn't borrowed any books");
											}
										}
										break;

									case 14:
										doReg();

									default:
										System.out.println("Invalid Choice");
										break;
									}
								}   catch (InputMismatchException ex)   {
									System.out.println("Incorrect entry. Please input only a positive integer.");
									scanner.nextLine();
								}
							}while(true);
						}
						else if(loginInfo.getRole().equals("student")) {
							do {
								try {
									System.out.println("------------------------------------");
									System.out.println("Press 1 to Get All the Book-Ids");
									System.out.println("Press 2 to Search Book by Book-Id");
									System.out.println("Press 3 to Search Book by Author");
									System.out.println("Press 4 to Search Book by Title");
									System.out.println("Press 5 to Get All the Books Info");
									System.out.println("Press 6 to Request Book");
									System.out.println("Press 7 to View the Books Borrowed");
									System.out.println("Press 8 to Return Book");
									System.out.println("Press 9 to Main");
									System.out.println("------------------------------------");

									int choice2 = scanner.nextInt();
									switch (choice2) {
									case 1:
										LinkedList<BookDTO> info = service1.getBookIds();
										for (BookDTO bookBean : info) {

											if (bookBean != null) {
												System.out.println("-------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBookId());
											} else {
												System.out.println("Books Ids is not present");
											}
										}
										break;
									case 2:
										System.out.println("Search the Book by the Book-Id:");
										int id = scanner.nextInt();

										BookDTO bean4 = new BookDTO();
										bean4.setBookId(id);
										List<BookDTO> bookid = service1.searchBookById(id);
										for (BookDTO bookBean : bookid) {

											if (bookBean != null) {
												System.out.println("----------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBookId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublishername());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("----------------------------------------");
											} else {
												System.out.println("No books are available written by this author");
											}
										}
										break;
									case 3:
										System.out.println("Search the Book by the Author Name :");
										String author = scanner.next();

										BookDTO bean2 = new BookDTO();
										bean2.setAuthor(author);
										List<BookDTO> bookauthor = service1.searchBookByAuthor(author);
										for (BookDTO bookBean : bookauthor) {

											if (bookBean != null) {
												System.out.println("---------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBookId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublishername());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("---------------------------------------");
											} else {
												System.out.println("No books are available written by this author");
											}
										}
										break;
									case 4:
										System.out.println("Search the book by the Book Title :");
										String btitle = scanner.next();

										BookDTO bean3 = new BookDTO();
										bean3.setAuthor(btitle);
										List<BookDTO> booktitle = service1.searchBookByAuthor(btitle);
										for (BookDTO bookBean : booktitle) {	
											if (bookBean != null) {
												System.out.println("---------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBookId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublishername());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("---------------------------------------");
											} else {
												System.out.println("No books are available with this title.");
											}
										}
										break;
									case 5:
										LinkedList<BookDTO> info1 = service1.getBooksInfo();
										for (BookDTO bookBean : info1) {

											if (bookBean != null) {
												System.out.println("---------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBookId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublishername());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("---------------------------------------");
											} else {
												System.out.println("Books info is not presernt");
											}
										}
										break;
									case 6:
										System.out.println("Enter the Book Id:");
										int reqBookId= scanner.nextInt();
										System.out.println("Enter the user Id:");
										int reqUserId = scanner.nextInt();
										boolean requested = service1.request(reqUserId,reqBookId);
										if (requested != false) {
											System.out.println("-----------------------------------------------");
											System.out.println("Book is Requested");
										} else {
											System.out.println("-----------------------------------------------");
											System.out.println("Book is not Requested");
										}	
										break;
									case 7:
										System.out.println("Enter the user Id");
										int user_Id = scanner.nextInt();
										List<BorrowedBooks> borrowedBookList = service1.borrowedBook(user_Id);
										for (BorrowedBooks bookBean : borrowedBookList) {

											if (bookBean != null) {
												System.out.println("-----------------------------------------------");
												System.out.println("User_Id is-->"+bookBean.getUserId());
												System.out.println("Book_Id is-->"+bookBean.getBookId());
												System.out.println("Email Id is-->"+bookBean.getEmail());
											} else {
												System.out.println("-----------------------------------------------");
												System.out.println("No books are borrowed by the user");
											}
										}
										break;
									case 8:

										System.out.println("*****Returning a Book*****");
										System.out.println("Enter the Book-id to return :");
										int returnId= scanner.nextInt();
										System.out.println("Enter User-Id");
										int userId = scanner.nextInt();				
										boolean returned = service1.returnBook(returnId,userId);
										if (returned != false) {
											System.out.println("-----------------------------------------------");
											System.out.println("Book is Returned");
										} else {
											System.out.println("-----------------------------------------------");
											System.out.println("Book is not Returned");
										}	
										break;

									case 9:
										doReg();
									default:
										break;
									}
								}   catch (InputMismatchException ex)   {
									System.out.println("Incorrect entry. Please input only a positive integer.");
									scanner.nextLine();
								}
							} while(true);
						}

					}catch(Exception e) {
						System.out.println("Invalid Credentials");
						System.out.println("Try login again,Press 2 to login");
						//scanner.nextLine();
					}
					break;
				default:
					System.out.println("Exit");
					loginStatus = false;
				}
			} catch (InputMismatchException ex)   {
				System.out.println("Incorrect entry. Please input only a positive integer.");
				scanner.nextLine();
			}

		} while(loginStatus);
		//	}while(true);

	}
}
