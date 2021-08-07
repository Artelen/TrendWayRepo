package com.Trend.ProductService.service;

import com.Trend.ProductService.event.PriceChangeEvent;
import com.Trend.ProductService.event.StockChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplateString;
    private final KafkaTemplate<String, PriceChangeEvent> kafkaTemplatePriceChange;
    private final KafkaTemplate<String, StockChangeEvent> kafkaTemplateStockChange;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, KafkaTemplate<String, PriceChangeEvent> kafkaTemplatePriceChange, KafkaTemplate<String, StockChangeEvent> kafkaTemplateStockChange) {
        this.kafkaTemplateString = kafkaTemplate;
        this.kafkaTemplatePriceChange = kafkaTemplatePriceChange;
        this.kafkaTemplateStockChange = kafkaTemplateStockChange;
    }

    public void sendMessage(String msg, String topic)
    {
        kafkaTemplateString.send(topic, msg);
    }

    public void sendChangePriceMessage(PriceChangeEvent msg, String topic)
    {
        kafkaTemplatePriceChange.send(topic, msg);
    }

    public void sendStockChangeEvent(StockChangeEvent msg, String topic)
    {
        kafkaTemplateStockChange.send(topic,msg);
    }
}
