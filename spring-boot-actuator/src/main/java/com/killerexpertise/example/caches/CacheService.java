package com.killerexpertise.example.caches;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    private int callCount = 0;

    @Cacheable("sampleCache")
    public String getCachedData(String input) {
        callCount++;
        try {
            Thread.sleep(1000); // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Processed with input: " + input + " | call count: " + callCount + " | timestamp: " + System.currentTimeMillis();
    }
}
