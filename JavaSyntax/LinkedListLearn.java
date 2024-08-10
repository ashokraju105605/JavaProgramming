package JavaSyntax;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListLearn {
    public static void main(String[] args){
        System.out.println("Jai Shree Ram");

        // Create, Init, Read, Update, Delete, Count, Search, Iterate, Comparision, Conversion, Print, Specifics.

        // Create
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("Ashok");// add to the end of list.
        ll.add("Raju");
        ll.add("Gadhiraju");
        LinkedList<String> ll2 = new LinkedList<String>();
        ll2.add("Arjun");
        ll2.add("Jyothi");
        ll.addAll(ll2);

        // Init
        ll.addFirst("test");
        ll.addLast("temp");
        ll.add(2, "Ananya");
    
        // Read
        ll.get(2);
        ll.getFirst();
        ll.getLast();
        System.out.println(ll.element()); // Returns the head of the queue.
        
        // Update
        ll.set(2,"raju");

        // Remove
        ll.remove("test");

        // Count
        ll.size();
        ll.stream().count();

        // Search
        ll.indexOf("Ashok");
        ll.contains("raju");

        // Iterate
        ll.stream().forEach(System.out::println);
        for(int i=0;i<ll.size();i++)
        {
            System.out.println(ll.get(i));
        }

        for(String s:ll)
        {
            System.out.println(s);
        }

        Iterator it = ll.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        
        // Comparision
        System.out.println(ll.equals(ll2));
        
        // Conversion
        String[] strArr = ll.toArray(new String[0]);
        
        // Print
        System.out.println(ll.toString());

        
        // Specifics
        // LinkedList is a Double Eneded Queue in Java.

        // Queue Operations
        ll.add("raju");ll.add("gadhiraju");
        // Stack Operations
        ll.addFirst("test");
        ll.addLast("temp");
        ll.offer("Sita"); // add to end of list
        ll.offerFirst("laxman"); //

        // Queue Operations
        ll.poll(); // REMOVE FIRST
        ll.pollLast();  // REMOVE LAST
        ll.remove(); // REMOVE FIRST
        ll.removeLast();

        ll.peek(); // Returns the head of the queue.
        ll.peekFirst();
        ll.peekLast();
        

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
