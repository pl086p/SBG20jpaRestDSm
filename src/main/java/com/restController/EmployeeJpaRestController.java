package com.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.Employee;
import com.jpa.repository.EmployeeRepository;

@RestController
public class EmployeeJpaRestController {
	
	@Autowired 
	private EmployeeRepository employeeRepository;

	@RequestMapping("/jpa/employees")
	public @ResponseBody Iterable<Employee> getAllEmployees() {
		// This returns a JSON or XML with the users
		return employeeRepository.findAll();
	}

}

