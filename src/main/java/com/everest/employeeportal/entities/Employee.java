package com.everest.employeeportal.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
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
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "personalEmail")
    private String personalEmailId;

    @Column(name = "everestEmail")
    private String everestEmailId;

    @Column(name = "DOB")
    private LocalDate dob;

    @Column(name = "DOJ")
    private LocalDate doj;

    @Column(name = "Designation")
    private String designation;

    @Column(name = "Experience")
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
