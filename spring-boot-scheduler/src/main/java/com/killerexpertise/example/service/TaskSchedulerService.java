package com.killerexpertise.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TaskSchedulerService {

    private static final Logger logger = LoggerFactory.getLogger(TaskSchedulerService.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Scheduled task
    @Scheduled(cron = "0 30 2 * * ?")  // every day at 2:30 AM
    public void performScheduledTask() {
        logger.info("Scheduled Task Execution - {}", LocalDateTime.now().format(formatter));
        // Task logic here (report generation, cleanup, etc.)
    }

    // Public method for manual triggering
    public void runTaskManually() {
        logger.info("Manual Trigger - {}", LocalDateTime.now().format(formatter));
        // Same task logic
        performScheduledTask();
    }
}