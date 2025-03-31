package com.example.hexagonal_kafka_demo.domain.exception;

public class ReservationException extends RuntimeException {

    public ReservationException(String message) {
        super(message);
    }

    public ReservationException(String message, Throwable cause) {
        super(message, cause);
    }

    public static ReservationException invalidReservationTime() {
        return new ReservationException("Reservation time must be in the future");
    }

    public static ReservationException tableNotAvailable() {
        return new ReservationException("Selected table is not available");
    }

    public static ReservationException customerBlocked(String email) {
        return new ReservationException("Customer " + email + " is blocked from making reservations");
    }
}