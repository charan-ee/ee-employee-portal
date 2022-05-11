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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    @NotBlank(message = "First Name can't be empty")
    private String firstName;

    @Column(name = "lastName")
//    @NotBlank(message = "Last Name can't be empty")
    private String lastName;

    @Column(name = "password")
//    @NotBlank
    @Size(min = 5)
    private String password;

    @Email
    @Column(name = "personalEmail")
//    @NotBlank(message = "Personal Email can't be empty")
    private String personalEmailId;

    @Column(name = "everestEmail")
    @NotBlank(message = "Enter Organisation email")
    private String everestEmailId;

    @Column(name = "DOB")
    private LocalDate dob;

    @Column(name = "DOJ")
    private LocalDate doj;

    @Column(name = "Designation")
    private String designation;

    @Column(name = "Experience")
    @Min(value = 0)
    private Integer experienceInYears;

    @Column(name = "Bio")
    private String bio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currentAddress")
    private Address presentAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "permanentAddress")
    private Address permanentAddress;


}
