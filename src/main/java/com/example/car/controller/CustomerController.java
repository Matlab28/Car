package com.example.car.controller;

import com.example.car.dto.request.CustomerRequestDto;
import com.example.car.dto.response.CustomerResponseDto;
import com.example.car.service.CarException;
import com.example.car.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create")
    public String create(@RequestBody CustomerRequestDto dto) {
        return customerService.create(dto);
    }

    @GetMapping("/read")
    public List<CustomerResponseDto> read() {
        return customerService.readAll();
    }

    @PutMapping("/update/{id}")
    public String updating(@PathVariable Long id, @RequestBody CustomerRequestDto dto) throws CarException {
        return customerService.update(id, dto);
    }

    @DeleteMapping("/delete-cust/{id}")
    public String deleting(@PathVariable Long id) throws CarException {
        return customerService.delete(id);
    }

    @GetMapping("/find-by-name/{name}/{email}")
    public CustomerRequestDto finding(@PathVariable String name, @PathVariable String email) throws CarException {
        return customerService.findByName(name, email);
    }
}
