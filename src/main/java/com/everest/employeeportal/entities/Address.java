package com.everest.employeeportal.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private Long zipcode;
    private String country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", nullable = false)
    private Employee employee;
}
