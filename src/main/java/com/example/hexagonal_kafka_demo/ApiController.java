package com.example.hexagonal_kafka_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ApiController {

    @GetMapping
    public String sayHello() {
        return "API on";
    }

}
