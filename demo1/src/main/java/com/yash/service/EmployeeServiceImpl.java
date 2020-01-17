package com.yash.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
import com.yash.dao.CourseDao;*/
import com.yash.dao.EmployeeDao;
import com.yash.pojos.Contact;
import com.yash.pojos.Course;
import com.yash.pojos.Employee;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDao dao;
	
	/*@Autowired
	private CourseDao courseDao;*/

	public List<Employee> findAll() {
		List<Employee> empList=(List<Employee>) dao.findAll();
		System.out.println("=========================service findAll()===============================");
		System.out.println(empList);
		return empList;
	}

	public String addEmployee(Employee e) {

		e.addAddress(e.getAddress());

		List<Contact> contacts = new ArrayList<Contact>(e.getContacts());
		Iterator<Contact> i = contacts.iterator();
		while (i.hasNext()) {
			e.addContact(i.next());
		}

		Set<Course> courses = new HashSet<>(e.getCourses());
		Iterator<Course> itr = courses.iterator();
		while (itr.hasNext()) {
			e.addCourse(itr.next());
		}

		dao.save(e);
		return "Emp add with Name " + e.getName();
	}

	public String deleteEmp(int id) {
		Employee e = getById(id);
		/*e.deleteAddress(e.getAddress());
		
		List<Contact> contacts = new ArrayList<Contact>(e.getContacts());
		Iterator<Contact> i = contacts.iterator();
		while (i.hasNext()) {
			e.deleteContact(i.next());
		}

		Set<Course> courses = new HashSet<>(e.getCourses());
		Iterator<Course> itr = courses.iterator();
		while (itr.hasNext()) {
			e.deleteCourse(itr.next());
		}*/
		
		dao.delete(e);
		return "deleted with id " + id;
	}

	public Employee getById(int id) {
		return dao.findOne(id);
	}

	public String updateEmp(Employee e) {
		
		e.addAddress(e.getAddress());

		List<Contact> contacts = new ArrayList<Contact>(e.getContacts());
		Iterator<Contact> i = contacts.iterator();
		while (i.hasNext()) {
			e.addContact(i.next());
		}

		Set<Course> courses = new HashSet<>(e.getCourses());
		Iterator<Course> itr = courses.iterator();
		while (itr.hasNext()) {
			e.addCourse(itr.next());
		}
		
		
		dao.save(e);
		
		return "updated with id " + e.getId();
	}
	
	/*public String deleteCourse(int id)
	{
		courseDao.delete(courseDao.findOne(id));
		return "deleted course with id "+id;
	}*/

}
