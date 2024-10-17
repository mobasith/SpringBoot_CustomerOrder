package com.example.customer_service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer_service.CustomerEntity.Customer;
import com.example.customer_service.Repository.CustomerRepository;

@Service
public class Customer_Service {
    @Autowired
    CustomerRepository repo;

    public List<Customer> getAll() {
        List<Customer> clist = repo.findAll();
        return clist;

    }

    public Customer getACustomer(long customerID) {
        Optional<Customer> co = repo.findById(customerID);
        if (co.isPresent()) {
            return co.get();

        } else
            return null;

    }

    public Customer addCustomer(Customer newc) {
        repo.saveAndFlush(newc);
        return newc;

    }

    public Customer updateCustomer(Customer newc) {
        repo.saveAndFlush(newc);
        return newc;

    }

    public List<Customer> findCustomerByOrderID(long orderID) {
        return repo.findCustomerByOrderID(orderID);

    }

}
