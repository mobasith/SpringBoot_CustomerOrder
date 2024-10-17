package com.example.order_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order_service.Repo.OrderRepository;
import com.example.order_service.entity.orderEntity;

@Service
public class OrderService {

    @Autowired
    OrderRepository repo;

    public List<orderEntity> findAllorders() {
        return repo.findAll();
    }

    public orderEntity getAorder(long orderID) {
        Optional<orderEntity> oo = repo.findById(orderID);
        if (oo.isPresent()) {
            return oo.get();
        } else {
            return null;
        }
    }

    public orderEntity addorder(orderEntity neworder) {
        repo.saveAndFlush(neworder);
        return neworder;
    }

    public orderEntity updateOrder(orderEntity norder) {
        repo.saveAndFlush(norder);
        return norder;
    }

}
