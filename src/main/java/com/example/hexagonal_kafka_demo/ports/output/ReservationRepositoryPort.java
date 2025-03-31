package com.example.hexagonal_kafka_demo.ports.output;

import com.example.hexagonal_kafka_demo.domain.model.Reservation;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepositoryPort {

    /**
     * Salva uma reserva no repositório
     * @param reservation A reserva a ser persistida
     * @return A reserva salva com ID gerado
     */
    Reservation save(Reservation reservation);

    /**
     * Busca uma reserva por ID
     * @param id O ID da reserva
     * @return Um Optional contendo a reserva, se encontrada
     */
    Optional<Reservation> findById(UUID id);

    /**
     * Remove uma reserva do repositório
     * @param id O ID da reserva a ser removida
     */
    void deleteById(UUID id);

    /**
     * Verifica se uma mesa está disponível em um horário
     * @param tableNumber O número da mesa
     * @param time O horário desejado
     * @return true se a mesa estiver disponível
     */
    boolean isTableAvailable(int tableNumber, LocalDateTime time);

}