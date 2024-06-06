package com.example.restapi.controller;

import com.example.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.example.restapi.model.Employee;

import java.util.List;

@RestController
public class Employeecontroller {
	//localhost:8080/api/vi/employees
	@Autowired
	private EmployeeService eService;
	//dan ham get
	@GetMapping ("/employees")
	public List<Employee> getEmployees () {
		return eService.getEmployees();
	}
	//localhost:8080/employees/id(123, 1, ...)
	//select theo id
	@GetMapping("/employees/{id}")
	public Employee getEmployee (@PathVariable("id") Long id) {
		return eService.getSingleEmployee(id);
	}
	//create employee
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return eService.saveEmployee(employee);
	}

	//update employee
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return eService.updateEmployee(employee);
	}
	//localhost:8080/employess?id=34
	//Xoa du lieu employee mysql
	@DeleteMapping("/employees")
	public void deleteEmployee(@RequestParam Long id) {
		eService.deleteEmployee(id);
	}
	
}
