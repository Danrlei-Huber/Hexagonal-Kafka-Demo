package com.example.hexagonal_kafka_demo.domain.model;

public class Table {
    private int number;
    private int capacity;

    public Table(int tableNumber, int totalCapacity) {
        this.number = tableNumber;
        this.capacity = totalCapacity;
    }

    public void validateAvailability() {
        // Lógica para verificar disponibilidade da mesa
    }

    public int getNumber() {
        return number;
    }

    public int getCapacity() {
        return capacity;
    }

}