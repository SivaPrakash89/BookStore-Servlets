package com.bookstore.bean;

import java.io.Serializable;

public class Address implements Serializable{
	private String houseNo;
	private String street;
	private String area;
	private String city;
	private long pincode;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address(String houseNo, String street, String area, String city, long pincode) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
	}

	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	

}
