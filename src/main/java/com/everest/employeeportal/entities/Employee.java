package com.everest.employeeportal.entities;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String password;
    private String personalEmail;
    private String everestEmail;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoining;
    private Integer yearsOfExperience;
    private String bio;
}
