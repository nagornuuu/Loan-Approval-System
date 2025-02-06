package com.example.Loan.Approval.System.Models;

public class Loan {
    private long userId;
    private double amount;
    private int repaymentPeriod;
    private boolean isApproved;

    public Loan(long userId, double amount, int repaymentPeriod) {
        this.userId = userId;
        this.amount = amount;
        this.repaymentPeriod = repaymentPeriod;
    }

    // Getters and Setters
    public long getUserId() { return userId; }
    public double getAmount() { return amount; }
    public int getRepaymentPeriod() { return repaymentPeriod; }
    public boolean isApproved() { return isApproved; }
    public void setApproved(boolean approved) { isApproved = approved; }
}
