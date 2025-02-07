package com.example.Loan.Approval.System.Controllers;

import com.example.Loan.Approval.System.Models.Loan;
import com.example.Loan.Approval.System.Models.User;
import com.example.Loan.Approval.System.Services.LoanProcessingService;
import com.example.Loan.Approval.System.Services.UserService;
import com.example.Loan.Approval.System.Repository.LoanRepository;

import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller class that handles loan and user-related operations
 */
@RestController
@RequestMapping("/api")
public class LoanController {
    private UserService userService;
    private LoanProcessingService loanProcessingService;
    private LoanRepository loanRepository;

    /**
     * Constructor for LoanController
     *
     * @param userService Service handling user operations
     * @param loanProcessingService Service handling loan processing
     * @param loanRepository service handling loan repository
     */
    public LoanController(UserService userService, LoanProcessingService loanProcessingService, LoanRepository loanRepository) {
        this.userService = userService;
        this.loanProcessingService = loanProcessingService;
        this.loanRepository = loanRepository;
    }

    /**
     * Endpoint to create a new user
     *
     * @param user User details to be created
     * @return The created User object
     */
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    /**
     * Endpoint to fetch all users
     *
     * @return List of all users in the system
     */
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Endpoint to request a loan
     *
     * @param loan Loan request details
     * @return Confirmation message for the loan request
     */
    @PostMapping("/loans")
    public String requestLoan(@RequestBody Loan loan) {
        loanProcessingService.processLoanRequest(loan);
        return "Loan request received";
    }

    /**
     * Retrieves a list of all loans from the repository
     *
     * @return a list of loan objects representing all loans in the database
     */
    @GetMapping("/loans")
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    /**
     * Endpoint to find a user by ID
     *
     * @param userId The ID of the user to find
     * @return User object if found, otherwise an empty User with "User not found" message
     */
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") long userId) {
        User user = userService.findUserById(userId);

        if (user != null) {
            return user;
        } else {
            return new User(-1, "User not found", 0, 0, false); // Returning a default user object
        }
    }
}
