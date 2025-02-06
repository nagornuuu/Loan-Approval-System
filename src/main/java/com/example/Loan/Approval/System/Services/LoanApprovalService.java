package com.example.Loan.Approval.System.Services;

import com.example.Loan.Approval.System.Models.User;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for evaluating loan approval based on user details
 */
@Service
public class LoanApprovalService {
    /**
     * Evaluates whether a user is eligible for a loan based on credit score, income, and existing debts
     *
     * @param user The user applying for the loan
     * @param loanAmount The requested loan amount
     * @return True if the loan is approved, otherwise false
     */
    public boolean evaluateLoan(User user, double loanAmount) {
        if (user.getCreditScore() < 600 || loanAmount > user.getMonthlyIncome() * 5) {
            return false;
        }

        // Reduce approval probability if user has unpaid loans
        if (user.hasUnpaidLoans()) {
            return Math.random() > 0.5; // 50% chance of rejection instead of instant rejection
        }

        return true;
    }
}
