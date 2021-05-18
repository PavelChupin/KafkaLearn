package com.gmail.pavelchupin.kafka_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;


@SpringBootApplication
public class KafkaLearnApplication {
	/*@KafkaListener(topics="msg")
	public void msgListener(String msg){
		System.out.println("Test");
		System.out.println(msg);
	}*/
	public static void main(String[] args) {
		SpringApplication.run(KafkaLearnApplication.class, args);
	}

}
