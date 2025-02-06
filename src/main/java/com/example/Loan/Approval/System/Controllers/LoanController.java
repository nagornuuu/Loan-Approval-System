package com.example.Loan.Approval.System.Controllers;

import com.example.Loan.Approval.System.Models.Loan;
import com.example.Loan.Approval.System.Models.User;
import com.example.Loan.Approval.System.Services.LoanProcessingService;
import com.example.Loan.Approval.System.Services.UserService;
import com.example.Loan.Approval.System.Repository.LoanRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LoanController {
    private final UserService userService;
    private final LoanProcessingService loanProcessingService;
    private final LoanRepository loanRepository;

    public LoanController(UserService userService, LoanProcessingService loanProcessingService, LoanRepository loanRepository) {
        this.userService = userService;
        this.loanProcessingService = loanProcessingService;
        this.loanRepository = loanRepository;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/loans")
    public String requestLoan(@RequestBody Loan loan) {
        loanProcessingService.processLoanRequest(loan);
        return "Loan request received.";
    }

    // New endpoint to fetch all loans
    @GetMapping("/loans")
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}
