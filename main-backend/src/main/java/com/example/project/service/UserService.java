package com.example.project.service;

import com.example.project.model.User;

import java.util.List;

public interface UserService {

    User registerUser(String email, String hostelName, String password);

    User loginUser(String email, String password);

    User getUserById(Long userId);

    List<User> getAllUsers();
}


