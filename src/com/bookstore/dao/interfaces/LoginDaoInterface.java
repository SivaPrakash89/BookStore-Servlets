package com.bookstore.dao.interfaces;


import com.bookstore.bean.User;

public interface LoginDaoInterface {

	public User getUsername(String userName, String password);
}
