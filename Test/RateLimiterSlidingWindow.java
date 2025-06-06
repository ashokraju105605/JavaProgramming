import java.util.*;

class RateLimiterSlidingWindow {
    private final int maxRequests;
    private final long timeWindowMillis;
    private final Map<Integer, Queue<Long>> customerRequests;

    public RateLimiterSlidingWindow(int maxRequests, long timeWindowSeconds) {
        this.maxRequests = maxRequests;
        this.timeWindowMillis = timeWindowSeconds * 1000;
        this.customerRequests = new HashMap<>();
    }

    public synchronized boolean rateLimit(int customerId) {
        long now = System.currentTimeMillis();
        customerRequests.putIfAbsent(customerId, new LinkedList<>());
        Queue<Long> requestTimes = customerRequests.get(customerId);

        // Remove timestamps outside the time window
        while (!requestTimes.isEmpty() && (now - requestTimes.peek() > timeWindowMillis)) {
            requestTimes.poll();
        }

        // Allow request if within limit
        if (requestTimes.size() < maxRequests) {
            requestTimes.add(now);
            return true; // ✅ Request allowed
        }

        return false; // ❌ Rate limit exceeded
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiterSlidingWindow limiter = new RateLimiterSlidingWindow(3, 10); // Max 3 requests per 10 seconds

        int customerId = 101;
        for (int i = 0; i < 5; i++) {
            System.out.println("Request " + (i + 1) + ": " + (limiter.rateLimit(customerId) ? "✅ Allowed" : "❌ Denied"));
            Thread.sleep(3000); // Simulating request interval
        }
    }
}