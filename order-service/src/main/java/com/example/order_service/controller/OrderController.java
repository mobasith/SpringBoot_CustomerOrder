package com.example.order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.example.order_service.entity.orderEntity;
import com.example.order_service.model.CustomerEnt;
import com.example.order_service.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderService service;

    @GetMapping("")
    List<orderEntity> findAllorders() {
        return service.findAllorders();
    }

    @CircuitBreaker(name = "ciremp", fallbackMethod = "fallbackCustomer")
    @GetMapping("/{orderID}")
    public orderEntity getAorder(@PathVariable long orderID) {
        RestClient restClient = RestClient.create();
        orderEntity ordersx = service.getAorder(orderID);
        List<CustomerEnt> allcusts = restClient

                .get()
                .uri("http://localhost:8081/api/customers/orders/" + orderID)
                .retrieve()
                .body(List.class);
        ordersx.setClist(allcusts);

        return ordersx;
    }

    public String fallbackCustomer(Exception e) {
        return "customer-service failed...";
    }

    @PostMapping("")
    public orderEntity addorder(@RequestBody orderEntity neworder) {
        return service.addorder(neworder);
    }

    @PutMapping("")
    public orderEntity updateOrder(@RequestBody orderEntity norder) {
        return service.updateOrder(norder);
    }

}
