package com.example.nov22.mogo.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class Nov22MongoWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(Nov22MongoWebfluxApplication.class, args);
	}

}
