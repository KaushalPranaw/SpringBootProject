package com.pranaw.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pranaw.pojos.Customer;
import com.pranaw.service.CustomerService;

@RestController
//@EnableAutoConfiguration
//@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@RequestBody Customer customer)
	{
		return service.saveCustomer(customer);
	}
	
	@GetMapping("/allCustomer")
	public List<Customer> getCustomers()
	{
		return /*service.getCustomers();*/new ArrayList<Customer>(Arrays.asList(new Customer(1, "a", 100)));
	}
	
	@PutMapping("updateCustomer/{id}")
	public String updateCustomer(@RequestBody Customer c,@PathVariable("id") int id)
	{
		c.setId(id);
		return service.updateCustomer(c);
	}
	@DeleteMapping("deleteStudent/{id}")
	public String deleteCustomer(@PathVariable("id") int id,@RequestBody Customer c)
	{
		c.setId(id);
		return service.deleteCustomer(c);
	}
	@GetMapping("student/{id}")
	public Customer getCustomerById(@PathVariable("id") int id,@RequestBody Customer c)
	{
		//c.setId(id);
		return service.getCustomerById(id);
	}
}
