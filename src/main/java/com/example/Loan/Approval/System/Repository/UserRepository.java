package com.example.Loan.Approval.System.Repository;

import com.example.Loan.Approval.System.Models.User;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private Map<Long, User> users = new HashMap<>();
    private long nextId = 1;

    /**
     * Saves a new user to the repository and assigns a unique ID
     *
     * @param user The user object to be stored
     * @return The saved user with a generated ID
     */
    public User save(User user) {
        user = new User(nextId++, user.getName(), user.getCreditScore(), user.getMonthlyIncome(), user.hasUnpaidLoans());
        users.put(user.getId(), user);
        return user;
    }

    /**
     * Finds a user by their unique ID
     *
     * @param userId The ID of the user to find
     * @return The user object if found, otherwise null
     */
    public User findById(long userId) {
        return users.get(userId);
    }

    /**
     * Retrieves all users stored in the repository
     *
     * @return A list of all users
     */
    public List<User> findAll() {
        return users.values().stream().collect(Collectors.toList());
    }
}
