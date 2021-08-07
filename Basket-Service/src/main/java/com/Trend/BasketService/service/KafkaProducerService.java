package com.Trend.BasketService.service;

import com.Trend.BasketService.event.PriceDownNotificationEvent;
import com.Trend.BasketService.event.StockCountIncreasedFromZeroEvent;
import com.Trend.BasketService.event.StockCountLessThanThreeEvent;
import com.Trend.BasketService.event.StockCountZeroEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplateString;
    private final KafkaTemplate<String,PriceDownNotificationEvent> kafkaTemplatePriceDownNotification;
    private final KafkaTemplate<String,StockCountZeroEvent> kafkaTemplateStockCountZero;
    private final KafkaTemplate<String,StockCountLessThanThreeEvent> kafkaTemplateStockCountLessThanThree;
    private final KafkaTemplate<String, StockCountIncreasedFromZeroEvent> kafkaTemplateStockCountIncreasedFromZero;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, KafkaTemplate<String, PriceDownNotificationEvent> kafkaTemplatePriceDownNotification, KafkaTemplate<String, StockCountZeroEvent> kafkaTemplateStockCountZero, KafkaTemplate<String, StockCountLessThanThreeEvent> kafkaTemplateStockCountLessThanThree, KafkaTemplate<String, StockCountIncreasedFromZeroEvent> kafkaTemplateStockCountIncreasedFromZero) {
        this.kafkaTemplateString = kafkaTemplate;
        this.kafkaTemplatePriceDownNotification = kafkaTemplatePriceDownNotification;
        this.kafkaTemplateStockCountZero = kafkaTemplateStockCountZero;
        this.kafkaTemplateStockCountLessThanThree = kafkaTemplateStockCountLessThanThree;
        this.kafkaTemplateStockCountIncreasedFromZero = kafkaTemplateStockCountIncreasedFromZero;
    }

    public void sendMessage(String msg, String topic)
    {
        kafkaTemplateString.send(topic, msg);
    }

    public void sendPriceDownNotificationEvent(PriceDownNotificationEvent msg)
    {
        kafkaTemplatePriceDownNotification.send("priceDownNotification", msg);
    }

    public void sendStockCountZeroEvent(StockCountZeroEvent msg)
    {
        kafkaTemplateStockCountZero.send("StockCountZero",msg);
    }

    public void sendStockCountLessThanThreeEvent(StockCountLessThanThreeEvent msg)
    {
        kafkaTemplateStockCountLessThanThree.send("StockCountLessThanThree",msg);
    }

    public void sendStockCountIncreasedFromZeroEvent(StockCountIncreasedFromZeroEvent msg)
    {
        kafkaTemplateStockCountIncreasedFromZero.send("StockCountIncreasedFromZero",msg);
    }

}
