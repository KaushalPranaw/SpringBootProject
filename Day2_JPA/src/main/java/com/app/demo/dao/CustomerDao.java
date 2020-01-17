package com.app.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.demo.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, Integer>
{

}
