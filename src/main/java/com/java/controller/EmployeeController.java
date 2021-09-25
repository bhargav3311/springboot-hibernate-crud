package com.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.exception.ResourceNotFoundException;
import com.java.model.Employee;
import com.java.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	// get employee
	@GetMapping("employees")
	public List<Employee> getAllEmployee() {

		return this.employeeRepository.findAll();
	}

	// get employee By ID
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {

		//fetch emp details from DB
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this ID>> " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	// save employee
	@PostMapping("employees")
	public Employee createEmployee(@RequestBody Employee employee) {

		return this.employeeRepository.save(employee);

	}

	// update Employee
	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@Valid @PathVariable(value = "id") Long employeeId,
			@RequestBody Employee employeeDetails) throws ResourceNotFoundException {

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found for this ID>>" + employeeId));

		employee.setEmail(employeeDetails.getEmail());
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());

		return ResponseEntity.ok(this.employeeRepository.save(employee));

	}
	
	
	
	//delete Employee
	@DeleteMapping("employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable (value = "id") Long employeeId) throws ResourceNotFoundException{
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found for this ID>>" + employeeId));
		
		this.employeeRepository.delete(employee);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);  //employee deleted
		
		return response;
	}
		
}
 