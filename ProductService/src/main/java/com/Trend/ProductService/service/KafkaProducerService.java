package com.Trend.ProductService.service;

import com.Trend.ProductService.event.PriceChangeEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String msg, String topic){
        kafkaTemplate.send(topic, msg);
    }

    public void sendChangePriceMessage(PriceChangeEvent msg, String topic){
        kafkaTemplate.send(topic, msg);
    }
}
