package com.example.order_service.entity;

import java.util.List;

import com.example.order_service.model.CustomerEnt;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class orderEntity {

    @Id
    private long orderID;
    private String ordername;

    @Transient
    private List<CustomerEnt> clist;

}
