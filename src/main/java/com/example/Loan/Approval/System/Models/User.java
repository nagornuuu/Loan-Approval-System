package com.example.Loan.Approval.System.Models;
import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String name;
    private int creditScore;
    private double monthlyIncome;
    private boolean hasUnpaidLoans;
    private List<Loan> userLoans = new ArrayList<>();

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
    public boolean getUnpaidLoans() {
        return hasUnpaidLoans;
    }

    public void addLoan(Loan loan) { userLoans.add(loan); }
    public void setId(long id) { this.id = id; }

}
