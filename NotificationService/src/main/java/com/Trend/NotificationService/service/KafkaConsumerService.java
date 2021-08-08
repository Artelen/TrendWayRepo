package com.Trend.NotificationService.service;

import com.Trend.NotificationService.event.PriceDownNotificationEvent;
import com.Trend.NotificationService.event.StockCountIncreasedFromZeroEvent;
import com.Trend.NotificationService.event.StockCountLessThanThreeEvent;
import com.Trend.NotificationService.event.StockCountZeroEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {

    private final EmailServiceImpl emailService;

    public KafkaConsumerService(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "${kafka.topic}")
    public void listen(Object msg) {
        System.out.println(msg);
    }

    @KafkaListener(topics = "priceDownNotification", groupId = "group-id", containerFactory = "kafkaListenerContainerFactoryPriceDownNotificationEvent")
    public void listenSendEmailNotification(PriceDownNotificationEvent msg)
    {
        System.out.format("sendEmailNotification :: PriceDown :: %s\n", msg.toString());
        emailService.sendSimpleMessage(msg.eMail,"Sepetteki ürün hk.",
                String.format("Merhaba %s \n Sepetinizdeki %s adlı ürün %s fiyatından %s fiyatına düşmüştür",
                        msg.getFullName(),
                        msg.getProductName(),
                        msg.getOldPrice(),
                        msg.getNewPrice()));
    }


    @KafkaListener(topics = "StockCountLessThanThree", groupId = "group-id", containerFactory = "kafkaListenerContainerFactoryStockCountLessThanThreeEvent")
    public void listenSendEmailNotification(StockCountLessThanThreeEvent msg)
    {
        System.out.format("sendEmailNotification :: StockCountLessThanThree ::  %s\n", msg.toString());
        emailService.sendSimpleMessage(msg.eMail,"Sepetteki ürün hk.",
                String.format("Merhaba %s \n Sepetinizdeki %s adlı ürünün stoğu bitmek üzere...",
                        msg.getFullName(),
                        msg.getProductName()));

    }

    @KafkaListener(topics = "StockCountZero", groupId = "group-id", containerFactory = "kafkaListenerContainerFactoryStockCountZeroEvent")
    public void listenSendEmailNotification(StockCountZeroEvent msg)
    {
        System.out.format("sendEmailNotification :: StockCountZero ::  %s\n", msg.toString());
        emailService.sendSimpleMessage(msg.eMail,"Sepetteki ürün hk.",
                String.format("Merhaba %s \n Sepetinizdeki %s adlı ürünün stoğu bitti...",
                        msg.getFullName(),
                        msg.getProductName()));
    }

    @KafkaListener(topics = "StockCountIncreasedFromZero", groupId = "group-id", containerFactory = "kafkaListenerContainerFactoryStockCountIncreasedFromZeroEvent")
    public void listenSendEmailNotification(StockCountIncreasedFromZeroEvent msg)
    {
        System.out.format("sendEmailNotification :: StockCountIncreasedFromZero ::  %s\n", msg.toString());
        System.out.format("sendEmailNotification :: StockCountZero ::  %s\n", msg.toString());
        emailService.sendSimpleMessage(msg.eMail,"Sepetteki ürün hk.",
                String.format("Merhaba %s \n Sepetinizdeki %s adlı ürün tekrardan stoklarımızda!",
                        msg.getFullName(),
                        msg.getProductName()));
    }
}
