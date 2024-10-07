package com.hcltech.bos.cgw.fpp.sg.loan.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAudit {
    @Id
    private Long userId;
    private Integer creditScore;
    private LocalDateTime lastModified;

}
