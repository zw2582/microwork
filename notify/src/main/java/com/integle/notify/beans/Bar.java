package com.integle.notify.beans;

import java.io.Serializable;

public class Bar implements Serializable{

	private int id;
	
	private String name;

	public Bar(){}
	public Bar(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Bar [id=" + id + ", name=" + name + "]";
	}
	
	
}
