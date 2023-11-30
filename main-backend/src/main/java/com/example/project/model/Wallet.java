package com.example.project.model;

import com.example.project.model.User;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column(name = "bidcoin_balance", precision = 10, scale = 2) // Example precision and scale, adjust as needed
    private BigDecimal bidcoinBalance;

    // Constructors, getters, and setters

    public Wallet() {
        // Default constructor
    }

    public Wallet(User user, BigDecimal bidcoinBalance) {
        this.user = user;
        this.bidcoinBalance = bidcoinBalance;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getBidcoinBalance() {
        return bidcoinBalance;
    }

    public void setBidcoinBalance(BigDecimal bidcoinBalance) {
        this.bidcoinBalance = bidcoinBalance;
    }
}

