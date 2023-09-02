package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Employee;
import com.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeservice;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeservice.getAllEmployee());
		return "index";
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewWmployeeFrom(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeservice.saveEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{Id}")
	public String showFormForUpdate(@PathVariable(value = "Id") long Id, Model model) {
		Employee employee = employeeservice.getEmployeeById(Id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}

	@GetMapping("/deleteEmployee/{Id}")
	public String deleteEmployee(@PathVariable(value = "Id") int Id) {
		this.employeeservice.deleteEmployeeById(Id);
		return "redirect:/";
	}

}
