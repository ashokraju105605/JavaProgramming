package Heap;

import java.util.*;

public class KthLargest {
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");

        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int k = 4;

        printKthLargest(arr, k);
    }

    static void printKthLargest(int[] a, int k) {
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            if (i < k)
                minpq.add(a[i]);
            else {
                if (a[i] > minpq.peek()) {
                    minpq.poll();
                    minpq.add(a[i]);
                }
            }
            if (i >= k)
                System.out.println(minpq.peek());
        }
    }

    // there is no specific data structure to limit size of PQ, you should manage
    // that in app code.
}
