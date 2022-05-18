package com.example.employeesystem.service;

import com.example.employeesystem.entity.Employee;

import java.util.List;

public interface Employeeservice {
    List<Employee> getAllEmp();

    Employee saveEmp(Employee employee);

    Employee getEmpById(Long id);

    Employee updateEmp(Employee employee);

    void deleteEmpById(Long id);
}
