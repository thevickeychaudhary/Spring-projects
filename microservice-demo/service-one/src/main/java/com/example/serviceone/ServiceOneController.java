package com.example.serviceone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceOneController {
    @GetMapping("/")
    public String home() 
    {
        return "Hello from service-one!";
    }
}