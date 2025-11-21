package com.example.nov21.service;

import java.time.LocalDate;

import com.example.nov21.entity.Flight;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FlightService {

    // used for adding flight
    Mono<Integer> addFlight(Flight flight);
    
    // for searching flights
    Flux<Flight> searchFlights(String fromPlace, String toPlace, LocalDate scheduleDate);
    
    // get flight by its ID
    Mono<Flight> getFlightById(Integer flightId);
    
    // to update flight seats after booking tickets
    Mono<Flight> updateFlightInventory(Flight flight);
}

