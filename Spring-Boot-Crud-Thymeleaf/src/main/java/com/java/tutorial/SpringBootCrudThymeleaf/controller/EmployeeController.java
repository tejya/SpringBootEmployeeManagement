package com.java.tutorial.SpringBootCrudThymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.tutorial.SpringBootCrudThymeleaf.model.Employee;
import com.java.tutorial.SpringBootCrudThymeleaf.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(name = "/",method = RequestMethod.GET)
	public String viewHomePage(Model model) {
		model.addAttribute("listOfEmployee",employeeService.getAllEmployee());
		return "index";
	}
	
	@GetMapping("/newEmployeeForm")
	public String showEmployee(Model model) {
		model.addAttribute("employee",new Employee());
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return"redirect:/";
	}
	@GetMapping("/showEmployeeId/{id}")
	public String showFormForUpdate(@PathVariable(value="id")int id,Model model) {
		System.out.println("The employee id:"+id);
		Employee emp=employeeService.getEmployeeById(id);
		System.out.println("Employee is:"+emp.getFirstName());
		model.addAttribute("employee",emp);
		return "update_employee";
	}
	@GetMapping("/deleteEmployeeId/{id}")
	public String deleteEmployee(@PathVariable(value = "id")int id,Model model) {
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}
	
}
