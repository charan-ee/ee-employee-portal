package com.everest.employeeportal.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Address can't be empty")
    private String addressLine1;

    private String addressLine2;

    @NotBlank(message = "Enter you city")
    private String city;

    private String state;

    private String country;

    private Long zipcode;
}
