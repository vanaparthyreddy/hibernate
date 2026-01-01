package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;

@RestController
public class EmployeeController {
	@Autowired
    private EmployeeService employeeService;
	private Object employee;

    @GetMapping("/employees/{id}")
    private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) {
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
        
    }
    
    
    @GetMapping("/getAllEmployee") //  API 
	//private List<Employee> getAllBooks() {
		//return employeeService.getAllEmployee();
    
 // creating a delete mapping that deletes a specified book
    

    @ResponseBody
 	@DeleteMapping("/employees/{employeesid}")
 	private void deleteEmployee(@PathVariable("employeesid") int employeesid) {
 		employeeService.delete(employeesid);
 	}

 	// creating post mapping that post the book detail in the database
 	@PostMapping("/employees")
 	private int saveEmployee(@RequestBody Employee employee) {
 		employeeService.saveOrUpdate(employee);
 	//	return  employee.getEmployeeId()
		return 0;
 	}

 	// creating put mapping that updates the book detail
 	@PutMapping("/employees")
 	private Employee update(@RequestBody Employee employees) {
 		employeeService.saveOrUpdate(employees);
 		return employees;
 	}

 	
 	
    


}
