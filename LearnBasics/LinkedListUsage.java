package LearnBasics;

import java.util.*;

public class LinkedListUsage {
    public static void main(String[] args)
    {
        // LinkedList is a Double Eneded Queue in Java.
        System.out.println("Jai Shree Ram");
        LinkedList<String> ll = new LinkedList<String>();

        System.out.println(ll.size());
        System.out.println(ll.add("ashok")); // add to the end of list.
        System.out.println(ll.contains("ashok"));
        ll.add("raju");ll.add("gadhiraju");
        System.out.println(ll.element()); // returns first element of list.
        ll.add(2, "Ananya");
        System.out.println(ll.toString());
        LinkedList<String> ll2 = new LinkedList<String>();
        ll2.add("Arjun"); // add to the end of list.
        ll2.add("Jyothi");
        ll.addAll(ll2);
        System.out.println(ll.toString());
        System.out.println(ll.set(1,"grape")); // replace the element at index 1 with grape.
        //System.out.println(ll.addFirst("Test"));  // ADD FIRST, Returns void
        //System.out.println(ll.addLast("Finish")); // ADD LAST, Returns void
        System.out.println(ll.toString());
        System.out.println(ll.get(2));
        System.out.println(ll.getFirst()); // same is seen for Sets and Deques.
        System.out.println(ll.getLast());
        System.out.println(ll.indexOf("Raju"));
        System.out.println(ll.isEmpty());
        ll.addFirst("test");
        ll.addLast("temp");
        System.out.println(ll.offer("Sita")); // add to end of list and retrurns true if successful.
        System.out.println(ll.offerFirst("laxman")); // ADD FIRST
        System.out.println(ll.offerLast("bharata")); // ADD LAST, offer and poll are queue methods.
        System.out.println(ll.toString());
        System.out.println(ll.peekFirst());
        System.out.println(ll.toString());
        System.out.println(ll.peekLast());
        System.out.println(ll.toString());
        System.out.println(ll.poll()); // REMOVE FIRST, returns null if empty.
        System.out.println(ll.pollFirst()); // REMOVE FIRST
        System.out.println(ll.pollLast());  // REMOVE LAST
        System.out.println(ll.removeFirst()); // REMOVE FIRST, throws NoSuchElementException exception if empty.
        System.out.println(ll.removeLast());  // REMOVE LAST
        System.out.println(ll.toString());
        System.out.println(ll.size());

        System.out.println(ll.remove(2));
        System.out.println(ll.remove("ashok"));
        ll.clear();
        System.out.println(ll.toString());
        ArrayDequeueTest();
    }
    public static void ArrayDequeueTest()
    {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.add(2);
        ad.add(4);
        ad.addFirst(1);
        ad.addLast(6);
        ad.getFirst();
        ad.peekFirst();
        

        System.out.println(ad.pollFirst());
        System.out.println(ad.pollLast());
        System.out.println(ad.toString());
    }
}
