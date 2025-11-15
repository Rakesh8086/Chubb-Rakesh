package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.Order;
import com.example.demo.service.OrderService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class OrderController {
	@Autowired
	private OrderService service;
	@GetMapping("/order")
	public String getOrder() {
	    return "hello";
	}
	
	@PostMapping("/order")
	public Order saveOrder(@Valid @RequestBody Order order) {
		service.insertOrder(order);
		return order;
	}
}
