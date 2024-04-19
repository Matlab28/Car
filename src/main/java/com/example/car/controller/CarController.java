package com.example.car.controller;

import com.example.car.dto.request.CarRequestDto;
import com.example.car.dto.response.CarResponseDto;
import com.example.car.service.CarException;
import com.example.car.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @PostMapping("/create")
    public String addInfo(@RequestBody CarRequestDto dto) {
        return carService.addGenerally(dto);
    }

    @PutMapping("/find-id/{id}")
    public CarResponseDto findById(@PathVariable Long id) throws CarException {
        return carService.findById(id);
    }

//    @GetMapping("/brand-model")
//    public List<CarDto> findByBrandModel(@RequestParam String brand, String model) {
//        return service.findByBrandModel(brand, model);
//    }

    @GetMapping("/find-word")
    public List<CarResponseDto> findByWord(@RequestParam String letter) {
        return carService.findFirstLetter(letter);
    }

    @GetMapping("/see-all")
    public List<CarResponseDto> seeAll() {
        return carService.seeAll();
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody CarRequestDto dto) throws CarException {
        return carService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) throws CarException {
        return carService.delete(id);
    }
}
