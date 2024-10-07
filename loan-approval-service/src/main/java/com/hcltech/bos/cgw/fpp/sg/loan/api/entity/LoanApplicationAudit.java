package com.hcltech.bos.cgw.fpp.sg.loan.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table
public class LoanApplicationAudit {
    @Id
    private Long userId;
    private int creditScore;
    private LocalDateTime lastModified;

}
