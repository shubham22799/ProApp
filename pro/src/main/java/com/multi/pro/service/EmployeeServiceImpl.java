package com.multi.pro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.pro.dao.EmployeeDao;
import com.multi.pro.utilities.Employee;

import lombok.Data;

@Service
@Data
public class EmployeeServiceImpl {
@Autowired	
private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		super();
	
	}

	
	public List<Employee> getEmployeesList() {
		return employeeDao.findAll();
	}

	
	public Optional<Employee> getEmployee(long empId) {
	
		return employeeDao.findById(empId);
	}

	
	public String addEmployee(Employee emp) {
		
		return (employeeDao.save(emp)) == emp ? "Successfully added"  : "Failed to add";
	}

	
	public String updateEmployee(Employee emp) {
		
//		int a=0;
//		employeeDao.findAll().forEach(e -> {
//	        if(e.getId() == emp.getId()) {
//	          employeeDao.saveAndFlush(emp);
//	          a=1;
//	          
//	          return;
//	          
//	        }
//	    });
//		return (employeeDao.exists(emp));
		
		Employee employee = employeeDao.findAll().stream().filter(e -> e.getId() ==emp.getId())
	       .findFirst().orElse(null);
		if (employee != null) {
			employeeDao.saveAndFlush(emp);
			return "Successfully updated.";
		}else {
			return "Failed to update.";
		}
	}

	
	public String deleteEmployee(long empId) {
		Employee employee = employeeDao.findAll().stream().filter(e -> e.getId() == empId)
			       .findFirst().orElse(null);
				if (employee != null) {
					employeeDao.deleteById(empId);;
					return "Successfully updated.";
				}else {
					return "Failed to update.";
				}
	}

	
	public String deleteAllEmployee() {
		try {
		employeeDao.deleteAllInBatch();
		return "Successfully deleted all entries.";
		}catch(Exception e) {
			return e.getLocalizedMessage();
		}
	}

}
