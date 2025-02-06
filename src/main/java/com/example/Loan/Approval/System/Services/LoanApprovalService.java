package com.example.Loan.Approval.System.Services;

import com.example.Loan.Approval.System.Models.User;
import org.springframework.stereotype.Service;

@Service
public class LoanApprovalService {
    public boolean evaluateLoan(User user, double loanAmount) {
        if (user.getCreditScore() < 600) {
            return false;
        }
        if (loanAmount > user.getMonthlyIncome() * 5){
            return false;
        }

        // Reduce approval probability if user has unpaid loans
        if (user.hasUnpaidLoans()) {
            return Math.random() > 0.5; // 50% chance of rejection instead of instant rejection
        }

        return true;
    }
}
