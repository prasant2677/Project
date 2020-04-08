package com.capgemini.librarymanagementhibernate.dao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.librarymanagementhibernate.dto.BookDTO;
import com.capgemini.librarymanagementhibernate.dto.BorrowedBooks;
import com.capgemini.librarymanagementhibernate.dto.RequestDTO;
import com.capgemini.librarymanagementhibernate.dto.UserDTO;
import com.capgemini.librarymanagementhibernate.exception.Exception;

import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;

public class UserDaoImplements implements UserDao{
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;

	@Override
	public boolean register(UserDTO info) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			UserDTO bean = manager.find(UserDTO.class, info.getEmail());
			if(bean== null) {
				System.out.println("Record Saved");
			} else {
				throw new Exception("User already Exist");
			}
			manager.persist(info);
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return false;
	}

	@Override
	public UserDTO auth(String email, String password) {
		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			UserDTO bean2= manager.find(UserDTO.class, email);
			bean2.setEmail(email);
			manager.persist(bean2);
			if(bean2.getPassword().equals(password)) {
				return bean2;
			}
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	@Override
	public boolean addBook(BookDTO book) {
		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookDTO bean = manager.find(BookDTO.class, book.getBookId());
			manager.persist(book);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();

		return false;
	}

	@Override
	public LinkedList<BookDTO> searchBookTitle(String bname) {

		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql="select m from bookBean m where bookName=:bName";
			TypedQuery<BookDTO> query=manager.createQuery(jpql, BookDTO.class);
			query.setParameter("bName", bname);
			LinkedList<BookDTO> list=(LinkedList<BookDTO>) query.getResultList();
			if(list!=null) {
				return list;
			}else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();

		return null;
	}

	@Override
	public LinkedList<BookDTO> searchBookAuthor(String bAuthor) {
		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql="select m from bookBean m where author=:author";
			TypedQuery<BookDTO> query=manager.createQuery(jpql, BookDTO.class);
			query.setParameter("author", bAuthor);
			LinkedList<BookDTO> list=(LinkedList<BookDTO>) query.getResultList();
			if(list!=null) {
				return list;
			}else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	@Override
	public LinkedList<BookDTO> searchBookType(int bid) {

		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql="select m from bookBean m where bookId=:id";
			TypedQuery<BookDTO> query=manager.createQuery(jpql, BookDTO.class);
			query.setParameter("id", bid);
			LinkedList<BookDTO> list=(LinkedList<BookDTO>) query.getResultList();
			if(list!=null) {
				return list;
			}else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	@Override
	public boolean updateBook(BookDTO bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeBook(int bid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LinkedList<BookDTO> getBooksInfo() {
		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql="select m from bookBean m ";
			TypedQuery<BookDTO> query=manager.createQuery(jpql, BookDTO.class);
			LinkedList<BookDTO> list=(LinkedList<BookDTO>) query.getResultList();
			if(list!=null) {
				return list;
			}else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}
	

	@Override
	public List<UserDTO> showUsers() {
		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql="select m from userBean m";
			TypedQuery<UserDTO> query=manager.createQuery(jpql, UserDTO.class);
			List<UserDTO> list = query.getResultList();
			if(list!=null) {
				return list;
			}else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	@Override
	public List<RequestDTO> showRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BorrowedBooks> borrowedBook(int uId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<BookDTO> getBookIds() {
		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql="select m from bookBean m ";
			TypedQuery<BookDTO> query=manager.createQuery(jpql, BookDTO.class);
			LinkedList<BookDTO> list=(LinkedList<BookDTO>) query.getResultList();
			if(list!=null) {
				return list;
			}else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}
	@Override
	public boolean bookIssue(int bId, int uId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean requestBook(int userId, int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean returnBook(int bId, int uId) {
		// TODO Auto-generated method stub
		return false;
	}



}
