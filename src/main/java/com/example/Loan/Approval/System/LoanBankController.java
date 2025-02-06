package com.example.Loan.Approval.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanBankController {
    private final LoanBankService loanBankService;

    @Autowired
    public LoanBankController(LoanBankService loanBankService) {
        this.loanBankService = loanBankService;
    }

    @PostMapping("/apply")
    public Loan createLoan(@RequestBody Loan request) {
        User user = loanBankService.getUserById(request.getUserId());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return loanBankService.createLoan(user, request.getAmount(), request.getRepaymentPeriod());
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User request) {
        return loanBankService.createUser(request.getName(), request.getCreditScore(), request.getIncome(), request.isHasUnpaidLoans());
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return loanBankService.getAllUsers();
    }
}
