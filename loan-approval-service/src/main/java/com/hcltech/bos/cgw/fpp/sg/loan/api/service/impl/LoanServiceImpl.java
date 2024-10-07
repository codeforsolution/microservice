package com.hcltech.bos.cgw.fpp.sg.loan.api.service.impl;

import com.hcltech.bos.cgw.fpp.sg.loan.api.entity.LoanApplication;
import com.hcltech.bos.cgw.fpp.sg.loan.api.repository.LoanApplicationRepository;
import com.hcltech.bos.cgw.fpp.sg.loan.api.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

//    @Autowired
//    private KafkaTemplate<String, LoanApplication> kafkaTemplate;
//
//    public void sendLoanApplication(LoanApplication application) {
//        kafkaTemplate.send("loan-applications", application);
//    }

    /**
     * @param loanApplication
     * @return
     */
    @Override
//    @KafkaListener(topics = "loan-applications", groupId = "loan-group")
    public LoanApplication applyForLoan(LoanApplication loanApplication) {

        String userId = loanApplication.getUserId();
        Object creditScore = redisTemplate.opsForHash().get("user:" + userId, "credit_score");

        String status = (Integer.parseInt(creditScore.toString()) > 650) ? "Approved" : "Rejected";
        loanApplication.setStatus(status);
        loanApplicationRepository.save(loanApplication);
//        redisTemplate.opsForValue().set("application_status:" + loanApplication.getApplicationId(), status);

        return loanApplication;
    }
}
