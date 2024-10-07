package com.hcltech.bos.cgw.fpp.sg.customer.api.entity;


/**
 *
 Customer ID: A unique identification number for the customer
 Name: The customer's name
 Address: The customer's address
 Phone number: The customer's phone number
 Email address: The customer's email address
 CustomerType: A category for the customer based on bank policies
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Long customerId;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String customerType;


}
