import java.util.*;

class RateLimiterTokenBucket {
    // Credit-based rate limiter using a token bucket approach
    private final int maxRequests;
    private final long timeWindowMillis;
    private final int maxCredits;
    private final Map<Integer, CustomerBucket> customerBuckets;

    static class CustomerBucket {
        Queue<Long> requests = new LinkedList<>();
        int credits;

        CustomerBucket(int maxCredits) {
            this.credits = maxCredits;
        }
    }

    public RateLimiterTokenBucket(int maxRequests, long timeWindowSeconds, int maxCredits) {
        this.maxRequests = maxRequests;
        this.timeWindowMillis = timeWindowSeconds * 1000;
        this.maxCredits = maxCredits;
        this.customerBuckets = new HashMap<>();
    }

    public synchronized boolean rateLimit(int customerId) {
        long now = System.currentTimeMillis();
        customerBuckets.putIfAbsent(customerId, new CustomerBucket(maxCredits));
        CustomerBucket bucket = customerBuckets.get(customerId);

        // Remove expired requests
        while (!bucket.requests.isEmpty() && (now - bucket.requests.peek() > timeWindowMillis)) {
            bucket.requests.poll();
        }

        // Convert unused capacity into credits
        int availableSlots = maxRequests - bucket.requests.size();
        bucket.credits = Math.min(bucket.credits + availableSlots, maxCredits);

        // Allow request using normal slots or credits
        if (bucket.requests.size() < maxRequests) {
            bucket.requests.add(now);
            return true; // ✅ Allowed (normal request quota)
        } else if (bucket.credits > 0) {
            bucket.credits--;
            return true; // ✅ Allowed (using stored credits)
        }

        return false; // ❌ Rate limited (no credits left)
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiterTokenBucket limiter = new RateLimiterTokenBucket(3, 10, 5); // Max 3 requests per 10s, max 5 credits

        int customerId = 101;
        for (int i = 0; i < 7; i++) {
            System.out.println("Request " + (i + 1) + ": " + (limiter.rateLimit(customerId) ? "✅ Allowed" : "❌ Denied"));
            Thread.sleep(2000); // Simulating traffic bursts
        }
    }
}
