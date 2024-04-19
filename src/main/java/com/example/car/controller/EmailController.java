package com.example.car.controller;

import com.example.car.service.EmailService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {
    private final EmailService service;

    @PostMapping("/send")
    public String sendEmail() {
        return service.sendEmail();
    }

    @PostMapping("/picture")
    public void sendPicture() {
        service.sendPicture();
    }

    @PostMapping(path = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void sendWithPath(@Parameter(description = "File to upload")
                             @RequestParam(value = "file", required = true)
                             @Schema(type = "object", format = "binary")
                             MultipartFile file) throws MessagingException {
        service.sendWithPath(file);
    }

    @PostMapping(path = "/multiple", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void sendWithPath(@Parameter(description = "File to upload")
                             @RequestParam(value = "file", required = true)
                             List<MultipartFile> file) throws MessagingException {

        service.sendMultiple(file);
    }
}
