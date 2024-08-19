package com.codeforsolution.address.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class AddressDto {

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
