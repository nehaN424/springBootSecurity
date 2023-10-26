package com.spring.boot.security.springBootSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/contacts")
    public String contacts(){
        return "contacts";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/balance")
    public String balance(){
        return "balance";
    }
}
