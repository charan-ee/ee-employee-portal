package com.everest.employeeportal.repositories;

import com.everest.employeeportal.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findByFirstNameStartingWith(String name, Pageable pageable);

    Employee findByEverestEmailId(String everestEmailId);
}
