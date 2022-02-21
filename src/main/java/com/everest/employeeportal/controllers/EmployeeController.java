package com.everest.employeeportal.controllers;


import com.everest.employeeportal.entities.Employee;
import com.everest.employeeportal.models.EmployeeResponse;
import com.everest.employeeportal.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(value = "")
    public EmployeeResponse getEmployees(@RequestParam(name = "sort", defaultValue = "Id", required = false) String sortParam,
                                         @RequestParam(defaultValue = "1") Integer page,
                                         @RequestParam(defaultValue = "2") Integer pageSize){
        return employeeService.getAllEmployees((page-1), pageSize, sortParam);
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
    public EmployeeResponse searchEmployee(@RequestParam String query, @RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "2") Integer pageSize){
        return employeeService.getEmployeeByName(query, page-1, pageSize);
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
