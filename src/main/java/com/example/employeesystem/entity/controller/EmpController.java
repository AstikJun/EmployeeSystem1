package com.example.employeesystem.entity.controller;

import com.example.employeesystem.entity.Employee;
import com.example.employeesystem.service.Employeeservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmpController {
    private Employeeservice employeeservice;
    public EmpController(Employeeservice employeeservice) {
        super();
        this.employeeservice = employeeservice;
    }
    @GetMapping("/employees")
    public String listEmp(Model model) {
        model.addAttribute("employees", employeeservice.getAllEmp());
        return "employees";
    }
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return String.format("Hello %s!",name);
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/employees/new")
    public String createEmpFor(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_emp";

    }

    @PostMapping("/employees")
    public String saveEmp(@ModelAttribute("employee") Employee employee) {
        employeeservice.saveEmp(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmpForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeservice.getEmpById(id));
        return "edit_emp";
    }

    @PostMapping("/employees/{id}")
    public String updateEmp(@PathVariable Long id,
                                @ModelAttribute("employee") Employee employee,
                                Model model) {

        Employee existingEmp = employeeservice.getEmpById(id);
        existingEmp.setId(id);
        existingEmp.setFirstName(employee.getFirstName());
        existingEmp.setLastName(employee.getLastName());
        existingEmp.setEmail(employee.getEmail());

        employeeservice.updateEmp(employee);
        return "redirect:/employees";
    }


    @GetMapping("/employees/{id}")
    public String deleteEmp(@PathVariable Long id) {
        employeeservice.deleteEmpById(id);
        return "redirect:/employees";
    }
}
