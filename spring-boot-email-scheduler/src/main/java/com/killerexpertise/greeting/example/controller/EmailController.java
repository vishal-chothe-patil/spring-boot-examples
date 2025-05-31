package com.killerexpertise.greeting.example.controller;

import com.killerexpertise.greeting.example.service.EmailServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailServiceI emailService;

    @GetMapping("/sendmsg")
    public ResponseEntity<String> sendGoodMorningEmails() {
        logger.info("API called: /api/email/sendmsg - Sending Good Morning emails...");
        emailService.sendGoodMorningEmails();
        logger.info("Good Morning emails have been sent successfully.");
        return new ResponseEntity<>("Good Morning emails sent successfully!", HttpStatus.OK);
    }
}
