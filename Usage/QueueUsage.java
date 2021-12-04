package Usage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueUsage {
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");

        Queue<Integer> q = new LinkedList<>();
        // q.add("21");
        q.add(5);
        q.add(8);
        q.add(10);
        q.add(12);
        q.add(15);

        System.out.println(q);

        System.out.println(q.peek());

        q.poll();
        q.remove();

        System.out.println(q.peek());
        System.out.println(q.size());

        Queue<String> pq = new PriorityQueue<>();

        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");

        System.out.println("Initial Queue " + pq);

        pq.remove("Geeks");

        System.out.println("After Remove " + pq);

        System.out.println("Poll Method " + pq.poll());

        System.out.println("Final Queue " + pq);

        Iterator<String> iterator = pq.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

}
