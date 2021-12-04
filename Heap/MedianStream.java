package Heap;

import java.util.*;
import java.util.PriorityQueue;

public class MedianStream {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static double median;

    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");

        // int A[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };

        int[] arr = new int[] { 5, 15, 10, 20, 3 };
        printMedian(arr);
    }

    static void printMedian(int[] a) {
        median = a[0];
        maxHeap.add(a[0]);
        System.out.println(median);
        for (int i = 1; i < a.length; i++) {
            System.out.println(getMedian(a[i]));
        }
    }

    static double getMedian(int x) {
        if (maxHeap.size() > minHeap.size()) {
            if (x < median) {
                minHeap.add(maxHeap.remove());
                maxHeap.add(x);
            } else {
                minHeap.add(x);
            }
            median = (double) ((maxHeap.peek() + minHeap.peek()) / 2);
        } else if (maxHeap.size() < minHeap.size()) {
            if (x > median) {
                maxHeap.add(minHeap.remove());
                minHeap.add(x);
            } else {
                maxHeap.add(x);
            }
            median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            if (x < median) {
                maxHeap.add(x);
                median = (double) maxHeap.peek();
            } else {
                minHeap.add(x);
                median = (double) minHeap.peek();
            }
        }

        return median;
    }

}
