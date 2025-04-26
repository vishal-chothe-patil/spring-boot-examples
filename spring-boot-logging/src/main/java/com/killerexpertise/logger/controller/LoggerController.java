package com.killerexpertise.logger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
public class LoggerController {

	 // Create a logger specific to this class using SLF4J
    private static final Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @GetMapping("/test")
    public String testLogging() {

    	logger.trace("TRACE - Detailed debug info, typically used for diagnosing specific issues during development");
    	logger.debug("DEBUG - Useful for debugging, shows application state and flow");
    	logger.info("INFO - General app events (startup, shutdown, or configuration updates)");
    	logger.warn("WARN - Something unexpected happened, but the application is still running fine");
    	logger.error("ERROR - Serious problem affecting functionality");

        return "Logging messages printed in console!";
    }
}
