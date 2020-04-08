package com.capgemini.librarymanagementhibernate.factory;

import com.capgemini.librarymanagementhibernate.dao.UserDao;
import com.capgemini.librarymanagementhibernate.dao.UserDaoImplements;
import com.capgemini.librarymanagementhibernate.service.UserService;
import com.capgemini.librarymanagementhibernate.service.UserServiceImplements;

public class UserFactory {

	
	public static UserDao getUserDao() {
		return new UserDaoImplements();
	}
	
	public static UserService getUserService() {
		return new UserServiceImplements();
	}
	
	
}
