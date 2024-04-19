package com.example.car.controller;

import com.example.car.dto.request.DocumentsRequestDto;
import com.example.car.dto.response.DocumentsResponseDto;
import com.example.car.service.CarException;
import com.example.car.service.DocumentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/docs")
public class DocumentController {
    private final DocumentsService documentsService;

    @PostMapping("/add-docs")
    public String addDoc(@RequestBody DocumentsRequestDto dto) {
        return documentsService.create(dto);
    }

    @GetMapping("/get-docs")
    public List<DocumentsResponseDto> getDoc() {
        return documentsService.readAll();
    }

    @PutMapping("/update-docs/{id}")
    public String updateDocs(@PathVariable Long id,
                             @RequestBody DocumentsRequestDto dto) throws CarException {
        return documentsService.update(id, dto);
    }

    @DeleteMapping("/delete-doc/{id}")
    public String deleteDoc(@PathVariable Long id) throws CarException {
        return documentsService.delete(id);
    }
}
