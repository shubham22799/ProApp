package com.multi.pro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multi.pro.service.EmployeeServiceImpl;
import com.multi.pro.utilities.Employee;


@RestController
public class MyController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping("/home")
	public String home() {
		return "This is Home Page.";
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		
		System.out.print("In getEmployees methord.");
		return this.employeeService.getEmployeesList();
	}
	
	@GetMapping("/employees/{empId}")
	public Optional<Employee> getEmployee(@PathVariable long empId) {
		return this.employeeService.getEmployee(empId);
	}
	
	@PostMapping("/employees")
	public String addEmployee(@RequestBody Employee emp) {
		return this.employeeService.addEmployee(emp);
	}
	
	@PutMapping("/employees")
	public String updateEmployee(@RequestBody Employee emp) {
		return this.employeeService.updateEmployee(emp);
	}
	
	@DeleteMapping("/employees/{empId}")
	public String deleteEmployee(@PathVariable long empId) {
		return this.employeeService.deleteEmployee(empId);
	}
	
//	@DeleteMapping("/employees/{empId}")
//	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int empId) {
//		try {
//			this.employeeService.deleteEmployee(empId);
//			return new ResponseEntity<>(HttpStatus.OK);
//		}catch(Exception e){
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	@DeleteMapping("/employees")
	public String deleteAllEmployee() {
		return this.employeeService.deleteAllEmployee();
	}
}
