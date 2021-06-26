package com.java.tutorial.SpringBootCrudThymeleaf.service;

import java.util.List;

import com.java.tutorial.SpringBootCrudThymeleaf.model.Employee;

public interface EmployeeService {
public List<Employee> getAllEmployee();
public void saveEmployee(Employee e);
public Employee getEmployeeById(int id);
public void deleteEmployee(int id);
}
