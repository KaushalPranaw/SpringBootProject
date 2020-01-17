package com.yash.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.EmployeeDao;
import com.yash.pojo.Employee;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	EmployeeDao dao;

	public void insertEmployee(Employee emp) {
		dao.save(emp);
		
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	
}
