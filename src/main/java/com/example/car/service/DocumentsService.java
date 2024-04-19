package com.example.car.service;

import com.example.car.dto.request.DocumentsRequestDto;
import com.example.car.dto.response.DocumentsResponseDto;
import com.example.car.entity.DocumentsEntity;
import com.example.car.repository.DocumentsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentsService {
    private final ModelMapper modelMapper;
    private final DocumentsRepository repository;

    public String create(DocumentsRequestDto dto) {
        DocumentsEntity documentsEntity = mapReqDtoToEntity(dto);

        if (dto.getCarNo().length() != 7) {
            return "Invalid car license plate number...";
        }

        repository.save(documentsEntity);
        return "Inputs saved successfully";
    }

    public List<DocumentsResponseDto> readAll() {
        List<DocumentsEntity> all = repository.findAll();

        return all
                .stream()
                .map(m -> modelMapper.map(m, DocumentsResponseDto.class))
                .collect(Collectors.toList());
    }

    public String update(Long id, DocumentsRequestDto dto) throws CarException {
        DocumentsEntity entity = repository
                .findById(id).orElseThrow(() -> new CarException("Document not found by - " + id));

        modelMapper.map(dto, entity);
        repository.save(entity);
        return "Updated successfully!";
    }

    public String delete(Long id) throws CarException {
        DocumentsEntity documents = repository
                .findById(id).orElseThrow(() -> new CarException("Document not found by - " + id));

        repository.delete(documents);
        return "Deleted successfully!";
    }

    public DocumentsRequestDto mapDtoReqToEntity(DocumentsEntity entity) {
        return modelMapper.map(entity, DocumentsRequestDto.class);
    }

    public DocumentsResponseDto mapDtoToEntity(DocumentsEntity entity) {
        return modelMapper.map(entity, DocumentsResponseDto.class);
    }

    public DocumentsEntity mapReqDtoToEntity(DocumentsRequestDto dto) {
        return modelMapper.map(dto, DocumentsEntity.class);
    }

}
