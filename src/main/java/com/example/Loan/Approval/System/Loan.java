package com.example.Loan.Approval.System;

public class Loan {
    int userId;
    double amount;
    int repaymentPeriod;

    public Loan(int userId, double amount, int repaymentPeriod){
        this.userId = userId;
        this.amount = amount;
        this.repaymentPeriod = repaymentPeriod;
    }

    public int getUserId() {
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
