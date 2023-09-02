package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Employee;

@Service
public interface EmployeeService {
	List<Employee> getAllEmployee();

	void saveEmployee(Employee employee);

	Employee getEmployeeById(long Id);

	void deleteEmployeeById(long Id);

}
