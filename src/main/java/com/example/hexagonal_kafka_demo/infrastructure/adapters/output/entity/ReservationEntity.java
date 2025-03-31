package com.example.hexagonal_kafka_demo.infrastructure.adapters.output.entity;

import com.example.hexagonal_kafka_demo.domain.model.Table;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@jakarta.persistence.Table(name = "reservations")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_email", nullable = false)
    private String customerEmail;

    @Column(name = "reservation_time", nullable = false)
    private LocalDateTime reservationTime;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private TableEntity Table;

}
