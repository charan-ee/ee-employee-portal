package com.everest.employeeportal.repositories;

import com.everest.employeeportal.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Collection<Employee> findByOrderByIdAsc();

    Collection<Employee> findByOrderByFirstNameAsc();

    Collection<Employee> findByOrderByDateOfJoiningAsc();

    Collection<Employee> findByFirstNameStartingWith(String name);

}
