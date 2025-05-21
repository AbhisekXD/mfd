package com.cyfrifpro.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

    @Async
	public void sendEmail(String to, String subject, String body, MultipartFile attachment) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom("helpdesk@cyfrif.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);

			// Add attachment if provided
			if (attachment != null && !attachment.isEmpty()) {
				helper.addAttachment(attachment.getOriginalFilename(), attachment);
			}

			mailSender.send(message);
			System.out.println("Email sent successfully with attachment!");
		} catch (MessagingException e) {
			throw new RuntimeException("Error while sending email", e);
		}
	}
}
