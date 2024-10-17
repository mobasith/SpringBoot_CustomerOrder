package com.example.order_service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order_service.entity.orderEntity;

public interface OrderRepository extends JpaRepository<orderEntity, Long> {

}
