package com.example.Loan.Approval.System;

public class User {
    private long id;
    private String name;
    private int creditScore;
    private double income;
    private boolean hasUnpaidLoans;

    public User(long id, String name, int creditScore, double income, boolean hasUnpaidLoans){
        this.id = id;
        this.name = name;
        this.creditScore = creditScore;
        this.income = income;
        this.hasUnpaidLoans = hasUnpaidLoans;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public double getIncome() {
        return income;
    }

    public boolean isHasUnpaidLoans() {
        return hasUnpaidLoans;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setHasUnpaidLoans(boolean hasUnpaidLoans) {
        this.hasUnpaidLoans = hasUnpaidLoans;
    }

}
