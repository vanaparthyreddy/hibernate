package com.example.demo;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {
	@Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper mapper;

    public EmployeeResponse getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
        return employeeResponse;
    }
    
  //  public Employee getEmployeeById1(int id) {

		//return employeeRepo.getEmployeeById(id);
    
    
    
 // saving a specific record by using the method save() of CrudRepository
 	public void saveOrUpdate(Employee employee) {
 		employeeRepo.save(employee);
 	}

 	// deleting a specific record by using the method deleteById() of CrudRepository
 	public void delete(int id) {
 		employeeRepo.deleteById(id);
 	}

 	// updating a record
 	public void update(Employee employee, int Employeeid) {
 		employeeRepo.save(employee);
 	}


}
