package com.example.order_service.model;

import jakarta.persistence.Id;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEnt {

    @Id
    private long customerID;
    private String cname;
    private long orderID;

}
