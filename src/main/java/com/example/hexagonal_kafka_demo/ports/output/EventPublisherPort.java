package com.example.hexagonal_kafka_demo.ports.output;

import com.example.hexagonal_kafka_demo.domain.model.Reservation;

import java.util.UUID;

public interface EventPublisherPort {
    void publishReservationCreated(Reservation reservation);
    void publishReservationCancelled(UUID reservationId);
}
