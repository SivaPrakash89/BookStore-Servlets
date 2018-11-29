package com.bookstore.dao.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection;
	public DBConnection(){

	}
	
	public void setConnection(String dbUrl, String dbClass, String dbUsername, String dbPassword){
		try {
			Class.forName(dbClass);
			connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			if(connection != null)
				System.out.println("DB Initialized");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		this.connection = connection;
	}
	
	public static Connection getConnection(){
		
		return connection;
	}	

}
