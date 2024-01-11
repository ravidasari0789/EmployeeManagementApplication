package com.dataforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataforge.entity.Employee;
import com.dataforge.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	   @Autowired
	   private EmployeeRepo employerepo;
	@Override
	public Employee saveEmployee(Employee employee) {
		
	   Employee str=	 employerepo.save(employee);
		return str;
	}

	@Override
	public List<Employee> listOfEmployees() {
		// TODO Auto-generated method stub
		
		List<Employee> emp=employerepo.findAll();
		return emp;
	}

	@Override
	public Employee getByEmployeeId(long id) {
	Employee emp=	employerepo.findById(id).get();
		return emp;
	}

	
	  @Override 
	  public void deleteByEmployeeId(long id) {
	  employerepo.deleteById(id);
	  
	  }
	 

}
