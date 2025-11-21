package com.example.nov21.repository;

import java.time.LocalDate;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.example.nov21.entity.Flight;

import reactor.core.publisher.Flux;

@Repository
public interface FlightRepository extends R2dbcRepository<Flight, Integer> {

    // We check if there are seats available before executing this custom query.
    Flux<Flight> findByFromPlaceAndToPlaceAndScheduleDateAndAvailableSeatsGreaterThan(
            String fromPlace, 
            String toPlace, 
            LocalDate scheduleDate, 
            int availableSeats
    );
}
