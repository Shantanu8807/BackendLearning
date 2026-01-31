package com.order_service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "orders";

    public void sendOrder(String order) {
        kafkaTemplate.send(TOPIC, order);
        System.out.println("📤 Order sent to Kafka: " + order);
    }
}
