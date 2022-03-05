package com.everest.employeeportal.services;

import com.everest.employeeportal.entities.Employee;
import com.everest.employeeportal.exceptions.EmployeeNotFoundException;
import com.everest.employeeportal.models.EmployeeResponse;
import com.everest.employeeportal.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;

@Transactional
@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeResponse getAllEmployees(Integer pageNo, Integer pageSize, String sortParam){
        Sort sort = Sort.by(Sort.Direction.ASC, sortParam);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return new EmployeeResponse(employeeRepository.findAll(pageable));
    }

    public Employee getEmployeeById(Long Id){
        return employeeRepository.findById(Id)
                                .orElseThrow(()-> new EmployeeNotFoundException("Employee with Id:" + Id + " not found"));
    }

    public EmployeeResponse getEmployeeByName(String name, Integer pageNo, Integer pageSize) throws EmployeeNotFoundException {
        Pageable employeePage = PageRequest.of(pageNo, pageSize);
        return new EmployeeResponse(employeeRepository.findByFirstNameStartingWith(name, employeePage));
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
