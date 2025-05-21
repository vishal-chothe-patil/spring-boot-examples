package com.killerexpertise.example.controller;

import com.killerexpertise.example.service.TaskSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskSchedulerService taskSchedulerService;

    @PostMapping("/run-now")
    public ResponseEntity<String> runSchedulerManually() {
        taskSchedulerService.runTaskManually();
        return ResponseEntity.ok("Scheduled task triggered manually!");
    }
}
