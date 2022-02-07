package com.everest.employeeportal.entities;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
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
    private String personalEmail;

    @Column(name = "everestEmail")
    private String everestEmail;

    @Column(name = "DOB")
    private LocalDate dateOfBirth;

    @Column(name = "DOJ")
    private LocalDate dateOfJoining;

    @Column(name = "Experience")
    private Integer yearsOfExperience;

    @Column(name = "Bio")
    private String bio;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Address> currentAddress;

}
