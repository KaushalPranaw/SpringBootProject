package com.app.pojos;

import java.util.Date;

import javax.persistence.*;


@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String role, password;
	
	@Column(name="username")
	private String name;

	public Customer() {
		System.out.println("in cust");

	}

	public Customer(int id, String role, String password, String name) {
		super();
		this.id = id;
		this.role = role;
		this.password = password;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", role=" + role + ", password=" + password + ", name=" + name + "]";
	}

}
