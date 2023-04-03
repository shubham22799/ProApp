package com.multi.pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multi.pro.utilities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long>{

}
