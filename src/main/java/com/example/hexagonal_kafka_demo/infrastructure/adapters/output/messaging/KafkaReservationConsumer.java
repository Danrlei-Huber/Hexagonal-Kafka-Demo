package com.example.hexagonal_kafka_demo.infrastructure.adapters.output.messaging;

import com.example.hexagonal_kafka_demo.application.service.EmailService;
import com.example.hexagonal_kafka_demo.infrastructure.adapters.output.messaging.event.ReservationEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaReservationConsumer {
    private final EmailService emailService;

    public KafkaReservationConsumer(EmailService emailService) {
        this.emailService = emailService;
    }
/*
    @KafkaListener(topics = "reservation-events")
    public void consume(ReservationEvent event) {
        if (event.status().equals("CREATED")) {
            emailService.sendConfirmation(
                    event.customerEmail(),
                    "Reserva confirmada para " + event.reservationTime()
            );
        }
    }
    */

}

