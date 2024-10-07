package com.hcltech.bos.cgw.fpp.sg.loan.api.repository;

import com.hcltech.bos.cgw.fpp.sg.loan.api.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepository  extends JpaRepository<LoanApplication, Long> {
}
