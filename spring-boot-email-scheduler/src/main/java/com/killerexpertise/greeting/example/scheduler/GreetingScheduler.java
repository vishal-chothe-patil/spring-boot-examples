package com.killerexpertise.greeting.example.scheduler;

import com.killerexpertise.greeting.example.service.EmailServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GreetingScheduler {

    private static final Logger logger = LoggerFactory.getLogger(GreetingScheduler.class);

    @Autowired
    private EmailServiceI emailService;

    // Runs every day at 1:25 PM
    @Scheduled(cron = "0 25 13 * * *")
    public void sendDailyGoodMorningEmails() {
        logger.info("Scheduled task running: Sending Good Morning emails...");
        emailService.sendGoodMorningEmails();
    }
}
