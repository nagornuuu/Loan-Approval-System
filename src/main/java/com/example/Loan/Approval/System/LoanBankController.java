package com.example.Loan.Approval.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class that handles HTTP requests for the Task
 * Management API.
 * This class provides endpoints to create, retrieve, update,
 * and delete tasks.
 */

@RestController
@RequestMapping("/loans")
public class NotesController {
    // Service that contains the business logic for managing
    private final LoanBankService loanBankService;

    /**
     * Constructor for injecting TaskService.
     *
     * @param loanBankService The service responsible for managing
     *                        task operations.
     */
    @Autowired // Automatically injects the TaskService dependency .
    public NotesController(LoanBankService loanBankService) {
        this.loanBankService = loanBankService;
    }

    /**
     * Retrieves all tasks from the system.
     *
     * @return A list of all tasks.
     */

    @GetMapping
    public List<User> getAllUsers() {
        return loanBankService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return notesService.getNoteById(id);
    }

    @GetMapping("/requestLoan")
    public Loan getNoteById(@PathVariable Loan loan, @PathVariable Long id) {
        return loanBankService.requestLoan(loan);
    }
}
