package com.killerexpertise.greeting.example.controller;

import com.killerexpertise.greeting.example.service.EmailServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailServiceI emailService;

    @GetMapping("/sendmsg")
    public ResponseEntity<String> sendGoodMorningEmails() {
        emailService.sendGoodMorningEmails();
        return new ResponseEntity<>("Good Morning emails sent successfully!", HttpStatus.OK);
    }
}
