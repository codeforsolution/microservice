package com.hcltech.bos.cgw.fpp.sg.customer.api.repository;

import com.hcltech.bos.cgw.fpp.sg.customer.api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
