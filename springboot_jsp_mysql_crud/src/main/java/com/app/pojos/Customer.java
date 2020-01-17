package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String email,password,name,address;
	private double salary;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	public Customer() 
	{
		System.out.println("in cust");	
	
	}
	 
	 

	public Customer(String email, String password, String name, String address, double salary, Date date) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.date = date;
	}



	public Customer(int id, String email, String password, String name, String address, double salary, Date date) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.date = date;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", address="
				+ address + ", salary=" + salary + ", date=" + date + "]";
	}



	 
	
	
	
	
}
