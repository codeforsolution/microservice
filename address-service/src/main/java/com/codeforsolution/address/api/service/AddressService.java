package com.codeforsolution.address.api.service;

import com.codeforsolution.address.api.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    public Address createAddress(Address addressRequest);
    public List<Address> getAllAddress();
    public Optional<Address> getAddressById(Integer addressId);
}
