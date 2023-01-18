package com.crud.demo.service;

import java.util.List;
import com.crud.demo.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(Integer id);
	 void deleteEmployeeById(Integer id);
}
