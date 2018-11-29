package com.bookstore.dao.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.bean.Book;
import com.bookstore.dao.interfaces.BookDaoInterface;

public class BookDao implements BookDaoInterface {
	private Connection connection;
	public BookDao(){
		connection = DBConnection.getConnection();
	}
	@Override
	public int addBook(String isbn, String title, String author, double price, long stock) {
		String template = "insert into book values(?,?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(template);
			statement.setString(1, isbn);
			statement.setString(2, title);
			statement.setString(3, author);
			statement.setDouble(4, price);
			statement.setLong(5, stock);
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBook(String isbn) {
		String template = "delete from book where isbn = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(template);
			statement.setString(1, isbn);
			return statement.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Book> getAllBooks() {
		String template = "select * from book";
		try {
			List<Book> b = new ArrayList<>();
			PreparedStatement statement = connection.prepareStatement(template);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				b.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getLong(5)));
			}
			return b;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateStock(String isbn, long newStock) {
		String template = "update book set stock = stock + ? where isbn = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(template);
			statement.setLong(1, newStock);
			statement.setString(2, isbn);
			return statement.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Book getBook(String isbn) {
		String template = "select * from book where isbn = ?";
		try {
			Book book = null;
			PreparedStatement statement = connection.prepareStatement(template);
			statement.setString(1, isbn);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				book = new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getLong(5));
			}
			return book;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
