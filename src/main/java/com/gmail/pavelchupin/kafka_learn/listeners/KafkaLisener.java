package com.gmail.pavelchupin.kafka_learn.listeners;

import com.gmail.pavelchupin.kafka_learn.data.dto.UserDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.LoggingErrorHandler;
import org.springframework.stereotype.Component;

@EnableKafka
@Component
public class KafkaLisener {
    // Получение простого строкового сообщения из Кафки
//    @KafkaListener(topics="msg")
//    public void msgListener(String msg){
//        System.out.println("Test");
//        System.out.println(msg);
//    }

//    //Получения объектов из сообщений kafka
    @KafkaListener(topics="msg", containerFactory = "kafkaListenerContainerFactory", groupId = "app.1")
    public void orderListener(ConsumerRecord<Long, UserDto> record){
        System.out.println(record.partition());
        System.out.println(record.key());
        System.out.println(record.value());
    }

    @Bean
    public LoggingErrorHandler errorHandler () {
        return new LoggingErrorHandler ();
    }

//    @KafkaListener(topics="msg", containerFactory = "kafkaListenerContainerFactory", groupId = "app.1")
//    public void orderListener(UserDto userDto){
//        System.out.println(userDto);
//    }
}
