package com.codeforsolution.address.api.controller;

import com.codeforsolution.address.api.dto.AddressDto;
import com.codeforsolution.address.api.model.Address;
import com.codeforsolution.address.api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressDto> createAddress(@RequestBody Address address){
        return new ResponseEntity<AddressDto>((MultiValueMap<String, String>) addressService.createAddress(address), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress(){
        return new ResponseEntity<>(addressService.getAllAddress(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> getAddressByEmpId(@PathVariable Long id){
        return new ResponseEntity<>("Test data from Address-service", HttpStatus.OK);
    }


}
