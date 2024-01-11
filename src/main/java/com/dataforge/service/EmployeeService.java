package com.dataforge.service;

import java.util.List;

import com.dataforge.entity.Employee;

public interface EmployeeService {

	         public Employee saveEmployee(Employee employee);
	         
	         public List<Employee> listOfEmployees();
	         
	         public Employee getByEmployeeId(long id);
	         
	         public void deleteByEmployeeId(long id);
	         
}
