package com.example.nov21.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nov21.entity.Flight;
import com.example.nov21.repository.FlightRepository;
import com.example.nov21.service.FlightService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
    FlightRepository flightRepository;

    @Override
    public Mono<Integer> addFlight(Flight flight) {
    	flight.setAvailableSeats(flight.getTotalSeats());
        
    	return flightRepository.save(flight)
    			.map(Flight::getId);
    }
    
    @Override
    public Flux<Flight> searchFlights(String fromPlace, String toPlace, LocalDate scheduleDate) {
        return flightRepository.findByFromPlaceAndToPlaceAndScheduleDateAndAvailableSeatsGreaterThan(
                fromPlace, 
                toPlace, 
                scheduleDate, 
                0 // show flights with 1 or more available seats
        );
    }
    
    @Override
    public Mono<Flight> getFlightById(Integer flightId) {
    	Mono<Flight> flightMono = flightRepository.findById(flightId);
    	
    	return flightMono;
    }
    
    @Override
    public Mono<Flight> updateFlightInventory(Flight flight) {
        return flightRepository.save(flight);
    }
}