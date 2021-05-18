package com.gmail.pavelchupin.kafka_learn.listeners;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@EnableKafka
@Component
public class KafkaLisener {

    @KafkaListener(topics="msg")
    public void msgListener(String msg){
        System.out.println("Test");
        System.out.println(msg);
    }
}
