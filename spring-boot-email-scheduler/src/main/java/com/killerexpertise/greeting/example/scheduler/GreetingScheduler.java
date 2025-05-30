package com.killerexpertise.greeting.example.scheduler;

import com.killerexpertise.greeting.example.service.EmailServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class GreetingScheduler {

    @Autowired
    private EmailServiceI emailService;

    // Runs every day at 1:25 PM
    @Scheduled(cron = "0 25 13 * * *")
    public void sendDailyGoodMorningEmails() {
        System.out.println("Scheduled task running: Sending Good Morning emails...");
        emailService.sendGoodMorningEmails();
    }

}
