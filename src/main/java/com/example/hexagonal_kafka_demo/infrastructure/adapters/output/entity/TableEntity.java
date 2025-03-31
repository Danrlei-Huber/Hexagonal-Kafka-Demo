package com.example.hexagonal_kafka_demo.infrastructure.adapters.output.entity;

import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "tables")
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private int number;

    @Column(name = "capacity")
    private int capacity;

}
