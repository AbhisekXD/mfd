//package com.cyfrifpro.restcontrollers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cyfrifpro.services.impl.KafkaProducerService;
//
//@RestController
//public class KafkaController {
//
//    @Autowired
//    private KafkaProducerService producerService;
//
//    @GetMapping("/send")
//    public String sendMessage(@RequestParam("message") String message) {
//        producerService.sendMessage(message);
//        return "Message sent: " + message;
//    }
//}
