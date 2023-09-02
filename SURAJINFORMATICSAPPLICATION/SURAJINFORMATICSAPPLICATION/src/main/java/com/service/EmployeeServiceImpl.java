package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeRepository;
import com.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeerepository;

	@Override
	public List<Employee> getAllEmployee() {
		return employeerepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeerepository.save(employee);

	}

	@Override
	public Employee getEmployeeById(long Id) {
		Optional<Employee> optional = employeerepository.findById(Id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("Employee not found for Id :: " + Id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long Id) {
		this.employeerepository.deleteById(Id);

	}

}
