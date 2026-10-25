
package com.example.employeemanager.controller;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Display all employees
    @GetMapping("/")
    public String viewEmployees(Model model) {
        model.addAttribute("employees",
                employeeService.getAllEmployees());
        model.addAttribute("employee", new Employee());
        return "employees";
    }

    // Save a new employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    // Display the edit page
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Invalid employee ID: " + id));

        model.addAttribute("employee", employee);
        return "edit-employee";
    }

    // Update an employee
    @PostMapping("/update/{id}")
    public String updateEmployee(
            @PathVariable Long id,
            @ModelAttribute Employee employee) {

        employee.setId(id);
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    // Delete an employee
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
