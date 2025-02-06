package com.example.Loan.Approval.System;

public class Loan {
    long userId;
    double amount;
    int repaymentPeriod;

    public Loan(long userId, double amount, int repaymentPeriod){
        this.userId = userId;
        this.amount = amount;
        this.repaymentPeriod = repaymentPeriod;
    }

    public long getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    public int getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setRepaymentPeriod(int repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }
}
