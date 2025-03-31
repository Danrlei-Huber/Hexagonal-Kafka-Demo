package com.example.hexagonal_kafka_demo.infrastructure.adapters.output.persistence.jpa;

import com.example.hexagonal_kafka_demo.infrastructure.adapters.output.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface JpaReservationRepository
        extends JpaRepository<ReservationEntity, UUID> {

    // Consulta customizada com JPQL
    @Query("SELECT r FROM ReservationEntity r WHERE r.customerEmail = :email")
    List<ReservationEntity> findByCustomerEmail(@Param("email") String email);
}