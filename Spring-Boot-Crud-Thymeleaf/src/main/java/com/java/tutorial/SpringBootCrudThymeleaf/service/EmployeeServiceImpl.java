package com.java.tutorial.SpringBootCrudThymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.tutorial.SpringBootCrudThymeleaf.model.Employee;
import com.java.tutorial.SpringBootCrudThymeleaf.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee e) {
		employeeRepository.save(e);
		
	}

	
	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> employee=employeeRepository.findById(id);
		System.out.println("In service:"+employee.toString());
		Employee e=null;
		if(employee.isPresent()) {
			e=employee.get();
		}
		else {
			throw new RuntimeException("Employee is not found for id:"+id);
		}
		return e;
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

}
