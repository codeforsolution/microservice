package com.hcltech.bos.cgw.fpp.sg.loan.api.controller;

import com.hcltech.bos.cgw.fpp.sg.loan.api.entity.LoanApplication;
import com.hcltech.bos.cgw.fpp.sg.loan.api.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/apply")
    public ResponseEntity<LoanApplication> applyLoan(@RequestBody LoanApplication loanApplication) {
        LoanApplication loanApplicationStatus = loanService.applyForLoan(loanApplication);
        return new ResponseEntity<>(loanApplicationStatus, HttpStatus.OK);
    }

}
