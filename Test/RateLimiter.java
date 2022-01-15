package Test;

import java.sql.Time;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Siddharth on 2/19/18.
 * This class is implemented based on Token bucket algorithm
 */
public class RateLimiter {

    private long capacity;
    private long windowTimeInSeconds;

    long lastRefillTimeStamp;

    long refillCountPerSecond;

    long availableTokens;

    public RateLimiter(long capacity, long windowTimeInSeconds) {
        this.capacity = capacity;
        this.windowTimeInSeconds = windowTimeInSeconds;
        lastRefillTimeStamp = System.currentTimeMillis();
        refillCountPerSecond = capacity / windowTimeInSeconds;
        availableTokens = 0;
    }

    public long getAvailableTokens() {
        return this.availableTokens;
    }

    public boolean tryConsume() {
        refill();

        if (availableTokens > 0) {
            --availableTokens;
            return true;
        } else {
            return false;
        }
    }

    private void refill() {
        long now = System.currentTimeMillis();
        if (now > lastRefillTimeStamp) {
            long elapsedTime = now - lastRefillTimeStamp;
            // refill tokens for this durationlong tokensToBeAdded = (elapsedTime/1000) *
            // refillCountPerSecond;
            long tokensToBeAdded = (elapsedTime / 1000) * refillCountPerSecond;
            if (tokensToBeAdded > 0) {
                availableTokens = Math.min(capacity, availableTokens + tokensToBeAdded);
                lastRefillTimeStamp = now;

            }
        }
    }
}