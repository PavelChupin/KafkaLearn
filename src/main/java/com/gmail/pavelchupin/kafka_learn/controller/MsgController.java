package com.gmail.pavelchupin.kafka_learn.controller;

import com.gmail.pavelchupin.kafka_learn.data.ResponseResult;
import com.gmail.pavelchupin.kafka_learn.data.dto.RequestDto;
import com.gmail.pavelchupin.kafka_learn.data.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/msg")
public class MsgController {

    @Autowired
    private KafkaTemplate<Long, UserDto> kafkaTemplate;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity sendOrder(/*@RequestHeader Long msgId,*/ @RequestBody RequestDto req) {
        //System.out.println("key = " + msgId + ", messageText = " + msg);
        //Address a = Address.builder().city("").country("").build();
        Long msgId = req.getKey();
        UserDto msg = req.getValue();
        ListenableFuture<SendResult<Long, UserDto>> future = kafkaTemplate.send("msg", msgId, msg);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseResult("OK"));
    }
}

