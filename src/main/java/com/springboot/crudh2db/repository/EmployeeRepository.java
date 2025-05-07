package com.springboot.crudh2db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crudh2db.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>{

}
