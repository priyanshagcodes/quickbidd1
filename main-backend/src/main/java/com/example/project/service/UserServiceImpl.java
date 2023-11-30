package com.example.project.service;

import com.example.project.model.User;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(String email, String hostelName, String password) {
        // Validate email format
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        // Check if the email is already registered
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email is already registered");
        }

        // Create and save the user with plain text password
        User user = new User(email, hostelName, password);
        userRepository.save(user);

        return user;
    }

    @Override
    public User loginUser(String email, String password) {
        // Retrieve the user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Check if the provided password matches the stored password
        if (!password.equals(user.getPassword())) {
            throw new IllegalArgumentException("Incorrect password");
        }

        return user;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private boolean isValidEmail(String email) {
        return email.matches("f202[0-3]\\d{4}@hyderabad.bits-pilani.ac.in");
    }
}
