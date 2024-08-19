package com.codeforsolution.address.api.service.impl;

import com.codeforsolution.address.api.model.Address;
import com.codeforsolution.address.api.repository.AddressRepository;
import com.codeforsolution.address.api.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    /**
     * @param
     * @return
     */
    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    /**
     * @return
     */
    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    /**
     * @return
     */
    @Override
    public Optional<Address> getAddressById(Integer addressId) {
        return addressRepository.findById(addressId);
    }
}
