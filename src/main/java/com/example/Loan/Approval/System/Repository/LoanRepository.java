package com.example.Loan.Approval.System.Repository;

import com.example.Loan.Approval.System.Models.Loan;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for managing loan data
 * This is a simple in-memory repository that stores loan information
 */
@Repository
public class LoanRepository {

    /**
     * List to store loan objects in memory
     */
    private List<Loan> loans = new ArrayList<>();

    /**
     * Saves a new loan to the repository
     *
     * @param loan The loan object to be stored
     */
    public void save(Loan loan) {
        loans.add(loan);
    }

    /**
     * Retrieves all loans stored in the repository
     *
     * @return A list of all loans
     */
    public List<Loan> findAll() {
        return loans;
    }
}