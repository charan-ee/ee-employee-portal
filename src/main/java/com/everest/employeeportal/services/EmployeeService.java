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
        return employeeRepository.findByOrderByIdAsc();
    }

    public Collection<Employee> getEmployeesBySort(String param){
        if(param.equals("name"))
            return employeeRepository.findByOrderByFirstNameAsc();
        if(param.toLowerCase().equals("doj"))
            return employeeRepository.findByOrderByDateOfJoiningAsc();
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

    @Transactional
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
