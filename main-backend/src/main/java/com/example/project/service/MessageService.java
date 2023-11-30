package com.example.project.service;

import com.example.project.model.Message;
import com.example.project.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public List<Message> getMessagesBySender(String sender) {
        return messageRepository.findBySender(sender);
    }

    public List<Message> getMessagesByRecipient(String recipient) {
        return messageRepository.findByRecipient(recipient);
    }

    public List<Message> getMessagesBetweenUsers(String user1, String user2) {
        return messageRepository.findBySenderAndRecipientOrSenderAndRecipientOrderByTimestamp(
                user1, user2, user2, user1);
    }

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}

