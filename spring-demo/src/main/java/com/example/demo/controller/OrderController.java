package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.Orders;
import com.example.demo.service.OrderService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/order")
    public Orders saveOrder(@Valid @RequestBody Orders order) {
        log.debug("logger added");
        service.insertOrder(order);
        return order;
    }
}
