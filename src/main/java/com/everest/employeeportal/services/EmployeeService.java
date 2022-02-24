package com.everest.employeeportal.services;

import com.everest.employeeportal.entities.Employee;
import com.everest.employeeportal.exceptions.EmployeeNotFoundException;
import com.everest.employeeportal.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.Collection;
import org.springframework.data.domain.Sort;

@Transactional
@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Collection<Employee> getAllEmployees(){
        Sort sort = Sort.by(Sort.Direction.ASC, "Id");
        return employeeRepository.findAll(sort);
    }

    public Collection<Employee> getEmployeesBySort(String param){
        if(param.equals("name"))
            return employeeRepository.findAll(Sort.by("firstName","lastName"));
        if(param.equalsIgnoreCase("doj"))
            return employeeRepository.findAll(Sort.by("dateOfJoining"));
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long Id){
        return employeeRepository.findById(Id)
                                .orElseThrow(()-> new EmployeeNotFoundException("Employee with id:" +Id+" not found"));
    }

    public Collection<Employee> getEmployeeByName(String name) throws EmployeeNotFoundException {
        return employeeRepository.findByFirstNameStartingWith(name);
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
