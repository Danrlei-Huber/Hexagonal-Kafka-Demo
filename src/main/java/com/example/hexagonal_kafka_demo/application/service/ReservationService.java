package com.example.hexagonal_kafka_demo.application.service;

import com.example.hexagonal_kafka_demo.domain.model.Reservation;
import com.example.hexagonal_kafka_demo.ports.input.ReservationUseCase;
import com.example.hexagonal_kafka_demo.ports.output.EventPublisherPort;
import com.example.hexagonal_kafka_demo.ports.output.ReservationRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService implements ReservationUseCase {
    private final ReservationRepositoryPort repository;
    private final EventPublisherPort eventPublisher;

    @Autowired
    public ReservationService(ReservationRepositoryPort repository, EventPublisherPort eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        reservation.validate();
        Reservation saved = repository.save(reservation);
        //eventPublisher.publishReservationCreated(saved); // Evento para Kafka
        return saved;
    }

    @Override
    public List<Reservation> findByDate(LocalDate date) {
        return List.of();
    }

}
