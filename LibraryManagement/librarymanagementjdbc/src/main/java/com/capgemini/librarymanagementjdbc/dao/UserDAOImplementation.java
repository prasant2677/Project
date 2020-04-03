package com.capgemini.librarymanagementjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.capgemini.librarymanagementjdbc.dto.BookDTO;
import com.capgemini.librarymanagementjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementjdbc.dto.BorrowedBooks;
import com.capgemini.librarymanagementjdbc.dto.RequestDTO;
import com.capgemini.librarymanagementjdbc.dto.UserDTO;

public class UserDAOImplementation implements UserDAO {

	@Override
	public boolean register(UserDTO user) {

		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));) {
				String query = "insert into user_db values(?,?,?,?,?,?)";
				try (PreparedStatement pstmt = conn.prepareStatement(query);) {

					pstmt.setInt(1,user.getUserId());
					pstmt.setString(2, user.getName());
					pstmt.setString(3, user.getPassword());
					pstmt.setString(4, user.getEmail());
					pstmt.setString(5,user.getMobileno());
					pstmt.setString(6, user.getRole());

					int count = pstmt.executeUpdate();
					if(user.getEmail().isEmpty() && count==0) {
						return false;
					} else {
						return true;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();

			return false;
		}
	}

	@Override
	public UserDTO login(String email, String password) {

		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));)
			{
				String query = "select * from user_db where email=? and password=?; ";
				try (PreparedStatement pstmt = conn.prepareStatement(query);) {
					pstmt.setString(1, email);
					pstmt.setString(2, password);
					ResultSet set = pstmt.executeQuery(); 

					if(set.next()) {
						UserDTO dto = new UserDTO();
						dto.setEmail(set.getString("email"));
						dto.setPassword(set.getString("password"));
						dto.setRole(set.getString("role"));
						return dto;

					} else{
						return null;
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}


	@Override
	public boolean addBook(BookDTO book) {
		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));)
			{
				String query = "insert into book_db values(?,?,?,?,?)";
				try (PreparedStatement pstmt = conn.prepareStatement(query);) {
					pstmt.setInt(1,book.getBookId());
					pstmt.setString(2, book.getBookName());
					pstmt.setString(3, book.getAuthor());
					pstmt.setString(4, book.getCategory());
					pstmt.setString(5,book.getPublishername());		
					int count=pstmt.executeUpdate();
					if(count!=0) {
						return true;
					} else {
						return false;
					}
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateBook(BookDTO book) {

		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));)
			{
				String query = "update book_db set bookName=? where bookId=?";
				try (PreparedStatement pstmt = conn.prepareStatement(query);) {
					pstmt.setInt(1,book.getBookId());
					pstmt.setString(2, book.getBookName());

					int count = pstmt.executeUpdate();
					if(count!=0) {
						return true;
					} else {
						return false;
					}
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public LinkedList<BookDTO> searchBookById(int bId) {
		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));)
			{
				String query = "select * from book_db where bookId=?";
				try (PreparedStatement pstmt = conn.prepareStatement(query);) {
					pstmt.setInt(1,bId);
					try	(ResultSet rs=pstmt.executeQuery();) {
						LinkedList<BookDTO> beans = new LinkedList<BookDTO>();
						while(rs.next()) {
							BookDTO bean = new BookDTO();
							bean.setBookId(rs.getInt("bookId"));
							bean.setBookName(rs.getString("bookName"));
							bean.setAuthor(rs.getString("author"));
							bean.setCategory(rs.getString("category"));
							bean.setPublishername(rs.getString("publisher"));
							beans.add(bean);
						}
						return beans;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public LinkedList<BookDTO> searchBookByTitle(String bookName) {

		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));)
			{
				String query = "select * from book_db where bookName=?";
				try (PreparedStatement pstmt = conn.prepareStatement(query);) 
				{
					pstmt.setString(1,bookName);
					try	(ResultSet rs=pstmt.executeQuery();) {
						LinkedList<BookDTO> beans = new LinkedList<BookDTO>();
						while(rs.next()) {
							BookDTO bean = new BookDTO();
							bean.setBookId(rs.getInt("bookId"));
							bean.setBookName(rs.getString("bookName"));
							bean.setAuthor(rs.getString("author"));
							bean.setCategory(rs.getString("category"));
							bean.setPublishername(rs.getString("publisher"));
							beans.add(bean);
						}
						return beans;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}	

	}

	@Override
	public LinkedList<BookDTO> searchBookByAuthor(String author) {

		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));) {
				String query = "select * from book_db where author=?";
				try (PreparedStatement pstmt = conn.prepareStatement(query);) {
					pstmt.setString(1,author);
					try	(ResultSet rs=pstmt.executeQuery();) {
						LinkedList<BookDTO> beans = new LinkedList<BookDTO>();
						while(rs.next()) {
							BookDTO bean = new BookDTO();
							bean.setBookId(rs.getInt("bookId"));
							bean.setBookName(rs.getString("bookName"));
							bean.setAuthor(rs.getString("author"));
							bean.setCategory(rs.getString("category"));
							bean.setPublishername(rs.getString("publisher"));
							beans.add(bean);
						}
						return beans;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public LinkedList<BookDTO> getBooksInfo() {
		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));)
			{
				String query = "select * from book_db";
				try (Statement stmt = conn.createStatement();) {

					try	(ResultSet rs=stmt.executeQuery(query);) {
						LinkedList<BookDTO> beans = new LinkedList<BookDTO>();
						while(rs.next()) {
							BookDTO bean = new BookDTO();
							bean.setBookId(rs.getInt("bookId"));
							bean.setBookName(rs.getString("bookName"));
							bean.setAuthor(rs.getString("author"));
							bean.setCategory(rs.getString("category"));
							bean.setPublishername(rs.getString("publisher"));

							beans.add(bean);
						}
						return beans;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean request(int userId, int bookId) {

		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));
					PreparedStatement pstmt = conn.prepareStatement("select count(*) as userId from borrowed_books where userId=? and bookId=? and email=(select email from user_db where id=?)");) {
				pstmt.setInt(1, userId);
				pstmt.setInt(2, bookId);
				pstmt.setInt(3, userId);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					int isBookExists = rs.getInt("userId");
					if(isBookExists==0) {
						try(PreparedStatement pstmt1 = conn.prepareStatement("select count(*) as userId from book_issue_db where userId=?");) {
							pstmt1.setInt(1, userId);
							rs=pstmt1.executeQuery();
							if(rs.next()) {
								int noOfBooksBorrowed = rs.getInt("userId");
								if(noOfBooksBorrowed<3) {
									try(PreparedStatement pstmt2 = conn.prepareStatement("insert into request_details values(?,(select name from user_db where id=?)"
											+ ",?,(select bookName from book_db where bookId=?),(select email from user_db where id=?))");){
										pstmt2.setInt(1,userId);
										pstmt2.setInt(2, userId);
										pstmt2.setInt(3, bookId);
										pstmt2.setInt(4, bookId);
										pstmt2.setInt(5, userId);
										int count = pstmt2.executeUpdate();
										if(count != 0) {
											return true;
										}else {
											return false;
										}
									}				 
								}else {
									throw new Exception("no Of books limit has crossed");
								}
							}else {
								throw new Exception("no of books limit has crossed");
							}		
						}				
					}else{
						throw new Exception("You have already borrowed the requested book");
					}		
				}else {
					throw new Exception("You have already borrowed the requested book");
				}			
			}
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean issueBook(int bId, int uId) {

		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));)
			{
				try (PreparedStatement pstmt = conn.prepareStatement("select * from request_details where userId=? and bookId=? and email=(select email from user_db where id=?)")) {
					pstmt.setInt(1, uId);
					pstmt.setInt(2, bId);
					pstmt.setInt(3, uId);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {
						try(PreparedStatement pstmt1 = conn.prepareStatement("insert into book_issue_db values(?,?,?,?)");){
							pstmt1.setInt(1, bId);
							pstmt1.setInt(2, uId);
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
							Calendar cal = Calendar.getInstance();
							String issueDate = sdf.format(cal.getTime());
							pstmt1.setDate(3, java.sql.Date.valueOf(issueDate));
							cal.add(Calendar.DAY_OF_MONTH, 7);
							String returnDate = sdf.format(cal.getTime());
							pstmt1.setDate(4, java.sql.Date.valueOf(returnDate));
							int count=pstmt1.executeUpdate();
							if(count != 0) {	
								try(PreparedStatement pstmt2 = conn.prepareStatement("insert into borrowed_books values(?,?,(select email from user_db where id=?))")){
									pstmt2.setInt(1, uId);
									pstmt2.setInt(2, bId);
									pstmt2.setInt(3, uId);
									int isBorrowed = pstmt2.executeUpdate();
									if(isBorrowed != 0) {
										return true;
									}else {
										return false;
									}
								}
							} else {
								throw new Exception("Book Not issued");
							}					
						}
					} else {
						throw new Exception("The respective user have not placed any request");
					}			
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<BorrowedBooks> borrowedBook(int uId) {
		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));)
			{
				try (PreparedStatement pstmt = conn.prepareStatement("select * from borrowed_books where userId=?");) {
					pstmt.setInt(1, uId);
					ResultSet rs=pstmt.executeQuery();
					LinkedList<BorrowedBooks> beans = new LinkedList<BorrowedBooks>();
					while(rs.next()) {
						BorrowedBooks listOfbooksBorrowed = new BorrowedBooks();
						listOfbooksBorrowed.setUserId(rs.getInt("userId"));
						listOfbooksBorrowed.setBookId(rs.getInt("bookId"));
						listOfbooksBorrowed.setEmail(rs.getString("email"));
						beans.add(listOfbooksBorrowed);
					} 
					return beans;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean returnBook(int bId,int uId) {
		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));) {
				try(PreparedStatement pstmt = conn.prepareStatement("delete from book_issue_db where bookId=? and userId=?");) {
					pstmt.setInt(1,bId);
					pstmt.setInt(2,uId);
					int count =  pstmt.executeUpdate();
					if(count != 0) {
						try(PreparedStatement pstmt1 = conn.prepareStatement("delete from borrowed_books where bookId=? and userId=?");) {
							pstmt1.setInt(1, bId);
							pstmt1.setInt(2, uId);
							int isReturned = pstmt1.executeUpdate();
							if(isReturned != 0 ) {
								return true;
							}else {
								return false;
							}
						}
					} else {
						return false;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}	

	}

	@Override
	public boolean removeBook(int bId) {

		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));)
			{
				String query = "delete from book_db where bookId=?";
				try (PreparedStatement pstmt = conn.prepareStatement(query);) {
					pstmt.setInt(1,bId);
					int count=pstmt.executeUpdate();
					if(count!=0) {
						return true;
					} else {
						return false;
					}
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public LinkedList<UserDTO> showUsers() {

		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));)
			{
				String query = "select * from user_db";
				try (Statement stmt = conn.createStatement();) {

					try	(ResultSet rs=stmt.executeQuery(query);) {
						LinkedList<UserDTO> beans = new LinkedList<UserDTO>();
						while(rs.next()) {
							
							UserDTO bean = new UserDTO();
							bean.setUserId(rs.getInt("id"));
							bean.setName(rs.getString("name"));
							bean.setEmail(rs.getString("email"));
							bean.setRole(rs.getString("role"));
							beans.add(bean);
						}
						return beans;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public LinkedList<RequestDTO> showRequest() {

		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));) {
				String query = "select * from request_details;";
				try (PreparedStatement pstmt = conn.prepareStatement(query);) {

					try (ResultSet rs = pstmt.executeQuery(query);) {
						LinkedList<RequestDTO> beans = new LinkedList<RequestDTO>();
						while (rs.next()) {
							RequestDTO book = new RequestDTO();
							book.setUserId(rs.getInt("userId"));
							book.setName(rs.getString("name"));
							book.setBookId(rs.getInt("bookId"));
							book.setBookName(rs.getString("bookName"));
							beans.add(book);
						}
						return beans;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			//return false;
		}
		return null;
		
		
	}

	@Override
	public LinkedList<BookIssueDetails> bookHistoryDetails(int uId) {
		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));) {
				try (PreparedStatement pstmt = conn.prepareStatement("select count(*) as userId from book_issue_db where userId=?");) {
					pstmt.setInt(1, uId);
					ResultSet rs=pstmt.executeQuery();
					LinkedList<BookIssueDetails> beans = new LinkedList<BookIssueDetails>();
					while(rs.next()) {
						BookIssueDetails issueDetails = new BookIssueDetails();
						issueDetails.setUserId(rs.getInt("userId"));
						beans.add(issueDetails);
					} 
					return beans;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}

	@Override
	public LinkedList<BookDTO> getBookIds() {
		try (FileInputStream input = new FileInputStream("db.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			Class.forName(properties.getProperty("url")).newInstance();
			String dburl = properties.getProperty("dburl");
			try(Connection conn=DriverManager.getConnection(dburl, properties.getProperty("user"),
					properties.getProperty("password"));)
			{
				String query = "select distinct bookId from book_db";
				try (Statement stmt = conn.createStatement();) {

					try	(ResultSet rs=stmt.executeQuery(query);) {
						LinkedList<BookDTO> beans = new LinkedList<BookDTO>();
						while(rs.next()) {
							BookDTO bean = new BookDTO();
							bean.setBookId(rs.getInt("bookId"));
							beans.add(bean);
						}
						return beans;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}

		
	}

}
