package com.yash.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Contact {

	private int id;
	private String code;
	private String num;

	private Employee employee;

	public Contact() {
		System.out.println(" in const " + getClass().getName());
	}

	public Contact(int id, String code, String num, Employee employee) {
		super();
		this.id = id;
		this.code = code;
		this.num = num;
		this.employee = employee;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "e_id")
	@JsonBackReference
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", code=" + code + ", num=" + num + "]";
	}

}
