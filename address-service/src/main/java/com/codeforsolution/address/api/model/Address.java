package com.codeforsolution.address.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Integer addressId;
    private String firstName;
    private String lastName;
    private int pinCode;
    private String city;
    private String state;
    private String stateCode;
    private String addressLine1;
    private String string;
    private String addressLine2;
    private String landmark;
    private String contactNumber;

}
