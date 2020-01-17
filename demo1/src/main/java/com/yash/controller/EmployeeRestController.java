package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.pojos.Employee;
import com.yash.service.EmployeeServiceImpl;

@RestController
@CrossOrigin("http://localhost:4200")
public class EmployeeRestController {

	@Autowired
	private EmployeeServiceImpl service;

	@GetMapping("/list")
	public List<Employee> getAll() {
		System.out.println("-------------list() called------------------");
		return service.findAll();
	}

	@PostMapping("/add")
	public void processEmployee(@RequestBody Employee e) {
		System.out.println("-------------add() called------------------");
		System.out.println(e);
		
		service.addEmployee(e);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmp(@PathVariable("id") int id) {
		//int id1=Integer.parseInt(id);
		System.out.println("-------------delete() called------------------");
		service.deleteEmp(id);
	}

	@PutMapping("/update")
	public void processEmployeeUPdate(@RequestBody Employee e) {
		System.out.println("---------------------update() called------------------------");
		System.out.println(e);
		service.updateEmp(e);
	}
	
	/*@DeleteMapping("/deleteByCourse/{id}")
	public void deleteCourse(@PathVariable("id") int id) {
		service.deleteCourse(id);
	}*/
}
