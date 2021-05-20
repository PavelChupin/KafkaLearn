package com.gmail.pavelchupin.kafka_learn.config;


import com.gmail.pavelchupin.kafka_learn.data.dto.UserDto;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServer;

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> producerProps = new HashMap<>();
        //Set settings for kafka of address server
        producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                kafkaServer);
        //Set type serialize for key of message
        producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                LongSerializer.class);
        //Set type serialize for message send
        //props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        //producerProps.put(JsonSerializer.TYPE_MAPPINGS, "userDto:com.gmail.pavelchupin.kafka_learn.data.dto");
        //props.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
        //props.put(JsonSerializer.TYPE_MAPPINGS, "userDto:com.gmail.pavelchupin.kafka_learn.data.dto.UserDto");
        return producerProps;
    }

    @Bean
    public ProducerFactory<Long, UserDto> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<Long, UserDto> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
