package com.everest.employeeportal.repositories;

import com.everest.employeeportal.entities.Employee;
import com.everest.employeeportal.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EmployeeRepositoryInMemory {
    private AtomicLong NEXT_ID = new AtomicLong(1);
    private Map<Long, Employee> EMPLOYEES = new HashMap<>();

    public List<Employee> getEmployees() {
        return new ArrayList<>(EMPLOYEES.values());
    }

    public Employee getEmployeeById(Long Id) {
        return EMPLOYEES.get(Id);
    }

    public Employee createEmployee(Employee employee) {
        employee.setEmployeeId(NEXT_ID.getAndIncrement());
        EMPLOYEES.put(employee.getEmployeeId(), employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        if (!EMPLOYEES.containsKey(employee.getEmployeeId())) {
            throw new EmployeeNotFoundException("Id doesn't exist");
        }
        EMPLOYEES.put(employee.getEmployeeId(), employee);
        return employee;
    }

    public void deleteEmployee(Long Id) {
        if (!EMPLOYEES.containsKey(Id)) {
            throw new EmployeeNotFoundException("Id doesn't exist");
        }
        EMPLOYEES.remove(Id);
    }

}
