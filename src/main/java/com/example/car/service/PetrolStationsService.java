package com.example.car.service;

import com.example.car.dto.request.PetrolStationsRequestDto;
import com.example.car.dto.response.PetrolStationsResponseDto;
import com.example.car.entity.PetrolStationsEntity;
import com.example.car.repository.PetrolStationsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetrolStationsService {
    private final ModelMapper modelMapper;
    private final PetrolStationsRepository repository;

    public String creation(PetrolStationsRequestDto dto) {
        PetrolStationsEntity entity = mapDtoToEntity(dto);
        repository.save(entity);
        return "Values added successfully!";
    }

    public List<PetrolStationsResponseDto> getAll() {
        List<PetrolStationsEntity> all = repository.findAll();

        return all
                .stream()
                .map(e -> modelMapper.map(e, PetrolStationsResponseDto.class))
                .collect(Collectors.toList());
    }

    public String updating(Long id, PetrolStationsRequestDto dto) throws CarException {
        PetrolStationsEntity entity = repository.findById(id)
                .orElseThrow(() -> new CarException("Car not found by - " + id));

        modelMapper.map(dto, PetrolStationsRequestDto.class);
        repository.save(entity);
        return id + " updated successfully!";
    }

    public String delete(Long id) throws CarException {
        PetrolStationsEntity entity = repository.findById(id)
                .orElseThrow(() -> new CarException("Petrol station not found by - " + id));

        repository.delete(entity);
        return "Deleted successfully!";
    }

    public List<PetrolStationsResponseDto> findByMinPrice(Double minPrice) throws CarException {
        List<PetrolStationsEntity> list = repository.findByMinPrice(minPrice)
                .orElseThrow(() -> new CarException("Petrol station not found by - " + minPrice));

        return list
                .stream()
                .map(m -> modelMapper.map(m, PetrolStationsResponseDto.class))
                .collect(Collectors.toList());
    }

    public PetrolStationsRequestDto mapEntityToDto(PetrolStationsEntity entity) {
        return modelMapper.map(entity, PetrolStationsRequestDto.class);
    }

    public PetrolStationsEntity mapDtoToEntity(PetrolStationsRequestDto dto) {
        return modelMapper.map(dto, PetrolStationsEntity.class);
    }
}
