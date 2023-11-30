package com.example.project.repository;

import com.example.project.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySender(String sender);

    List<Message> findByRecipient(String recipient);

    List<Message> findBySenderAndRecipientOrSenderAndRecipientOrderByTimestamp(
            String sender1, String recipient1, String sender2, String recipient2);
}

