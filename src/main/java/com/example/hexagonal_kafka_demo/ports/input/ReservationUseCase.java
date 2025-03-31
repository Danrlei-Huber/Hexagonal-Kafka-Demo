package com.example.hexagonal_kafka_demo.ports.input;

import com.example.hexagonal_kafka_demo.domain.model.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationUseCase {
    Reservation createReservation(Reservation reservation);
    List<Reservation> findByDate(LocalDate date);
}