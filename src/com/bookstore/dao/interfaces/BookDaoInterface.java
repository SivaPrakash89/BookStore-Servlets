package com.bookstore.dao.interfaces;

import java.util.List;

import com.bookstore.bean.Book;

public interface BookDaoInterface {
	public int addBook(String isbn, String title, String author, double price,long stock);
	public int deleteBook(String isbn);
	public List<Book> getAllBooks();
	public int updateStock(String isbn, long newStock);
	public Book getBook(String isbn);

}
