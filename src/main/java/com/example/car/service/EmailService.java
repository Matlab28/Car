package com.example.car.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;

    public String sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        String text = "Hi, I hope you have a good time! Thank you for receiving this message!";
        String subject = "Greetings!";

        message.setFrom("matlab.abbaszada@gmail.com");
        message.setTo("metleb.abbaszade@gmail.com");
        message.setText(text);
        message.setSubject(subject);
        javaMailSender.send(message);
        log.info("Message sent.");
        return "Sent successfully!";
    }

    public void sendPicture() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            String text = "Check this";

            messageHelper.setFrom("matlab.abbaszada@gmail.com");
            messageHelper.setTo("metleb.abbaszade@gmail.com");
            messageHelper.setSubject("Gemini");
            messageHelper.setText(text);

            String filePath = "/Users/matlab/Downloads/Gemini_Generated_Image-3.jpg";
            File file = new File(filePath);

            if (file.exists()) {
                messageHelper.addAttachment(file.getName(), file);
                javaMailSender.send(message);
                log.info("Picture sent.");
            } else {
                log.error("File does not exist at the specified path: {}", filePath);
            }
        } catch (MessagingException e) {
            log.error("Error occurred while sending email: {}", e.getMessage());
        }
    }

    public void sendWithPath(MultipartFile multipart) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        String text = "Hello!";

        messageHelper.setFrom("matlab.abbaszada@gmail.com");
        messageHelper.setTo("metleb.abbaszade@gmail.com");
        messageHelper.setSubject("New Picture");
        messageHelper.setText(text);

        String fileName = multipart.getOriginalFilename();
        messageHelper.addAttachment(fileName, multipart);
        javaMailSender.send(message);
    }

    public void sendMultiple(List<MultipartFile> multipart) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

        for (MultipartFile item : multipart) {
            String text = "Check";

            messageHelper.setFrom("matlab.abbaszada@gmail.com");
            messageHelper.setTo("metleb.abbaszade@gmail.com");
            messageHelper.setSubject("New Picture");
            messageHelper.setText(text);

            String fileName = item.getOriginalFilename();
            messageHelper.addAttachment(fileName, item);
        }

        javaMailSender.send(message);
    }
}
