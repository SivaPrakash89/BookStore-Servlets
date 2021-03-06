package com.bookstore.bean;

import java.io.Serializable;


public class User implements Serializable{
	
	private String userId;
	private String userName;
	private String password;
	private String role;

	public User() {

	}
	
	public User(String userId, String userName, String password, String role){
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
