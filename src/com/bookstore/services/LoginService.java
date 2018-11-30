package com.bookstore.services;

import com.bookstore.bean.Address;
import com.bookstore.bean.User;
import com.bookstore.dao.classes.LoginDao;

public class LoginService {
	LoginDao loginDao = new LoginDao();
	public User validateUser(String userName, String password){
		
		return loginDao.getUsername(userName, password);
	}
	
	public Address getAddress(String userId){
		return loginDao.getAddress(userId);
		
	}

}
