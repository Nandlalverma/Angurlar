package com.employeeAngular.service;

import java.util.List;
import java.util.Optional;

import com.employeeAngular.entity.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);
	public List<Employee> getAllEmployee();
    public Employee getEmployeeById(Long empId);
    public void deleteEmployeById(Long empId);
    public Employee updateEmployee(Long empId,Employee updateEmployee);
    
}
