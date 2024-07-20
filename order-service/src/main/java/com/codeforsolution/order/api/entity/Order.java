package com.codeforsolution.order.api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private int id;
    private String name;
    private int quantity;
    private double price;

}