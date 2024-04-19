package com.example.car.controller;

import com.example.car.dto.request.PetrolStationsRequestDto;
import com.example.car.dto.response.PetrolStationsResponseDto;
import com.example.car.service.CarException;
import com.example.car.service.PetrolStationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/petrol")
public class PetrolStationsController {
    private final PetrolStationsService service;

    @PostMapping("/create")
    public String create(@RequestBody PetrolStationsRequestDto dto) {
        return service.creation(dto);
    }

    @GetMapping("/read")
    public List<PetrolStationsResponseDto> read() {
        return service.getAll();
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody PetrolStationsRequestDto dto) throws CarException {
        return service.updating(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) throws CarException {
        return service.delete(id);
    }

    @GetMapping("/min-price")
    public List<PetrolStationsResponseDto> findByMinPrice(@RequestParam Double minPrice) throws CarException {
        return service.findByMinPrice(minPrice);
    }
}
