package com.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.pojos.Customer;

public interface CustomerDao extends CrudRepository<Customer, Integer> 
{
	//Customer findByEmailAndPassword(String email,String pass);
	//List<Customer> findAllCustomer();
	
	Customer findByNameAndPassword(String name,String pass);
}
