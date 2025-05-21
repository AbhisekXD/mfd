//package com.cyfrifpro.config;
//
//import java.util.Properties;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
//
//import jakarta.mail.Authenticator;
//import jakarta.mail.PasswordAuthentication;
//import jakarta.mail.Session;
//
//@Configuration
//public class MailConfig {
//	
//
//    @Autowired
//    private OAuth2AuthorizedClientManager authorizedClientManager;
//
//    @Bean
//    public JavaMailSender javaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//        mailSender.setUsername("cyfrifprotech.abhisek@gmail.com"); // Replace with your Gmail account
//
//        Properties properties = mailSender.getJavaMailProperties();
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//        properties.put("mail.smtp.auth.mechanisms", "XOAUTH2");
//
//        // Retrieve the OAuth2 token
//        String oauthToken = getOAuth2Token();
//
//        // Set a custom authenticator
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(mailSender.getUsername(), oauthToken);
//            }
//        });
//        mailSender.setSession(session);
//
//        return mailSender;
//    }
//
//    private String getOAuth2Token() {
//        OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId("google")
//                .principal("user") // Use your actual user or principal
//                .build();
//
//        OAuth2AuthorizedClient authorizedClient = authorizedClientManager.authorize(authorizeRequest);
//
//        if (authorizedClient != null && authorizedClient.getAccessToken() != null) {
//            return authorizedClient.getAccessToken().getTokenValue();
//        } else {
//            throw new IllegalStateException("OAuth2 token retrieval failed");
//        }
//    }
//
//}
