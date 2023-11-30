package com.example.project.exception;

public class InsufficientBidcoinsException extends RuntimeException {

    public InsufficientBidcoinsException(String message) {
        super(message);
    }

    public InsufficientBidcoinsException(String message, Throwable cause) {
        super(message, cause);
    }
}

