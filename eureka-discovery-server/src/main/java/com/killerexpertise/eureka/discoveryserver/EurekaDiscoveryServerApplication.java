package com.killerexpertise.eureka.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  // Enabling Eureka Server functionality
public class EurekaDiscoveryServerApplication {

	public static void main(String[] args) {

		// Print a message before running the application
		System.out.println("Starting Eureka Discovery Server...");

		SpringApplication.run(EurekaDiscoveryServerApplication.class, args);
	}

}
