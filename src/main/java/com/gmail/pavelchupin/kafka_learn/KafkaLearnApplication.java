package com.gmail.pavelchupin.kafka_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;


@SpringBootApplication
public class KafkaLearnApplication {
	public static void main(String[] args) {
		SpringApplication.run(KafkaLearnApplication.class, args);
	}
}
