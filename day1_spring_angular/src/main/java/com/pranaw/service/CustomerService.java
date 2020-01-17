package com.pranaw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pranaw.dao.CustomerDao;
import com.pranaw.pojos.Customer;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerDao dao;

	public List<Customer> getCustomers()
	{
		return (List<Customer>) dao.findAll();
	}
	public String updateCustomer(Customer c)
	{
		dao.save(c);
		return "updated";
	}
	public String deleteCustomer(Customer c)
	{
		dao.delete(c);
		return "deleted";
	}
	public String saveCustomer(Customer c)
	{
		dao.save(c);
		return "saved";
	}
	public Customer getCustomerById(int id)
	{
		return dao.findById(id).orElse(null);
	}
	
}
