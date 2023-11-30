package com.example.project.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String hostelName;

    private String username;

    // Hidden password (not exposed in public)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    private Wallet wallet;

    // Constructors, getters, and setters

    public User() {
        // Default constructor
    }

    public User(String email, String hostelName, String password) {
        this.email = email;
        this.hostelName = hostelName;
        this.password = password;
        this.username = generateRandomUsername();
        this.wallet = new Wallet();
    }

    private String generateRandomUsername() {
        // Generate a unique random username of the form "user" + some random 5-digit number
        return "user" + String.format("%05d", (int) (Math.random() * 100000));
    }

    public String getEmail() {
        return email;
    }

    public String getHostelName() {
        return hostelName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}


