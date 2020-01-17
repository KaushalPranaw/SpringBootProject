package com.app.demo.pojo;

import javax.persistence.*;

@Entity
public class Vendor {

	@Id
	private int id;
	private String email,name,password,city,phoneno,role;
	public Vendor() {
		super();
	}
	public Vendor(int id, String email, String name, String password, String city, String phoneno, String role) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.city = city;
		this.phoneno = phoneno;
		this.role = role;
	}
	public Vendor(String email, String name, String password, String city, String phoneno, String role) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.city = city;
		this.phoneno = phoneno;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", city=" + city
				+ ", phoneno=" + phoneno + ", role=" + role + "]";
	}
	 
	
	
}
