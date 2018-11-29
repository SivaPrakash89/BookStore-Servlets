package com.bookstore.bean;

import java.io.Serializable;

public class Book implements Serializable{

	private String isbn;
	private String title;
	private String author;
	private double price;
	private long stock;
	
	public Book() {
		super();
	}

	public Book(String isbn, String title, String author, double price, long stock) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.stock = stock;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public String getIsbn() {
		return isbn;
	}
}
