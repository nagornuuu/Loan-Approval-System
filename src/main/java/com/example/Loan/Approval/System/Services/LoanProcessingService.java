package com.example.Loan.Approval.System.Services;

import com.example.Loan.Approval.System.Models.Loan;
import com.example.Loan.Approval.System.Models.User;
import com.example.Loan.Approval.System.Repository.LoanRepository;
import com.example.Loan.Approval.System.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Service class responsible for processing loan requests asynchronously
 */
@Service
public class LoanProcessingService {

    /**
     * Executor service to handle asynchronous loan processing
     */
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    /**
     * Service to evaluate loan approval
     */
    private LoanApprovalService loanApprovalService;

    /**
     * Repository for managing user data
     */
    private UserRepository userRepository;

    /**
     * Repository for managing loan data
     */
    private LoanRepository loanRepository;

    /**
     * Constructs a LoanProcessingService with necessary dependencies
     *
     * @param loanApprovalService The service for evaluating loan approval
     * @param userRepository The repository for accessing user data
     * @param loanRepository The repository for storing loan data
     */
    public LoanProcessingService(LoanApprovalService loanApprovalService, UserRepository userRepository, LoanRepository loanRepository) {
        this.loanApprovalService = loanApprovalService;
        this.userRepository = userRepository;
        this.loanRepository = loanRepository;
    }

    /**
     * Processes a loan request asynchronously
     *
     * @param loan The loan request to process
     */
    public void processLoanRequest(Loan loan) {
        executorService.submit(() -> {
            User user = userRepository.findById(loan.getUserId());

            if (user == null) {
                System.out.println("❌ User not found: " + loan.getUserId());
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
