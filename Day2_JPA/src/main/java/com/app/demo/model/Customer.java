package com.app.demo.model;

import javax.persistence.*;

@Entity
public class Customer {

	@Id
	private int id;
	private String name;
	private int phoneno;
 
	 
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
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
		return "Customer [id=" + id + ", name=" + name + ", phoneno=" + phoneno + "]";
	}
	
	
}
