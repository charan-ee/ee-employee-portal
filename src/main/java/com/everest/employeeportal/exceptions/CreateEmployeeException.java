package com.everest.employeeportal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CreateEmployeeException extends RuntimeException{
    public CreateEmployeeException(String message){
        super(message);
    }

}
