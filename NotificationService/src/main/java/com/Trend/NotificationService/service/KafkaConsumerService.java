package com.Trend.NotificationService.service;

import com.Trend.NotificationService.event.PriceDownNotificationEvent;
import com.Trend.NotificationService.event.StockCountLessThanThreeEvent;
import com.Trend.NotificationService.event.StockCountZeroEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {

    @KafkaListener(topics = "${kafka.topic}")
    public void listen(Object msg) {
        System.out.println(msg);
    }
    @KafkaListener(topics = "priceDownNotification", groupId = "group-id", containerFactory = "kafkaListenerContainerFactoryPriceDownNotificationEvent")
    public void listenSendEmailNotification(PriceDownNotificationEvent msg)
    {
        System.out.format("sendEmailNotification :: PriceDown :: %s\n", msg.toString());
    }


    @KafkaListener(topics = "StockCountLessThanThree", groupId = "group-id", containerFactory = "kafkaListenerContainerFactoryStockCountLessThanThreeEvent")
    public void listenSendEmailNotification(StockCountLessThanThreeEvent msg)
    {
        System.out.format("sendEmailNotification :: StockCountLessThanThree ::  %s\n", msg.toString());
    }

    @KafkaListener(topics = "StockCountLessThanThree", groupId = "group-id", containerFactory = "kafkaListenerContainerFactoryStockCountZeroEvent")
    public void listenSendEmailNotification(StockCountZeroEvent msg)
    {
        System.out.format("sendEmailNotification :: StockCountZero ::  %s\n", msg.toString());
    }
}
