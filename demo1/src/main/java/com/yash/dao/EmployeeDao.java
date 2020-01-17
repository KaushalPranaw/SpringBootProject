package com.yash.dao;

import org.springframework.data.repository.CrudRepository;

import com.yash.pojos.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
	
}
