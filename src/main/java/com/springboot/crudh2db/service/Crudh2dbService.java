package com.springboot.crudh2db.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.crudh2db.entity.Employee;
import com.springboot.crudh2db.request.EmployeeRequest;


public interface Crudh2dbService {
	
	
	public boolean createEmployee(EmployeeRequest request);
	public Employee readEmployee(Long employeeID);
	public boolean updateEmployee(EmployeeRequest request);
	public boolean deleteEmployee(Long employeeID);
	public List<Employee> getAllEmployees();

}
