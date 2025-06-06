package RateLimiter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter extends RateLimiter{
	
	private final ConcurrentMap<Long,AtomicInteger> window = new ConcurrentHashMap<>();
	
	
	protected FixedWindowRateLimiter(int requests, int time) {
		super(requests,time);
	}
	
	@Override
	boolean rateLimit() {
		long wKey = System.currentTimeMillis() / 1000*1000;
		window.putIfAbsent(wKey, new AtomicInteger(0));
		return window.get(wKey).incrementAndGet() <= (requestsAllowed/timeAllowed);
	
	}
}
