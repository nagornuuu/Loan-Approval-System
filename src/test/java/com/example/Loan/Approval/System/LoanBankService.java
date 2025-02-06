package com.example.Loan.Approval.System;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class that manages tasks.
 * This class acts as the business logic layer, handling the
 * creation, retrieval,
 * updating, and deletion of tasks in memory.
 */

@Service // Marks this class as a Spring service, allowing  dependency injection.
public class LoanBankService {

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
    public LoanBankService() {
//        noteList.add(new User(nextId++, "Buy Ham",
//                "No ham"));
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
                .filter(user -> user.getId().equals(id)) // Filter tasks by ID
                .findFirst() // Return the first match (if any)
                .orElse(null); // Return null if no task is found
    }

    /**
     * Creates a new task and adds it to the list.
     *
     * @param User The task object provided in the request.
     * @return The newly created task with an assigned ID.
     */

    public User createUser(User user) {
        user.setId(nextId++); // Assign a unique ID to the new task
        userList.add(user); // Add the task to the in-memory list
        return user; // Return the created task
    }
//
//    public Note updateNote(Note note) {
//        Note aux = getNoteById(note.getId()); // Assign a unique ID to the new task
//        aux.setTitle(note.getTitle());
//        aux.setContent(note.getContent());
//        return note; // Return the created task
//    }
//
//
//    /**
//     * Marks an existing note as completed.
//     *
//     * @param id The ID of the task to update.
//     * @return The updated task if found, otherwise null.
//     */
//    public Note update(Long id) {
//        Optional<Note> updateNote = noteList.stream() // Stream through tasks
//                .filter(note -> note.getId().equals(id)) // Filter tasks by ID
//                .findFirst(); // Find the first matching task
//
//        if (updateNote.isPresent()) { // If task is found
//            Note note = updateNote.get(); // Retrieve the task
//            note.setTitle(note.getTitle()); // Update task status to completed
//            note.setContent(note.getContent()); // Update task status to completed
//            return note; // Return the updated task
//        }
//
//        return null; // Return null if the task was not found
//    }
//
//    /**
//     * Deletes a note by its ID.
//     *
//     * @param id The ID of the note to delete.
//     */
//    public void deleteNote(Long id) {
//        noteList.removeIf(note -> note.getId().equals(id)); // Remove task if ID matches
//    }
}