package com.example.car.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class CarRequestDto {
    private String brand, model, color;
    private Boolean used;
    private Integer yearOfCar, numberOfDoors, numberOfUsers, price, odometer;
    private Double motor;
    private Long customerId;
}
