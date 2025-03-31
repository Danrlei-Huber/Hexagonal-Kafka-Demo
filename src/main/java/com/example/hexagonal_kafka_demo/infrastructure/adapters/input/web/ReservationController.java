package com.example.hexagonal_kafka_demo.infrastructure.adapters.input.web;

import com.example.hexagonal_kafka_demo.application.dto.ReservationRequest;
import com.example.hexagonal_kafka_demo.application.dto.ReservationResponse;
import com.example.hexagonal_kafka_demo.domain.model.Reservation;
import com.example.hexagonal_kafka_demo.ports.input.ReservationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/reservations")
public class ReservationController {
    private final ReservationUseCase reservationUseCase;

    @Autowired
    public ReservationController(ReservationUseCase reservationUseCase) {
        this.reservationUseCase = reservationUseCase;
    }

    @PostMapping
    public ResponseEntity<ReservationResponse> create(@RequestBody ReservationRequest request) {
        Reservation reservation = reservationUseCase.createReservation(request.toDomain());
        return ResponseEntity.created(URI.create("/reservations/" + reservation.getId()))
                .body(ReservationResponse.fromDomain(reservation));
    }

    // listar todas as reservas
    @GetMapping
    public String readAll() {
        return "list all reservations endpoint";
    }

    // retornar uma reserva para edicoes
    @GetMapping("/one")
    public String getOne() {
        return  "return one reservation endpoint";
    }

    // cancelar reserva   |    Deletar reserva
    @DeleteMapping
    public String delete() {
        return "cancel reservations endpoint";
    }

    // editar reserva
    @PatchMapping
    public String edit() {
        return "edit reservation endpoint";
    }

}
