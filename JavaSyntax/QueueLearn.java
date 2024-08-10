package JavaSyntax;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueLearn {
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");

        // Create, Init, Read, Update, Delete, Count, Search, Iterate, Comparision, Conversion, Print, Specifics.

        // Create
        Queue<String> llq = new LinkedList<String>();
        Queue<String> pq = new PriorityQueue<String>(); // Needs a Comparator.
        Queue<String> pq1 = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Queue<String> adq = new ArrayDeque<String>();

        // Init
        pq.add("ashok");
        pq.offer("raju");
        pq.offer("ananya");
        pq.offer("test");

        // Read
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.element());

        // Update
        // nothing like it.

        // Delete
        System.out.println(pq.remove("test"));
        System.out.println(pq.poll());

        // Count
        System.out.println(pq.isEmpty());
        System.out.println(pq.size());

        // Search
        System.out.println(pq.contains("raju"));

        // Iterate
        Iterator<String> it = pq.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        pq.forEach(System.out::println);

        // Comparision
        Queue<String> llq2 = new LinkedList<String>();
        llq2.add("ashok");
        llq2.add("raju");
        llq2.add("ananya");

        System.out.println(pq.equals(llq2));

        // Conversion
        String[] strArr = pq.toArray(new String[0]);

        // Print
        System.out.println(pq.toString());

        // Specifics
        // LinkedList is a Double Eneded Queue in Java.
        // Queue Operations
        pq.add("raju");pq.add("gadhiraju");
        // Stack Operations


    }
}
