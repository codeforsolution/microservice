package com.codeforsolution.payment.api.entity.sevice.impl;

import com.codeforsolution.payment.api.entity.Payment;
import com.codeforsolution.payment.api.entity.sevice.PaymentService;
import com.codeforsolution.payment.api.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentStatus());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    /**
     * @return
     */
    @Override
    public String paymentStatus() {
        return new Random().nextBoolean() ? "success" : "false";
    }

}
