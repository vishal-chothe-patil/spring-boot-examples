package com.killerexpertise.example.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // Custom logic to check if a service is working
        boolean serviceUp = checkExternalService();

        if (serviceUp) {
            return Health.up()
                         .withDetail("customService", "Running smoothly")
                         .build();
        } else {
            return Health.down()
                         .withDetail("customService", "Service is down")
                         .withDetail("error", "Timeout or failure detected")
                         .build();
        }
    }

    // Simulate service check (e.g., ping DB, API call, file system, etc.)
    private boolean checkExternalService() {
        return true; // Replace this with real logic
    }
}
