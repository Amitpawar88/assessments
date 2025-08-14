package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.Employee;
import com.hcl.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping()
	public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
