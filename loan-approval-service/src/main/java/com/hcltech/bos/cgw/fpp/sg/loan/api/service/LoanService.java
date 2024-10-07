package com.hcltech.bos.cgw.fpp.sg.loan.api.service;

import com.hcltech.bos.cgw.fpp.sg.loan.api.entity.LoanApplication;

public interface LoanService {
    LoanApplication applyForLoan(LoanApplication loanApplication);
}
