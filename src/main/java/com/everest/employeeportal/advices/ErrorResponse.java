package com.everest.employeeportal.advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String message;
    private LocalDateTime dateTime;

    public ErrorResponse(String message, LocalDateTime dateTime){
        this.setMessage(message);
        this.setDateTime(dateTime);
    }
}
