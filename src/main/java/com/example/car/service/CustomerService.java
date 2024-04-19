package com.example.car.service;

import com.example.car.dto.request.CustomerRequestDto;
import com.example.car.dto.response.CustomerResponseDto;
import com.example.car.entity.CustomerEntity;
import com.example.car.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper modelMapper;

    public String create(CustomerRequestDto dto) {
        CustomerEntity customer = mapDtoToEntity(dto);
        String emailRegex = "^[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*@gmail\\.com$";
        String alphabeticRegex = "[a-zA-Z]+";
        String numbers = ".*\\d+.*";

        if (!dto.getEmail().matches(emailRegex)) {
            return "Invalid email address...";
        }
        if (!dto.getName().matches(alphabeticRegex)) {
            return "Invalid name input...";
        }
        if (!dto.getNumber().matches(numbers) && dto.getNumber().matches(alphabeticRegex)) {
            return "Invalid number...";
        }

        repository.save(customer);
        return "Thank you " + dto.getName() + ", for registration!";
    }

    public String update(Long id, CustomerRequestDto dto) throws CarException {
        CustomerEntity customer = repository.findById(id)
                .orElseThrow(() -> new CarException("Customer not found with: " + id));

        modelMapper.map(dto, customer);
        repository.save(customer);
        return "Customer updated successfully!";
    }

    public List<CustomerResponseDto> readAll() {
        List<CustomerEntity> all = repository.findAll();

        return all
                .stream()
                .map(e -> modelMapper.map(e, CustomerResponseDto.class))
                .collect(Collectors.toList());
    }

    public String delete(Long id) throws CarException {
        CustomerEntity customer = repository.findById(id)
                .orElseThrow(() -> new CarException("Customer not found by - " + id));

        repository.delete(customer);
        return "Customer deleted successfully!";
    }

    public CustomerRequestDto findByName(String name, String email) throws CarException {
        CustomerEntity customer = repository.findByNameOrEmail(name, email)
                .orElseThrow(() -> new CarException("Car not found by - " + name));
        return mapEntityToDto(customer);
    }

    public CustomerRequestDto mapEntityToDto(CustomerEntity entity) {
        return modelMapper.map(entity, CustomerRequestDto.class);
    }

    public CustomerEntity mapDtoToEntity(CustomerRequestDto dto) {
        return modelMapper.map(dto, CustomerEntity.class);
    }
}
