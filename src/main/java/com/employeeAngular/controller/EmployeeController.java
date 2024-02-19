package com.employeeAngular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeAngular.entity.Employee;
import com.employeeAngular.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		Employee saveEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(saveEmployee,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> empList = employeeService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empId){
		Employee employeeById = employeeService.getEmployeeById(empId);
		return new ResponseEntity<Employee>(employeeById,HttpStatus.OK);
	}
	
	@PutMapping("/{empId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Long empId,@RequestBody Employee employee){
		Employee updateEmployee = employeeService.updateEmployee(empId, employee);
		return new ResponseEntity<String>("Success fully updated !",HttpStatus.OK);
	}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<String> deletedByEmployeeId(@PathVariable Long empId){
		employeeService.deleteEmployeById(empId);
		return new ResponseEntity<String>("successfully deleted",HttpStatus.OK);
	}
	
	
}
