package com.codeforsolution.payment.api.service;


import com.codeforsolution.payment.api.entity.Payment;
import com.codeforsolution.payment.api.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment){
        payment.setTransactionId(UUID.randomUUID().toString());
        return  paymentRepository.save(payment);
    }
}
