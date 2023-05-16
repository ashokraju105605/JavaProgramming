package LearnBasics;

import java.util.*;

public class LinkedListUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        LinkedList<String> ll = new LinkedList<String>();

        System.out.println(ll.size());
        System.out.println(ll.add("ashok")); // add to the end of list.
        System.out.println(ll.contains("ashok"));
        ll.add("raju");ll.add("gadhiraju");
        System.out.println(ll.element());
        ll.add(2, "Ananya");
        System.out.println(ll.toString());
        LinkedList<String> ll2 = new LinkedList<String>();
        ll2.add("Arjun");
        ll2.add("Jyothi");
        ll.addAll(ll2);
        System.out.println(ll.toString());
        System.out.println(ll.set(1,"grape"));
        //System.out.println(ll.addFirst("Test"));  // ADD FIRST, Returns void
        //System.out.println(ll.addLast("Finish")); // ADD LAST, Returns void
        System.out.println(ll.toString());
        System.out.println(ll.get(2));
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        System.out.println(ll.indexOf("Raju"));
        System.out.println(ll.isEmpty());
        ll.addFirst("test");
        ll.addLast("temp");
        System.out.println(ll.offer("Sita")); // add to end of list
        System.out.println(ll.offerFirst("laxman")); // ADD FIRST
        System.out.println(ll.offerLast("bharata")); // ADD LAST
        System.out.println(ll.toString());
        System.out.println(ll.peekFirst());
        System.out.println(ll.toString());
        System.out.println(ll.peekLast());
        System.out.println(ll.toString());
        System.out.println(ll.pollFirst()); // REMOVE FIRST
        System.out.println(ll.pollLast());  // REMOVE LAST
        System.out.println(ll.removeFirst()); // REMOVE FIRST
        System.out.println(ll.removeLast());  // REMOVE LAST
        System.out.println(ll.toString());
        System.out.println(ll.size());

        System.out.println(ll.remove(2));
        System.out.println(ll.remove("ashok"));
        ll.clear();
        System.out.println(ll.toString());
    }
}
