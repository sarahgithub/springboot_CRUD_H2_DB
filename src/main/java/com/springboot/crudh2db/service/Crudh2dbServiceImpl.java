package com.springboot.crudh2db.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crudh2db.entity.Employee;
import com.springboot.crudh2db.repository.EmployeeRepository;
import com.springboot.crudh2db.request.EmployeeRequest;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Crudh2dbServiceImpl implements Crudh2dbService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public boolean createEmployee(EmployeeRequest request) {
		System.out.println("request : "+ request.toString());

		Employee emp = new Employee();
		emp.setEmployeeId(request.getEmployeeId());
		emp.setFirstName(request.getFirstName());
		emp.setLastName(request.getLastName());
		try {
			emp=repository.save(emp);
			System.out.println(emp.toString());
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
		}
		return true;
	}

	@Override
	public Employee readEmployee(Long employeeID) {
		System.out.println("empID : "+ employeeID);
		Optional<Employee> emp = repository.findById(employeeID);
		if (!emp.isPresent()) {

		}
		System.out.println("response : "+ emp.get().getFirstName());

		return emp.get();

	}

	@Override
	public boolean updateEmployee(EmployeeRequest request) {

		Optional<Employee> emp = repository.findById(request.getEmployeeId());
		if (emp.isPresent()) {
			emp.get().setEmployeeId(request.getEmployeeId());
			emp.get().setFirstName(request.getFirstName());
			emp.get().setLastName(request.getLastName());
			try {
				repository.save(emp.get());
			} catch (IllegalArgumentException e) {

			} catch (Exception e) {
			}
		} else {

		}
		return false;
	}

	@Override
	public boolean deleteEmployee(Long employeeID) {
		Optional<Employee> emp = repository.findById(employeeID);
		repository.deleteById(employeeID);
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = (List<Employee>) repository.findAll();
		return empList;
	}

}
