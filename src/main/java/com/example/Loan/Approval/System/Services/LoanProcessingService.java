package com.example.Loan.Approval.System.Services;

import com.example.Loan.Approval.System.Models.Loan;
import com.example.Loan.Approval.System.Models.User;
import com.example.Loan.Approval.System.Repository.LoanRepository;
import com.example.Loan.Approval.System.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class LoanProcessingService {
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private final LoanApprovalService loanApprovalService;
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;

    public LoanProcessingService(LoanApprovalService loanApprovalService, UserRepository userRepository, LoanRepository loanRepository) {
        this.loanApprovalService = loanApprovalService;
        this.userRepository = userRepository;
        this.loanRepository = loanRepository;
    }

    public void processLoanRequest(Loan loan) {
        executorService.submit(() -> {
            User user = userRepository.findById(loan.getUserId());

            if (user == null) {
                System.out.println("User not found: " + loan.getUserId());
                return;
            }

            boolean isApproved = loanApprovalService.evaluateLoan(user, loan.getAmount());
            loan.setApproved(isApproved);

            // Store loan in repository
            loanRepository.save(loan);

            if (isApproved) {
                System.out.println("✅ Loan APPROVED for user: " + loan.getUserId());
                user.addLoan(loan);
            } else {
                System.out.println("❌ Loan REJECTED for user: " + loan.getUserId());
            }
        });
    }
}
