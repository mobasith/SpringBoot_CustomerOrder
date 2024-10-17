package com.example.customer_service.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer_service.CustomerEntity.Customer;
import com.example.customer_service.Service.Customer_Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    Customer_Service service;

    @GetMapping("")
    public List<Customer> getAll() {
        List<Customer> creslist = service.getAll();
        return creslist;

    }

    @GetMapping("/{customerID}")
    public Customer getACustomer(@PathVariable("customerID") long customerID) {
        return service.getACustomer(customerID);

    }

    @PostMapping("")
    public Customer addCustomer(@RequestBody Customer newc) {
        return service.addCustomer(newc);

    }

    @PutMapping("")
    public Customer updateCustomer(Customer newc) {
        return service.updateCustomer(newc);

    }

    @GetMapping("/orders/{orderID}")
    public List<Customer> findCustomerByOrderID(@PathVariable("orderID") long orderID) {
        return service.findCustomerByOrderID(orderID);
    }

}
