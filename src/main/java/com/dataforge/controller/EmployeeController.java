package com.dataforge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dataforge.entity.Employee;
import com.dataforge.service.EmployeeService;

@Controller
public class EmployeeController {

	            @Autowired
	            private EmployeeService employeeservice;
	               
	           @GetMapping("/")
	           public String homePage(Model model) {
	        	   
	        	   model.addAttribute("employee", new Employee());
	        	   return "home";
	           }
	           
	           @GetMapping("/aboutpage")
	           public String aboutPage(Model model) {
	        	   
	        	   model.addAttribute("about", new Employee());
	        	   return "about";
	           }
	           @GetMapping("/addemployeedata")
	           public String loadaddPage(Model model) {
	        	   
	        	   model.addAttribute("added", new Employee());
	        	   return "addemployee";
	           }
	           @GetMapping("/viewpage")
	           public String loadViewPage(Model model) {
	        	   
	        	   model.addAttribute("view", new Employee());
	        	   return "viewemployee";
	           }
	           
	           @PostMapping("/saveemployee")
	           public String saveEmployee(Employee employee,Model model) {   
	        	   employeeservice.saveEmployee(employee);
	        	   model.addAttribute("save", "sucessfully saved data in db");
	        	   return "redirect:/getemployee";
	           }
	           @GetMapping("/getemployee")
	           public String loadEmployeelist(Model model) {
	        	 List<Employee> list=  employeeservice.listOfEmployees();
	        	   model.addAttribute("employeeobject",list);
	        	   return "viewemployee";
	           }
	           @RequestMapping(value="/deleteemployee/{id}")
	          public String deleteById(@PathVariable("id") int id,Model model) {
	        	    employeeservice.deleteByEmployeeId(id);
	        	   
	        	   model.addAttribute("delete", "sucess");
	        	     return "redirect:/getemployee";
	          }
	           @RequestMapping(value="/updateemployee/{id}")
		          public String updateById(@PathVariable("id") int id,Model model) {
		        	   Employee emp= employeeservice.getByEmployeeId(id);
		        	   
		        	   model.addAttribute("update", emp);
		        	     return "update";
		          }
}
