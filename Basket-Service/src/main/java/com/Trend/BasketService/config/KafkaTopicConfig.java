package com.Trend.BasketService.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;
    @Value(value = "${kafka.topic-delete-product}")
    private String topicDeleteProduct;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic("priceDownNotification", 1, (short) 1);
    }
    @Bean
    public NewTopic topic2() {
        return new NewTopic("StockCountLessThanThree", 1, (short) 1);
    }
    @Bean
    public NewTopic topic3() {
        return new NewTopic("StockCountZero", 1, (short) 1);
    }
    @Bean
    public NewTopic topic4() {
        return new NewTopic("StockCountIncreasedFromZero", 1, (short) 1);
    }
}
