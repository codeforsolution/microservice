package com.hcltech.bos.cgw.fpp.sg.loan.api.repository;

import com.hcltech.bos.cgw.fpp.sg.loan.api.entity.UserAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAuditRepository extends JpaRepository<UserAudit, Long> {
    @Query("select userId, creditScore, lastModified from UserAudit")
    List<UserAudit> findNewAudits();
}
