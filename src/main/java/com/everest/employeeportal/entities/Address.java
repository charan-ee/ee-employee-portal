package com.everest.employeeportal.entities;

import lombok.Data;

@Data
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private Long zipcode;
    private String country;
}
