package com.example.Loan.Approval.System.Services;

import com.example.Loan.Approval.System.Models.LoanRequest;
import com.example.Loan.Approval.System.Models.User;
import com.example.Loan.Approval.System.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class LoanProcessingService {
    private ExecutorService executorService = Executors.newFixedThreadPool(5);
    private LoanApprovalService loanApprovalService;
    private UserRepository userRepository;

    public LoanProcessingService(LoanApprovalService loanApprovalService, UserRepository userRepository) {
        this.loanApprovalService = loanApprovalService;
        this.userRepository = userRepository;
    }

    public void processLoanRequest(LoanRequest loanRequest) {
        executorService.submit(() -> {

            User user = userRepository.findById(loanRequest.getUserId());

            if (user == null) {
                System.out.println("User not found: " + loanRequest.getUserId());
                return;
            }

            boolean isApproved = loanApprovalService.evaluateLoan(user, loanRequest.getAmount());

            if (isApproved) {
                System.out.println("✅ Loan APPROVED for user: " + loanRequest.getUserId());
            } else {
                System.out.println("❌ Loan REJECTED for user: " + loanRequest.getUserId());
            }
        });
    }
}
