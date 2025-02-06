package com.example.Loan.Approval.System.Models;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user in the loan approval system
 */
public class User {
    private long id;
    private String name;
    private int creditScore;
    private double monthlyIncome;
    private boolean hasUnpaidLoans;
    private List<Loan> userLoans = new ArrayList<>();

    /**
     * Constructs a new User instance with the specified attributes
     *
     * @param id            The unique ID of the user
     * @param name          The name of the user
     * @param creditScore   The credit score of the user
     * @param monthlyIncome The user's monthly income
     * @param hasUnpaidLoans Whether the user has unpaid loans
     */
    public User(long id, String name, int creditScore, double monthlyIncome, boolean hasUnpaidLoans) {
        this.id = id;
        this.name = name;
        this.creditScore = creditScore;
        this.monthlyIncome = monthlyIncome;
        this.hasUnpaidLoans = hasUnpaidLoans;
    }

    // Getters and Setters
    public long getId() { return id; }
    public String getName() { return name; }
    public int getCreditScore() { return creditScore; }
    public double getMonthlyIncome() { return monthlyIncome; }
    public boolean hasUnpaidLoans() { return hasUnpaidLoans; }
    public List<Loan> getUserLoans() { return userLoans; }
    public void addLoan(Loan loan) { userLoans.add(loan); }

}
