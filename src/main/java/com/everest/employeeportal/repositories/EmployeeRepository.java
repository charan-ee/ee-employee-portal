package com.everest.employeeportal.repositories;

import com.everest.employeeportal.entities.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EmployeeRepository {
    private AtomicLong NEXT_ID = new AtomicLong(1);
    private Map<Long, Employee> EMPLOYEES = new HashMap<>();

    public List<Employee> getEmployees(){
        return new ArrayList<>(EMPLOYEES.values());
    }

    public Employee getEmployeeById(Long Id){
        return EMPLOYEES.get(Id);
    }

    public Employee createEmployee(Employee employee){
        employee.setEmployeeId(NEXT_ID.getAndIncrement());
        EMPLOYEES.put(employee.getEmployeeId(),employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee){
        return null;
    }

    public void deleteEmployee(Long Id){

    }

}
