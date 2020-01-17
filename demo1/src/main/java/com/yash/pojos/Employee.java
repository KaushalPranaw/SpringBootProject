package com.yash.pojos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee {

	private int id;
	private String name;
	private double salary;

//	private byte[] image;

	private Address address;

	private List<Contact> contacts = new ArrayList<Contact>();

	private Set<Course> courses = new HashSet<>();

	public Employee() {
		System.out.println(" in const " + getClass().getName());
	}

	public Employee(int id, String name, double salary/*, byte[] image*/, Address address, List<Contact> contacts,
			Set<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		//this.image = image;
		this.address = address;
		this.contacts = contacts;
		this.courses = courses;
	}

	@Id
	@GeneratedValue
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

//	@Lob
//	public byte[] getImage() {
//		return image;
//	}

	/*public void setImage(byte[] image) {
		this.image = image;
	}*/

	// --------------------------------

	@JsonManagedReference
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@ManyToMany(mappedBy = "employees", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	// convient methods

	public void addAddress(Address address) {
		this.setAddress(address);
		address.setEmployee(this);
	}

	public void deleteAddress(Address address) {
		address.setEmployee(null);
		this.setAddress(null);
	}

	public void addContact(Contact contact) {
		this.contacts.add(contact);
		contact.setEmployee(this);
	}

	public void deleteContact(Contact contact) {
		this.contacts.remove(contact);
		contact.setEmployee(null);

	}

	public void addCourse(Course course) {
		this.courses.add(course);
		course.getEmployees().add(this);
	}

	public void deleteCourse(Course course) {
		this.getCourses().remove(course);
		course.getEmployees().remove(this);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", image=" 
				+ ", address=" + address + ", contacts=" + contacts + ", courses=" + courses + "]";
	}

	

}
