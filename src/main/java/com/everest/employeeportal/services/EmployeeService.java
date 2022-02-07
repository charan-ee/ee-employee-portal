package com.everest.employeeportal.services;

import com.everest.employeeportal.entities.Employee;
import com.everest.employeeportal.exceptions.EmployeeNotFoundException;
import com.everest.employeeportal.repositories.EmployeeRepository;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Component
@Data
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Collection<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long Id){
        return employeeRepository.findById(Id)
                                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found"));
    }

    @Transactional
    public Employee addEmployee(Employee employee) throws EmployeeNotFoundException{
        return employeeRepository.save(employee);
    }
}
