package com.example.hexagonal_kafka_demo.infrastructure.adapters.output.messaging;

import com.example.hexagonal_kafka_demo.domain.model.Reservation;
import com.example.hexagonal_kafka_demo.infrastructure.adapters.output.messaging.event.ReservationEvent;
import com.example.hexagonal_kafka_demo.ports.output.EventPublisherPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class KafkaReservationProducer implements EventPublisherPort {
/*
    private final KafkaTemplate<String, ReservationEvent> kafkaTemplate;

    public KafkaReservationProducer(KafkaTemplate<String, ReservationEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
*/
    @Override
    public void publishReservationCreated(Reservation reservation) {

        ReservationEvent event = ReservationEvent.createReservationCreatedEvent(
                reservation.getId(), reservation.getCustomerEmail(), reservation.getReservationTime(), reservation.getTable().getNumber());
        //kafkaTemplate.send("reservation-events", event);
    }

    @Override
    public void publishReservationCancelled(UUID reservationId) {

    }

}