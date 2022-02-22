package com.everest.employeeportal.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstName")
    @NotBlank(message = "First Name can't be empty")
    private String firstName;

    @Column(name = "lastName")
    @NotBlank(message = "Last Name can't be empty")
    private String lastName;

    @Column(name = "password")
    @NotBlank
    @Size(min = 5)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])$")
    private String password;

    @Email
    @Column(name = "personalEmail")
    @NotBlank(message = "Personal Email can't be empty")
    private String personalEmailId;

    @Email
    @Column(name = "everestEmail")
    @NotBlank(message = "Enter Organisation email")
    private String everestEmailId;

    @Column(name = "DOB")
    @NotBlank
    private LocalDate dob;

    @Column(name = "DOJ")
    @NotBlank
    private LocalDate doj;

    @Column(name = "Designation")
    private String designation;

    @Column(name = "Experience")
    @Size(min = 0)
    private Integer experienceInYears;

    @Column(name = "Bio")
    private String bio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_address_id")
    private Address presentAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "permanent_address_id")
    private Address permanentAddress;


}
