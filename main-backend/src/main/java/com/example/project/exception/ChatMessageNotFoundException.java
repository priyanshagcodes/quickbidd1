package com.example.project.exception;

public class ChatMessageNotFoundException extends RuntimeException {

    public ChatMessageNotFoundException(Long messageId) {
        super("Chat message with ID " + messageId + " not found");
    }
}

