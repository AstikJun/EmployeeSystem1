package com.example.employeesystem.service;

import com.example.employeesystem.entity.Employee;
import com.example.employeesystem.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements Employeeservice{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmpById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmp(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public void deleteEmpById(Long id) {
        employeeRepository.deleteById(id);
    }

}
