package com.pranaw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pranaw.pojos.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {

	/*List<Customer> getCustomers();
	String updateCustomer(Customer c);
	String deleteCustomer(Customer c);
	String saveCustomer(Customer c);
	Customer getCustomerById(int id);*/
	
}
