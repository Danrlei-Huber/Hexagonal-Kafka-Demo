package com.example.hexagonal_kafka_demo.application.dto;

import com.example.hexagonal_kafka_demo.domain.model.Reservation;
import com.example.hexagonal_kafka_demo.domain.model.Table;

import java.time.LocalDateTime;

public record ReservationRequest(
        String customerName,
        String customerEmail,
        LocalDateTime reservationTime,
        int tableNumber
) {
    public Reservation toDomain() {
        return Reservation.create(
                customerName, customerEmail, reservationTime, new Table(tableNumber, 4));

    }
}