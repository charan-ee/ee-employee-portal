package com.everest.employeeportal.controllers;


import com.everest.employeeportal.entities.Employee;
import com.everest.employeeportal.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(value = "")
    public Collection<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(params = "sort")
    public Collection<Employee> getEmployeesSortedByName(@RequestParam(name = "sort") String paramName){
        return employeeService.getEmployeesBySort(paramName);
    }

    @GetMapping(value = "/{Id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "Id") Long Id){
        final Employee employee = employeeService.getEmployeeById(Id);
        if(employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/search")
    public Collection<Employee> searchEmployee(@RequestParam(name = "name") String name){
        return employeeService.getEmployeeByName(name);
    }

    @PostMapping(value = "")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        final Employee savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PutMapping(value = "/{Id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "Id") Long Id, @RequestBody Employee employee){
        employee.setId(Id);
        return ResponseEntity.status(HttpStatus.OK)
                            .body(employeeService.updateEmployee(employee));
    }

    @DeleteMapping(value = "/{Id}")
    public void deleteEmployee(@PathVariable(name = "Id") Long Id){
        employeeService.removeEmployee(Id);
    }
}
