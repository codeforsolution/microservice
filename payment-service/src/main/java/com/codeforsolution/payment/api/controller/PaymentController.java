package com.codeforsolution.payment.api.controller;

import com.codeforsolution.payment.api.entity.Payment;
import com.codeforsolution.payment.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    public ResponseEntity<Payment> doPaymemt(@RequestBody Payment payment){
        return new ResponseEntity<Payment>(paymentService.doPayment(payment), HttpStatus.CREATED);
    }
}
