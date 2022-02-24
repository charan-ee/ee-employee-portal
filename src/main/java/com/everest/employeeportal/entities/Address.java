package com.everest.employeeportal.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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
}
