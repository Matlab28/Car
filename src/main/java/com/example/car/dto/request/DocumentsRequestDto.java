package com.example.car.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class DocumentsRequestDto {
    private String licNo, carNo, owner;
}
