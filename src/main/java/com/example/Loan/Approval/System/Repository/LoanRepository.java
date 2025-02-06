package com.example.Loan.Approval.System.Repository;

import com.example.Loan.Approval.System.Models.Loan;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LoanRepository {
    private final List<Loan> loans = new ArrayList<>();

    public void save(Loan loan) {
        loans.add(loan);
    }

    public List<Loan> findAll() {
        return loans;
    }
}