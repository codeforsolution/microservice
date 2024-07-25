package com.codeforsolution.payment.api.entity.sevice;

import com.codeforsolution.payment.api.entity.Payment;

public interface PaymentService {
    public Payment doPayment(Payment payment);
    public String paymentStatus();
}
