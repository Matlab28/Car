package com.example.car.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class PetrolStationsResponseDto {
    private Long id;

    private String location, typesOfPetrol;
    private Double price;
}
