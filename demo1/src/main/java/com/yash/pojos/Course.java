package com.yash.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Course {

	private int cid;
	private String cname;
	private Set<Employee> employees=new HashSet<>();
	
	
	public Course(int cid, String cname, Set<Employee> employees) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.employees = employees;
	}
	public Course() {
		System.out.println(" in const " + getClass().getName());
	}
	
	@Id
	@GeneratedValue
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="eid")
	@JsonBackReference
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + "]";
	}
	
	
}
