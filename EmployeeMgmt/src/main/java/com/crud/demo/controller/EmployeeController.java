package com.crud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.demo.entity.Employee;
import com.crud.demo.serviceimpl.EmpServiceImpl;

@Controller
public class EmployeeController {

	@Autowired
	EmpServiceImpl empServiceImpl;

	@GetMapping(value = "/")
	public String getAllEmployees(Model model) {
		model.addAttribute("listEmployees", empServiceImpl.getAllEmployee());
		return "index";
	}

	@GetMapping(value = "/showNewEmployeeForm")
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping(value = "/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		empServiceImpl.saveEmployee(employee);
		 return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{empId}")
	public String showFormForUpdate(@PathVariable ( value = "empId") Integer empId, Model model) {
	 
	 // get employee from the service
	 Employee employee = empServiceImpl.getEmployeeById(empId);
	 
	 // set employee as a model attribute to pre-populate the form
	 model.addAttribute("employee", employee);
	 return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable (value = "empId") Integer id) {
	 empServiceImpl.deleteEmployeeById(id);
	 return "redirect:/";
	}
}
