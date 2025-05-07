package com.springboot.crudh2db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudh2db.entity.Employee;
import com.springboot.crudh2db.request.EmployeeRequest;
import com.springboot.crudh2db.service.Crudh2dbService;

@RestController
@RequestMapping("/crudh2db")
public class Crudh2dbController {

	@Autowired
	Crudh2dbService service;

	// Create
	@PostMapping("/create")
	public boolean createEmployee(@RequestBody EmployeeRequest employee) {
		boolean status = service.createEmployee(employee);
		return status;

	}

	// Read
	@GetMapping("/read/{employeeID}")
	public Employee readEmployee(@PathVariable Long employeeID) {
		Employee employee = service.readEmployee(employeeID);
		return employee;

	}

	// Update
	@PutMapping("/udpate")
	public boolean updateEmployee(@RequestBody EmployeeRequest employee) {

		boolean status = service.updateEmployee(employee);
		return status;
	}

	// Delete
	@DeleteMapping("/delete")
	public boolean deleteEmployee(Long employeeID) {

		boolean status = service.deleteEmployee(employeeID);
		return status;
	}

	@GetMapping("/readAll")
	public List<Employee> getAllEmployees() {
		List<Employee> list=service.getAllEmployees();
		return list;
	}

}
