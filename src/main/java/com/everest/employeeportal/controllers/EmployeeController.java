package com.everest.employeeportal.controllers;


import com.everest.employeeportal.entities.Employee;
import com.everest.employeeportal.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @GetMapping(value = "")
    public List<Employee> getEmployees(){
        return employeeRepository.getEmployees();
    }

    @GetMapping(value = "/{Id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "Id") Long Id){
        final Employee employee = employeeRepository.getEmployeeById(Id);
        if(employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        final Employee savedEmployee = employeeRepository.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PutMapping(value = "/{Id}")
    public Employee updateEmployee(@PathVariable(name = "id") Long id, @RequestBody Employee employee){
        return null;
    }

    public void deleteEmployee(Long Id){

    }
}
