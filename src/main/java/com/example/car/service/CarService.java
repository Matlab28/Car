package com.example.car.service;

import com.example.car.dto.request.CarRequestDto;
import com.example.car.dto.response.CarResponseDto;
import com.example.car.entity.CarEntity;
import com.example.car.entity.CustomerEntity;
import com.example.car.repository.CarRepository;
import com.example.car.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarService {

    private final ModelMapper modelMapper;
    private final CarRepository repository;
    private final CustomerRepository customerRepository;

    public String addGenerally(CarRequestDto dto) {
        CarEntity carEntity = mapDtoToEntity(dto);

        CustomerEntity customer = customerRepository.findById(dto.getCustomerId()).orElseThrow();
        carEntity.setCustomers(customer);
        log.info("Customer and cars' info created successfully!");


        if (dto.getUsed().equals(true)) {
            carEntity.setNumberOfUsers(0);
            carEntity.setOdometer(0);
        }

//        carEntity.setCustomers(customer);
        repository.save(carEntity);
        log.info("Car's info saved in db!");
        return "All information added successfully!";
    }

    public List<CarResponseDto> seeAll() {
        List<CarEntity> all = repository.findAll();
        log.info("Cars' info responded successfully!");

        return all.stream()
                .map(entity -> modelMapper.map(entity, CarResponseDto.class))
                .collect(Collectors.toList());
    }

    public String update(Long id, CarRequestDto dto) throws CarException {
        CarEntity carEntity = repository.findById(id)
                .orElseThrow(() -> new CarException("Car not found by -" + id));

        CustomerEntity customer = customerRepository.findById(id).orElseThrow();


        modelMapper.map(dto, carEntity);
        repository.save(carEntity);
        return "Car values updated successfully!";
    }

    public CarResponseDto findById(Long id) throws CarException {
        CarEntity carEntity = repository.findById(id)
                .orElseThrow(() -> new CarException("Car not found by - " + id));

        return modelMapper.map(carEntity, CarResponseDto.class);
    }

    public String delete(Long id) throws CarException {
        CarEntity carEntity = repository.findById(id)
                .orElseThrow(() -> new CarException("Car not found by - " + id));

        repository.delete(carEntity);
        return "Car deleted successfully";
    }

//    public List<CarDto> findByBrandModel(String brand, String model) {
//        List<CarEntity> find = repository.findByBrandAndModel(brand, model);
//
//        return find
//                .stream()
//                .map(e -> modelMapper.map(e, CarDto.class))
//                .collect(Collectors.toList());
//    }

    public List<CarResponseDto> findFirstLetter(String letter) {
        List<CarEntity> all = repository.findAll();

        List<CarEntity> collected = all
                .stream()
                .filter(l -> l.getBrand().contains(letter))
                .toList();

        return collected
                .stream()
                .map(m -> modelMapper.map(m, CarResponseDto.class))
                .toList();
    }

    public CarEntity mapDtoToEntity(CarRequestDto dto) {
        return modelMapper.map(dto, CarEntity.class);
    }
}
