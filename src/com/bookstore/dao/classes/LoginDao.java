package com.bookstore.dao.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.bean.User;
import com.bookstore.dao.interfaces.LoginDaoInterface;

public class LoginDao implements LoginDaoInterface {
	private Connection connection;
	public LoginDao(){
		connection = DBConnection.getConnection();
	}
	@Override
	public User getUsername(String userName, String password) {
		String template = "select * from users where username=? and password=?";
		try {
			User user= null;
			PreparedStatement statement = connection.prepareStatement(template);
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
			return user;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
