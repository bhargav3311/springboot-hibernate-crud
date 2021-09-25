package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.model.Employee;

//@Repository will make a spring component and will be scanned automatically during class path scanning
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
