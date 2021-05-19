package com.gmail.pavelchupin.kafka_learn.data.dto;

import com.gmail.pavelchupin.kafka_learn.data.Address;
import lombok.Data;

@Data
public class UserDto {
    private Long age;
    private String name;
    private Address address;
}
