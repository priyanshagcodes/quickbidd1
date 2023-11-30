package com.example.project.exception;

public class WalletNotFoundException extends RuntimeException {

    public WalletNotFoundException(Long userId) {
        super("Wallet for user with ID " + userId + " not found");
    }
}

