package com.example.project.exception;

public class BidNotFoundException extends RuntimeException {

    public BidNotFoundException(Long bidId) {
        super("Bid with ID " + bidId + " not found");
    }
}

