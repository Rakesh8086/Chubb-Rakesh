package com.example.nov21.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.nov21.dto.FlightSearchRequest;
import com.example.nov21.entity.Flight;
import com.example.nov21.service.FlightService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v1.0/flight")
public class FlightController {
	
	@Autowired
    FlightService flightService;

    @PostMapping("/airline/inventory/add")
    public Mono<ResponseEntity<Integer>> addFlightInventory(@Valid @RequestBody Flight flight) {
        
    	return flightService.addFlight(flight)
                .map(id -> ResponseEntity.status(HttpStatus.CREATED).body(id));
    }
    
    @PostMapping("/search")
    public ResponseEntity<Flux<Flight>> searchFlights(@Valid @RequestBody FlightSearchRequest request) {
        
        Flux<Flight> matchingFlights = flightService.searchFlights(
                request.getFromPlace(),
                request.getToPlace(),
                request.getJourneyDate()
        );
        
        matchingFlights
        .hasElements()
        .flatMap(hasElements -> {
            if(!hasElements) {
                return Mono.error(new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "No flights found matching the criteria from " +
                        request.getFromPlace() + " to " + request.getToPlace() +
                        " on " + request.getJourneyDate()
                ));
            }
            return Mono.just(true); // It gets out of the stream only if you return
        });
        	

        return new ResponseEntity<>(matchingFlights, HttpStatus.OK);
    }
    
}
