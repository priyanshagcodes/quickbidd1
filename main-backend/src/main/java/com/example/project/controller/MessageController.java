package com.example.project.controller;

import com.example.project.model.Message;
import com.example.project.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> allMessages = messageService.getAllMessages();
        return new ResponseEntity<>(allMessages, HttpStatus.OK);
    }

    @GetMapping("/by-sender/{sender}")
    public ResponseEntity<List<Message>> getMessagesBySender(@PathVariable String sender) {
        List<Message> messagesBySender = messageService.getMessagesBySender(sender);
        return new ResponseEntity<>(messagesBySender, HttpStatus.OK);
    }

    @GetMapping("/by-recipient/{recipient}")
    public ResponseEntity<List<Message>> getMessagesByRecipient(@PathVariable String recipient) {
        List<Message> messagesByRecipient = messageService.getMessagesByRecipient(recipient);
        return new ResponseEntity<>(messagesByRecipient, HttpStatus.OK);
    }

    @GetMapping("/between-users/{user1}/{user2}")
    public ResponseEntity<List<Message>> getMessagesBetweenUsers(
            @PathVariable String user1, @PathVariable String user2) {
        List<Message> messagesBetweenUsers = messageService.getMessagesBetweenUsers(user1, user2);
        return new ResponseEntity<>(messagesBetweenUsers, HttpStatus.OK);
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        try {
            message.setTimestamp(LocalDateTime.now());
            messageService.saveMessage(message);
            return new ResponseEntity<>("Message sent successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to send message", HttpStatus.BAD_REQUEST);
        }
    }
}

