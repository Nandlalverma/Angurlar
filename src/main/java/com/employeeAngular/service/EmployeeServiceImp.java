package com.employeeAngular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeAngular.entity.Employee;
import com.employeeAngular.exception.ResourceNotFoundException;
import com.employeeAngular.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository empreRepository;
	@Override
	public Employee saveEmployee(Employee employee) {
		return empreRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empreRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long empId) {
		Optional<Employee> byId = empreRepository.findById(empId);
		if(byId.isEmpty()) {
			System.out.println("exception not throw");
			throw new ResourceNotFoundException("Id does not exist"+empId);
		}
		System.out.println("exception throw out of exception");
		return empreRepository.findById(empId).get();
	}

	@Override
	public void deleteEmployeById(Long empId) {
	    Optional<Employee> byId = empreRepository.findById(empId);
	    if(byId.isEmpty()) {
	    	throw new ResourceNotFoundException("id does not exists");
	    }
	     empreRepository.deleteEmployeeById(empId);
		
	}

	@Override
	public Employee updateEmployee(Long empId, Employee updateEmployee) {
		
		Optional<Employee> byId = empreRepository.findById(empId);
		if(byId.isEmpty()) {
		  throw new ResourceNotFoundException("id does not exists");
		}
		   Employee employee = byId.get();
		   employee.setFirstName(updateEmployee.getFirstName());
		   employee.setLastName(updateEmployee.getLastName());
		   employee.setEmailId(updateEmployee.getEmailId());
		  return empreRepository.save(employee);
		   
		
	}

	
}
