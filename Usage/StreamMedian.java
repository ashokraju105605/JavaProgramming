package Usage;

import java.util.PriorityQueue;

import java.util.Collections;

public class StreamMedian {
    public static void main(String[] args) {
        int[] arr = new int[] { 5, 15, 10, 20, 3 };
        StreamMedian sm = new StreamMedian();
        sm.printMedians(arr);
    }

    void printMedians(int[] arr) {
        System.out.println("Jai Shree Ram");
        double median = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        median = arr[0];
        maxHeap.add(arr[0]);
        System.out.println(median);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > median) {
                if (minHeap.size() < maxHeap.size()) {
                    minHeap.offer(arr[i]);
                    median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
                } else if (minHeap.size() == maxHeap.size()) {
                    minHeap.offer(arr[i]);
                    median = minHeap.peek();
                } else {
                    int value = minHeap.peek();
                    minHeap.remove(value);
                    minHeap.offer(arr[i]);
                    maxHeap.offer(value);
                    median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
                }
            } else if (arr[i] < median) {
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(arr[i]);
                    median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
                } else if (minHeap.size() == maxHeap.size()) {
                    maxHeap.offer(arr[i]);
                    median = maxHeap.peek();
                } else {
                    int value = maxHeap.peek();
                    maxHeap.remove(value);
                    maxHeap.offer(arr[i]);
                    minHeap.offer(value);
                    median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
                }

            } else {
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(arr[i]);
                    median = arr[i];
                } else if (maxHeap.size() < minHeap.size()) {
                    maxHeap.add(arr[i]);
                    median = arr[i];
                } else {
                    maxHeap.add(arr[i]);
                    median = maxHeap.peek();
                }
            }
            System.out.println(median);
        }
    }
}

/**
 * mistakes: took the median as int, as there is a division by 2, so should take
 * double. also median < arr[i] should be checked with the heap size check. to
 * avoid lengthy cases and equality doesn't need to be handled seperately in
 * this way.
 */