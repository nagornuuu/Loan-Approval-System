package com.example.Loan.Approval.System.Models;

/**
 * Represents a loan request made by a user
 */
public class Loan {
    private long userId;
    private double amount;
    private int repaymentPeriod;
    private boolean isApproved;

    /**
     * Constructs a new Loan instance with the specified user ID, amount, and repayment period
     *
     * @param userId          The ID of the user requesting the loan
     * @param amount          The amount of money requested
     * @param repaymentPeriod The repayment period in months
     */
    public Loan(long userId, double amount, int repaymentPeriod) {
        this.userId = userId;
        this.amount = amount;
        this.repaymentPeriod = repaymentPeriod;
        this.isApproved = false;
    }

    /**
     * Gets the user ID associated with the loan
     *
     * @return The user ID
     */
    public long getUserId() { return userId; }

    /**
     * Gets the amount of the loan
     *
     * @return The loan amount
     */
    public double getAmount() { return amount; }

    public boolean isApproved() { return isApproved; }

    /**
     * Sets the approval status of the loan
     *
     * @param approved True if the loan is approved, otherwise false
     */
    public void setApproved(boolean approved) { isApproved = approved; }
}
