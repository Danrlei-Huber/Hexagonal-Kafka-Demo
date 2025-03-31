package com.example.hexagonal_kafka_demo.application.dto;

import com.example.hexagonal_kafka_demo.domain.model.Reservation;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReservationResponse(
        UUID reservationId,
        String customerName,
        String customerEmail,
        LocalDateTime reservationTime,
        int tableNumber,
        String status
) {
    // Método factory para conversão do domínio para DTO
    public static ReservationResponse fromDomain(Reservation reservation) {
        return new ReservationResponse(
                reservation.getId(),
                reservation.getCustomerName(),
                reservation.getCustomerEmail(),
                reservation.getReservationTime(),
                reservation.getTable().getNumber(),
                "CONFIRMED" // Status poderia vir do domínio
        );
    }

    // Método para respostas simplificadas
    public static ReservationResponse withMessage(UUID id, String message) {
        return new ReservationResponse(
                id,
                null,
                null,
                null,
                0,
                message
        );
    }
}