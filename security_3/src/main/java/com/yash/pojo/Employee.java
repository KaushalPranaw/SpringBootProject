package com.yash.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empId;
	private String name;
	private String password;
	private String role;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Employee(Integer empId, String name, String password, String role) {
		super();
		this.empId = empId;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	public Employee()
	{
		
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
}
