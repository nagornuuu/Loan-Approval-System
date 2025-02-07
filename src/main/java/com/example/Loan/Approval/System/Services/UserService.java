package com.example.Loan.Approval.System.Services;

import com.example.Loan.Approval.System.Models.User;
import com.example.Loan.Approval.System.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class that handles user-related operations
 */
@Service
public class UserService {
    /**
     * Repository for managing user data
     */
    private UserRepository userRepository;

    /**
     * Constructs a UserService with a given UserRepository
     *
     * @param userRepository The repository for managing user data
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Registers a new user in the system
     *
     * @param user The user to be registered
     * @return The saved user instance
     */
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Retrieves all users from the repository
     *
     * @return A list of all registered users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(long userId) {
        return userRepository.findById(userId);
    }

}
