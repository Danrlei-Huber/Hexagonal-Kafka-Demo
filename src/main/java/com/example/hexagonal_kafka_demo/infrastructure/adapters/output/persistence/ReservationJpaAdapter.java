package com.example.hexagonal_kafka_demo.infrastructure.adapters.output.persistence;

import com.example.hexagonal_kafka_demo.domain.model.Reservation;
import com.example.hexagonal_kafka_demo.infrastructure.adapters.output.persistence.jpa.JpaReservationRepository;
import com.example.hexagonal_kafka_demo.ports.output.ReservationRepositoryPort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ReservationJpaAdapter implements ReservationRepositoryPort {

    private final JpaReservationRepository jpaRepository;

    public ReservationJpaAdapter(JpaReservationRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Reservation> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public boolean isTableAvailable(int tableNumber, LocalDateTime time) {
        return false;
    }

    @Override
    public Reservation save(Reservation reservation) {
        return Reservation.create(
                reservation.getCustomerName(), reservation.getCustomerEmail(), reservation.getReservationTime(), reservation.getTable());
    }
}
