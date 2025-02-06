package com.example.Loan.Approval.System.Services;

import com.example.Loan.Approval.System.Models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class that manages tasks.
 * This class acts as the business logic layer, handling the
 * creation, retrieval,
 * updating, and deletion of tasks in memory.
 */

@Service // Marks this class as a Spring service, allowing  dependency injection.
public class LoanService {

    // In-memory list that stores tasks (simulating a database).
    private final List<User> userList = new ArrayList<>();

    // Variable to generate unique IDs for each task.
    private Long nextId = 1L;

    /**
     * Constructor that initializes the service with three
     * default tasks.
     * These tasks will be available when the application
     * starts.
     */
    public LoanService() {
    }

    /**
     * Retrieves the full list of tasks.
     *
     * @return List of all tasks.
     */

    public List<User> getAllUsers() {
        return userList; // Returns all tasks stored in memory.
    }

    /**
     * Finds a note by its unique ID.
     *
     * @param id The ID of the note to retrieve.
     * @return The task if found, otherwise null.
     */
    public User getUserById(Long id) {
        return userList.stream()
                .filter(user -> user.getId() == (id)) // Filter tasks by ID
                .findFirst() // Return the first match (if any)
                .orElse(null); // Return null if no task is found
    }

    /**
     * Creates a new task and adds it to the list.
     *
     * @param user The task object provided in the request.
     * @return The newly created task with an assigned ID.
     */

    public User createUser(User user) {
        user.setId(nextId++); // Assign a unique ID to the new task
        userList.add(user); // Add the task to the in-memory list
        return user; // Return the created task
    }

}

