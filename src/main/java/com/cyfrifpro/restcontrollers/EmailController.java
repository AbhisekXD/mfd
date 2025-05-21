package com.cyfrifpro.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cyfrifpro.payloads.ApiResponse;
import com.cyfrifpro.services.impl.EmailService;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public ApiResponse sendEmailWithAttachment(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body,
            @RequestParam(required = false) MultipartFile attachment) {
        emailService.sendEmail(to, subject, body, attachment);
        return new ApiResponse(true, "Email sent successfully!");
    }
}
