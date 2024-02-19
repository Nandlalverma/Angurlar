package com.employeeAngular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeAngular.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	public Employee findEmployeyById(Long empId);
	public void deleteEmployeeById(Long empid);
	
}
