package com.crud.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.entity.Employee;
import com.crud.demo.repository.EmpRepo;
import com.crud.demo.service.EmployeeService;

@Service
public class EmpServiceImpl implements EmployeeService {
	@Autowired
	EmpRepo empRepo;

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		empRepo.save(employee);

	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		Optional<Employee> optional = empRepo.findById(empId);
		Employee employee = null;
			employee = optional.get();
		return employee;
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		this.empRepo.deleteById(id);
	}

}
