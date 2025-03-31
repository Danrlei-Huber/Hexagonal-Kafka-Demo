package com.example.hexagonal_kafka_demo.infrastructure.adapters.output.messaging.event;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReservationEvent(
        UUID eventId,               // Identificador único do evento
        UUID reservationId,         // ID da reserva relacionada
        String eventType,           // "RESERVATION_CREATED", "RESERVATION_UPDATED", etc.
        String customerEmail,
        LocalDateTime reservationTime,
        int tableNumber,
        LocalDateTime eventTimestamp // Quando o evento foi gerado
) {

    // Factory method para evento de criação
    public static ReservationEvent createReservationCreatedEvent(
            UUID reservationId,
            String customerEmail,
            LocalDateTime reservationTime,
            int tableNumber
    ) {
        return new ReservationEvent(
                UUID.randomUUID(),
                reservationId,
                "RESERVATION_CREATED",
                customerEmail,
                reservationTime,
                tableNumber,
                LocalDateTime.now()
        );
    }

    // Factory method para evento de cancelamento
    public static ReservationEvent createReservationCancelledEvent(
            UUID reservationId,
            String customerEmail
    ) {
        return new ReservationEvent(
                UUID.randomUUID(),
                reservationId,
                "RESERVATION_CANCELLED",
                customerEmail,
                null,
                0,
                LocalDateTime.now()
        );
    }

    public String status() {
        return eventType;
    }
}
