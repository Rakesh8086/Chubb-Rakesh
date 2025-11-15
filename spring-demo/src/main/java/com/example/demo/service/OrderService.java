package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.request.Order;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {
	public void insertOrder(Order order) {
		log.debug(order.toString());
	}
}