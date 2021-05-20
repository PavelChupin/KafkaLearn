package com.gmail.pavelchupin.kafka_learn.listeners;

import com.gmail.pavelchupin.kafka_learn.data.dto.UserDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
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

    //Получения объектов из сообщений kafka
//    @KafkaListener(topics="msg")
//    public void orderListener(ConsumerRecord<Long, UserDto> record){
//        System.out.println(record.partition());
//        System.out.println(record.key());
//        System.out.println(record.value());
//    }

    @KafkaListener(topics="msg", containerFactory = "kafkaListenerContainerFactory")
    public void orderListener(UserDto userDto){
        System.out.println(userDto);
//        System.out.println(record.partition());
//        System.out.println(record.key());
//        System.out.println(record.value());

    }
}
