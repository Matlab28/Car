package com.example.car.dto.response;

import com.example.car.entity.CarEntity;
import com.example.car.entity.CustomerEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CustomerResponseDto {
    private Long id;

    private String name, email, number;
}
