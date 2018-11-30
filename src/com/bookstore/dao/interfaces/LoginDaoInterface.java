package com.bookstore.dao.interfaces;


import com.bookstore.bean.Address;
import com.bookstore.bean.User;

public interface LoginDaoInterface {

	public User getUsername(String userName, String password);
	public Address getAddress(String userId);
	public Address updateAddress(String userId, String houseNo, String street, String area, String city, long pincode);
}
