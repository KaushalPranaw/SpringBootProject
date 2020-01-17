package com.yash.secureapp.service;

import java.util.List;

import com.yash.secureapp.pojos.Employee;

public interface EmployeeService {

	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	void getEmployeeById(String empid);


}
