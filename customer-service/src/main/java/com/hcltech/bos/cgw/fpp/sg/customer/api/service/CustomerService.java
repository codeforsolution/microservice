package com.hcltech.bos.cgw.fpp.sg.customer.api.service;

import com.hcltech.bos.cgw.fpp.sg.customer.api.entity.Customer;

import java.util.List;

public interface CustomerService {
    
    List<Customer> getAllCustomers();

    Customer getCustomer(Long id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customerDetails);

    void deleteCustomer(Long id);
}
