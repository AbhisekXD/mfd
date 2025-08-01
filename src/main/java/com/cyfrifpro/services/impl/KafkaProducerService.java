//package com.cyfrifpro.services.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafkaProducerService {
//
//    private static final String TOPIC = "mfd_demo_topic";
//
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    public void sendMessage(String message) {
//        kafkaTemplate.send(TOPIC, message);
//        System.out.println("Message sent: " + message);
//    }
//}
