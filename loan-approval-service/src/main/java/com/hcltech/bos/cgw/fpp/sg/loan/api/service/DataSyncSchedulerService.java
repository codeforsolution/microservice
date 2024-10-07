package com.hcltech.bos.cgw.fpp.sg.loan.api.service;

import com.hcltech.bos.cgw.fpp.sg.loan.api.entity.LoanApplication;
import com.hcltech.bos.cgw.fpp.sg.loan.api.entity.LoanApplicationAudit;
import com.hcltech.bos.cgw.fpp.sg.loan.api.entity.UserAudit;
import com.hcltech.bos.cgw.fpp.sg.loan.api.repository.LoanApplicationAuditRepository;
import com.hcltech.bos.cgw.fpp.sg.loan.api.repository.UserAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class DataSyncSchedulerService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private LoanApplicationAuditRepository loanApplicationAuditRepository;

    @Autowired
    private UserAuditRepository userAuditRepository;

    @Scheduled(fixedRate = 5000) // Check every 5 seconds
    public void syncDataWithRedis() {
        syncLoanApplications();
        syncUsers();
    }

    private void syncUsers() {
        System.out.println("user sync");
        //List<UserAudit> audits = userAuditRepository.findNewAudits();
        List<UserAudit> audits = userAuditRepository.findAll();
        for (UserAudit audit : audits) {
            UserAudit user = new UserAudit(); // Fetch user by audit.userId
            redisTemplate.opsForValue().set("credit_score:" + audit.getUserId() , audit.getCreditScore());
            // Remove the audit entry after processing if necessary
        }
    }

    private void syncLoanApplications() {
        System.out.println("loan application sync");
        List<LoanApplicationAudit> audits = loanApplicationAuditRepository.findNewAudits();
        for (LoanApplicationAudit audit : audits) {
            LoanApplication application = new LoanApplication(); // Fetch application by audit.applicationId
            redisTemplate.opsForValue().set("application_status:" + application.getApplicationId(), application.getStatus());
            // Remove the audit entry after processing if necessary
        }

    }
}
