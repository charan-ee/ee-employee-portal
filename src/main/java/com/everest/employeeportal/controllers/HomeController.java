package com.everest.employeeportal.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
public class HomeController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
