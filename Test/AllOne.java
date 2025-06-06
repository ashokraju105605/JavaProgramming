import java.util.*;
// Atlassian Interview Question , insert , delete , getmax, getmin in O(1) time complexity.
public class AllOne {
    private Map<String, Integer> keyCount;
    private TreeMap<Integer, Set<String>> countBuckets;

    public AllOne() {
        keyCount = new HashMap<>();
        countBuckets = new TreeMap<>();
    }

    private void removeKeyFromBucket(String key, int count) {
        Set<String> bucket = countBuckets.get(count);
        if (bucket != null) {
            bucket.remove(key);
            if (bucket.isEmpty()) {
                countBuckets.remove(count);
            }
        }
    }

    public void inc(String key) {
        int prevCount = keyCount.getOrDefault(key, 0);
        int newCount = prevCount + 1;
        keyCount.put(key, newCount);

        removeKeyFromBucket(key, prevCount);

        countBuckets.computeIfAbsent(newCount, k -> new HashSet<>()).add(key);
    }

    public void dec(String key) {
        int prevCount = keyCount.get(key);
        int newCount = prevCount - 1;

        removeKeyFromBucket(key, prevCount);

        if (newCount == 0) {
            keyCount.remove(key);
        } else {
            keyCount.put(key, newCount);
            countBuckets.computeIfAbsent(newCount, k -> new HashSet<>()).add(key);
        }
    }

    public String getMaxKey() {
        return countBuckets.isEmpty() ? "" : countBuckets.lastEntry().getValue().iterator().next();
    }

    public String getMinKey() {
        return countBuckets.isEmpty() ? "" : countBuckets.firstEntry().getValue().iterator().next();
    }
}