package com.example.customer_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customer_service.CustomerEntity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public List<Customer> findCustomerByOrderID(long orderID);

}
