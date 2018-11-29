package com.bookstore.services;

import com.bookstore.bean.User;
import com.bookstore.dao.classes.LoginDao;

public class LoginService {
	
	public User validateUser(String userName, String password){
		LoginDao loginDao = new LoginDao();
		return loginDao.getUsername(userName, password);
	}

}
