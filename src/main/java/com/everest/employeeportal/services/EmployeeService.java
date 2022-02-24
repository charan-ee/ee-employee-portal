package com.everest.employeeportal.services;

import com.everest.employeeportal.entities.Employee;
import com.everest.employeeportal.exceptions.EmployeeNotFoundException;
import com.everest.employeeportal.repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Collection<Employee> getAllEmployees(){
        return employeeRepository.findByOrderByIdAsc();
    }

    public Employee getEmployeeById(Long Id){
        return employeeRepository.findById(Id)
                                .orElseThrow(()-> new EmployeeNotFoundException("Employee with id:" +Id+" not found"));
    }

    public Employee addEmployee(Employee employee) throws EmployeeNotFoundException{
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void removeEmployee(Long Id){
        if(employeeRepository.existsById(Id)){
            employeeRepository.deleteById(Id);
        }else{
            throw new EmployeeNotFoundException("Employee not found");
        }
    }
}
