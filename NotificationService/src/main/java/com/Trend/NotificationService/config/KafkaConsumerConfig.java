package com.Trend.NotificationService.config;

import com.Trend.NotificationService.event.PriceDownNotificationEvent;
import com.Trend.NotificationService.event.StockCountLessThanThreeEvent;
import com.Trend.NotificationService.event.StockCountZeroEvent;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class KafkaConsumerConfig {
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG,
                "groupId");
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    public ConsumerFactory<String, PriceDownNotificationEvent> consumerFactoryPriceDownNotificationEvent() {
        JsonDeserializer<PriceDownNotificationEvent> jsonDeserializer = new JsonDeserializer<>(PriceDownNotificationEvent.class);
        jsonDeserializer.setRemoveTypeHeaders(false);
        jsonDeserializer.addTrustedPackages("*");
        jsonDeserializer.setUseTypeMapperForKey(true);

        Map<String, Object> props = new HashMap<>();
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG,
                "groupId");
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), jsonDeserializer);

    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PriceDownNotificationEvent> kafkaListenerContainerFactoryPriceDownNotificationEvent() {
        ConcurrentKafkaListenerContainerFactory<String, PriceDownNotificationEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryPriceDownNotificationEvent());
        return factory;
    }

    public ConsumerFactory<String, StockCountLessThanThreeEvent> consumerFactoryStockCountLessThanThreeEvent() {
        JsonDeserializer<StockCountLessThanThreeEvent> jsonDeserializer = new JsonDeserializer<>(StockCountLessThanThreeEvent.class);
        jsonDeserializer.setRemoveTypeHeaders(false);
        jsonDeserializer.addTrustedPackages("*");
        jsonDeserializer.setUseTypeMapperForKey(true);

        Map<String, Object> props = new HashMap<>();
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG,
                "groupId");
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), jsonDeserializer);

    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, StockCountLessThanThreeEvent> kafkaListenerContainerFactoryStockCountLessThanThreeEvent() {
        ConcurrentKafkaListenerContainerFactory<String, StockCountLessThanThreeEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryStockCountLessThanThreeEvent());
        return factory;
    }

    public ConsumerFactory<String, StockCountZeroEvent> consumerFactoryStockCountZeroEvent() {
        JsonDeserializer<StockCountZeroEvent> jsonDeserializer = new JsonDeserializer<>(StockCountZeroEvent.class);
        jsonDeserializer.setRemoveTypeHeaders(false);
        jsonDeserializer.addTrustedPackages("*");
        jsonDeserializer.setUseTypeMapperForKey(true);

        Map<String, Object> props = new HashMap<>();
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG,
                "groupId");
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), jsonDeserializer);

    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, StockCountZeroEvent> kafkaListenerContainerFactoryStockCountZeroEvent() {
        ConcurrentKafkaListenerContainerFactory<String, StockCountZeroEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryStockCountZeroEvent());
        return factory;
    }
}
