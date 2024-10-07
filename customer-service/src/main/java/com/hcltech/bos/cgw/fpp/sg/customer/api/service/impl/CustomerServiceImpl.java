package com.hcltech.bos.cgw.fpp.sg.customer.api.service.impl;

import com.hcltech.bos.cgw.fpp.sg.customer.api.entity.Customer;
import com.hcltech.bos.cgw.fpp.sg.customer.api.repository.CustomerRepository;
import com.hcltech.bos.cgw.fpp.sg.customer.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * @return
     */
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));;
    }

    /**
     * @param customer
     * @return
     */
    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * @param id
     * @param customerDetails
     * @return
     */
    @Override
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = getCustomer(id);
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setCustomerType(customerDetails.getCustomerType());
        customer.setPhone(customerDetails.getPhone());
        customer.setAddress(customerDetails.getAddress());
        return customerRepository.save(customer);
    }

    /**
     * @param id
     */
    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
