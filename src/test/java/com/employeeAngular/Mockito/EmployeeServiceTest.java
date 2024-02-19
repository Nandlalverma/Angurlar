package com.employeeAngular.Mockito;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employeeAngular.entity.Employee;
import com.employeeAngular.repository.EmployeeRepository;
import com.employeeAngular.service.EmployeeService;
import com.employeeAngular.service.EmployeeServiceImp;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	
	@Mock
   private EmployeeRepository employeeRepository;
   @InjectMocks
   private EmployeeServiceImp employeeServiceImp;
   private Employee employee;
   @BeforeEach
   public void setup() {
	   MockitoAnnotations.openMocks(this);
	   employee=new Employee(1L,"peter","carry","peter@gmail.com");
   }
   
   
   @Test
   @DisplayName("test case of create employee")
   public void testCreateEmployee() {
	    when(employeeRepository.save(any())).thenReturn(employee);
	    assertThat(employeeServiceImp.saveEmployee(employee)).isNotNull();
   }
   
   @Test
   @DisplayName("Test case of get All Employee")
   public void testGetAllEmployee() {
	   when(employeeRepository.findAll())
	   .thenReturn(new ArrayList<Employee>(Collections.singleton(employee)));
	   assertThat(employeeServiceImp.getAllEmployee()).asList();
	   
	   assertThat(employeeServiceImp.getAllEmployee().get(0).getFirstName())
	   .isEqualTo(employee.getFirstName());
	   
	   assertThat(employeeServiceImp.getAllEmployee().size()).isEqualTo(1);
	   
   }
   
   public void testGetEmployeeById() {
	   when(employeeRepository.findEmployeyById(1L))
	   .thenReturn(employee);
   }
   
   
   
   @AfterEach
   public void tesrDown() {
	   
   }
}
