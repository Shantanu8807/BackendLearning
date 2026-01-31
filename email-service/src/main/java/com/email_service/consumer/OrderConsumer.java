package com.email_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "orders", groupId = "email-group")
    public void consume(String message) {
        System.out.println("📩 Email Service received order: " + message);
    }
}
