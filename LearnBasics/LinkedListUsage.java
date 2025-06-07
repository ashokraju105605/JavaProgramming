package LearnBasics;

import java.util.*;

public class LinkedListUsage {
    public static void main(String[] args)
    {
        // LinkedList is a Double Eneded Queue in Java.
        // It is a linear data structure that allows elements to be added or removed from both ends.
        // LinkedList maintains the insertion order of elements.
        // LinkedList is a Queue, so it has methods like offer, poll, peek, etc.
        // It also implements Deque interface, so it has methods like addFirst, addLast, removeFirst, removeLast, etc.
        System.out.println("Jai Shree Ram");
        LinkedList<String> ll = new LinkedList<String>();

        System.out.println(ll.size());
        System.out.println(ll.add("ashok")); // add to the end of list. return true if successful.
        System.out.println(ll.contains("ashok"));
        ll.add("raju");ll.add("gadhiraju");
        System.out.println(ll.element()); // returns first element of list.
        ll.add(2, "Ananya");
        System.out.println(ll.toString());
        LinkedList<String> ll2 = new LinkedList<String>();
        ll2.add("Arjun"); // add to the end of list. return true if successful.
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
        ll.addFirst("test"); // add to the beginning of list. returns void.
        ll.addLast("temp"); // add to the end of list. returns void.
        System.out.println(ll.offer("Sita")); // add to end of list and retrurns true if successful.
        System.out.println(ll.offerFirst("laxman")); // ADD FIRST, returns true if successful.
        System.out.println(ll.offerLast("bharata")); // ADD LAST, offer and poll are queue methods.
        System.out.println(ll.toString());
        System.out.println(ll.peekFirst());
        System.out.println(ll.toString());
        System.out.println(ll.peekLast());
        System.out.println(ll.toString());
        System.out.println(ll.poll()); // REMOVE FIRST, returns null if empty.
        System.out.println(ll.pollFirst()); // REMOVE FIRST, returns null if empty.
        System.out.println(ll.pollLast());  // REMOVE LAST, returns null if empty.
        System.out.println(ll.removeFirst()); // REMOVE FIRST, throws NoSuchElementException exception if empty.
        System.out.println(ll.removeLast());  // REMOVE LAST, throws NoSuchElementException exception if empty.
        System.out.println(ll.toString());
        System.out.println(ll.size());
        System.out.println(ll.subList(0, 2)); // returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
        // there are no headList, tailList as it is only insertion order based list, not sorted list.

        // removes the element at the specified position in this list. returns the element that was removed from the list. IndexOutofBoundsException if index is out of range (index < 0 || index >= size()).
        System.out.println(ll.remove(2));
        // removes the first occurrence of the specified element from this list, if it is present. returns true if successful.
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
