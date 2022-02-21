package com.everest.employeeportal.models;

import com.everest.employeeportal.entities.Employee;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeResponse {
    private List<Employee> data = new ArrayList<>();
    private long totalElements;
    private long totalPages;
    private long pageSize;
    private long currentPage;
    private boolean hasNext;
    private boolean hasPrevious;

    public EmployeeResponse(Page<Employee> employeePage){
        this.setData(employeePage.getContent());
        this.setTotalElements(employeePage.getTotalElements());
        this.setTotalPages(employeePage.getTotalPages());
        this.setPageSize(employeePage.getSize());
        this.setCurrentPage(employeePage.getNumber());
        this.setHasNext(employeePage.hasNext());
        this.setHasPrevious(employeePage.hasPrevious());
    }
}
