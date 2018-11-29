package com.bookstore.listeners;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.bookstore.dao.classes.DBConnection;


/**
 * Application Lifecycle Listener implementation class AppContextListener
 *
 */
public class DbListener implements ServletContextListener {
	private String dbUrl;
	private String userName;
	private String password;
	private String dbClass;

    public void contextDestroyed(ServletContextEvent servletContextEvent)  { 
         Connection dbConnection = DBConnection.getConnection();
         try {
			dbConnection.close();
			System.out.println("Database Connection Closed..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void contextInitialized(ServletContextEvent servletContextEvent)  { 
    	ServletContext context = servletContextEvent.getServletContext();
    	dbUrl = context.getInitParameter("dbURL");
    	userName = context.getInitParameter("dbUser");
    	password = context.getInitParameter("dbPassword");
    	dbClass = context.getInitParameter("dbClass");
    	DBConnection connection = new DBConnection();
    	connection.setConnection(dbUrl,dbClass,userName,password);
    }
	
}
