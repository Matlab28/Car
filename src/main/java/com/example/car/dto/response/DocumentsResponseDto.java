package com.example.car.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class DocumentsResponseDto {
    private Long id;
    private String licNo, carNo, owner;
}
