package com.example.hexagonal_kafka_demo.domain.model;

import com.example.hexagonal_kafka_demo.domain.exception.ReservationException;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public final class Reservation {
    private final UUID id;
    private final String customerName;
    private final String customerEmail;
    private final LocalDateTime reservationTime;
    private final Table table;

    private Reservation(UUID id, String customerName, String customerEmail,
                        LocalDateTime reservationTime, Table table) {
        this.id = id;
        this.customerName = validateName(customerName);
        this.customerEmail = validateEmail(customerEmail);
        this.reservationTime = validateTime(reservationTime);
        this.table = table;
    }

    // Factory method
    public static Reservation create(String customerName, String customerEmail,
                                     LocalDateTime reservationTime, Table table) {
        return new Reservation(
                UUID.randomUUID(),
                customerName,
                customerEmail,
                reservationTime,
                table
        );
    }

    // Business method
    public Reservation reschedule(LocalDateTime newTime) {
        return new Reservation(
                this.id,
                this.customerName,
                this.customerEmail,
                newTime,
                this.table
        );
    }

    // Validations
    private String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new ReservationException("Customer name cannot be empty");
        }
        if (name.length() > 100) {
            throw new ReservationException("Name exceeds 100 characters");
        }
        return name;
    }

    private String validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new ReservationException("Invalid email format");
        }
        return email;
    }

    private LocalDateTime validateTime(LocalDateTime time) {
        if (time.isBefore(LocalDateTime.now())) {
            throw new ReservationException("Reservation time must be in the future");
        }
        return time;
    }

    public UUID getId() { return id; }
    public String getCustomerName() { return customerName; }
    public String getCustomerEmail() { return customerEmail; }
    public LocalDateTime getReservationTime() { return reservationTime; }
    public Table getTable() { return table; }

    public void validate() {
        // aqui eu vaalido as coisas
    }
}