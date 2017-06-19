package com.integle.notify.beans;

import java.io.Serializable;

public class Order implements Serializable {

	private int id;
	private String number;
	private float price;
	public int getId() {
		return id;
	}
	
	public Order(){}
	
	public Order(int id, String number, float price) {
		super();
		this.id = id;
		this.number = number;
		this.price = price;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", price=" + price + "]";
	}
	
	
}
