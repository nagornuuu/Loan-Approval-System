package com.example.Loan.Approval.System.Repository;

import com.example.Loan.Approval.System.Models.User;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    private long nextId = 1;

    public User save(User user) {
        user = new User(nextId++, user.getName(), user.getCreditScore(), user.getMonthlyIncome(), user.hasUnpaidLoans());
        users.put(user.getId(), user);
        return user;
    }

    public User findById(long userId) {
        return users.get(userId);
    }

    public List<User> findAll() {
        return users.values().stream().collect(Collectors.toList());
    }
}
