package com.gmail.pavelchupin.kafka_learn.data.dto;

import com.gmail.pavelchupin.kafka_learn.data.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long age;
    private String name;
    private Address address;
}
