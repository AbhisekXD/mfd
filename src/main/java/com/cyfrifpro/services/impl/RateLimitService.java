package com.cyfrifpro.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RateLimitService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    // Max requests per minute
    @Value("${rate.limit.max-requests}")
    private int maxRequests;

    @Value("${rate.limit.time-frame-minutes}")
    private int timeFrameMinutes;

    // Check if the user has exceeded the rate limit
    public boolean isRequestAllowed(Long userId) {
        String key = "rate_limit:" + userId;

        // Get the current request count from Redis
        String requestCountStr = redisTemplate.opsForValue().get(key);

        if (requestCountStr == null) {
            // If no count, set the initial value
            redisTemplate.opsForValue().set(key, "1", Duration.ofMinutes(timeFrameMinutes));
            return true; // Allow the request
        }

        int requestCount = Integer.parseInt(requestCountStr);
        if (requestCount < maxRequests) {
            // If within limit, increment the count and allow the request
            redisTemplate.opsForValue().increment(key);
            return true;
        } else {
            // If exceeded the limit, deny the request
            return false;
        }
    }
}
