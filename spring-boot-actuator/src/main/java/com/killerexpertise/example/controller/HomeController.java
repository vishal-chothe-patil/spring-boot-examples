package com.killerexpertise.example.controller;

import com.killerexpertise.example.caches.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private CacheService cacheService;

    @GetMapping("/hello")
    public String helloActuator() {
        logger.info("Received request to /api/hello");
        return "Hello from Spring Boot Actuator Monitoring Example!";
    }

    // New endpoint to test cache
    @GetMapping("/cache/{input}")
    public String cacheExample(@PathVariable String input) {
        logger.info("Received request to /api/cache/{}", input);
        return cacheService.getCachedData(input);
    }
}
