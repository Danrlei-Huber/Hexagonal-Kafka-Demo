package com.example.hexagonal_kafka_demo.application.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void sendConfirmation(String email, String message) {
        // Implementação real enviaria email
        System.out.println("Enviando email para " + email + ": " + message);
    }

}