package com.example.employeesystem.repository;

import com.example.employeesystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
