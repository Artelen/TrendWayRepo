package com.Trend.BasketService.service;

import com.Trend.BasketService.event.PriceChangeEvent;
import com.Trend.BasketService.event.StockChangeEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumerService {

    private final CartService cartService;

    public KafkaConsumerService(CartService cartService) {
        this.cartService = cartService;
    }

    @KafkaListener(topics = "changeSalesPrice", groupId = "group-id", containerFactory = "kafkaListenerContainerFactoryPriceChangeEvent")
    public void listenPriceDownEvent(PriceChangeEvent msg)
    {
        System.out.format("listenPriceDownEvent :: PriceDown :: %s\n", msg.toString());
        cartService.sendPriceChangeEvent(msg);
    }

    @KafkaListener(topics = "StockChange", groupId = "group-id", containerFactory = "kafkaListenerContainerFactoryStockChangeEvent")
    public void listenPriceDownEvent(StockChangeEvent msg)
    {
        System.out.format("listenStockChange :: StockChange :: %s\n", msg.toString());
        cartService.sendStockCountChangeEvent(msg);
    }
}
