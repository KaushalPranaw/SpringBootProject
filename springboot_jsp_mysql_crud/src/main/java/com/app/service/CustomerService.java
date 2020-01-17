package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CustomerDao;
import com.app.pojos.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDao dao;
	
	public Customer login(String em,String pass)
	{
		Customer c=null;
		c=dao.findByEmailAndPassword(em,pass);
		return c;
	}
	
	public void register(Customer c)
	{
		dao.save(c);
	}
	
	public List<Customer> getAllCust()
	{
		return (List<Customer>)dao.findAll();
	}
	
	public void deleteCust(int id)
	{
		dao.delete(dao.findOne(id));
	}

	public Customer getCustDetail(int cid) {
		// TODO Auto-generated method stub
		//return (Customer)dao.findById(cid).orElse(null);
		return dao.findOne(cid);
	}

	public String updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		dao.save(c);
		return "updated";
	}
}
