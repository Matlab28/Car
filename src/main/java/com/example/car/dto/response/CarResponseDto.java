package com.example.car.dto.response;

import com.example.car.entity.CustomerEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class CarResponseDto {
    private Long id;

    private String brand, model, color;
    private Boolean used;
    private Integer yearOfCar, numberOfDoors, numberOfUsers, price, odometer;
    private Double motor;
    private CustomerEntity customers;
}
