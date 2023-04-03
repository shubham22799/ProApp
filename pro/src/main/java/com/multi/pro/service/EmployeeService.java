package com.multi.pro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.multi.pro.utilities.Employee;

@Component
public interface EmployeeService {

public List<Employee> getEmployeesList();
	
	public Optional<Employee> getEmployee(long empId);
	
	public String addEmployee(Employee emp);
	
	public String updateEmployee(long empId,Employee emp);

	public String deleteEmployee(long empId);

	public String deleteAllEmployee();
}
