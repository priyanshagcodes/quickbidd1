package com.example.project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bids")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private String bidder;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private LocalDateTime bidTime;

    // Constructors, getters, and setters...

    public Bid() {
        // Required by JPA
    }

    public Bid(Product product, String bidder, double amount, LocalDateTime bidTime) {
        this.product = product;
        this.bidder = bidder;
        this.amount = amount;
        this.bidTime = bidTime;
    }

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getBidder() {
        return bidder;
    }

    public void setBidder(String bidder) {
        this.bidder = bidder;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }
}
