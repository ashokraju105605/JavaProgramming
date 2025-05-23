package LearnBasics;

import java.util.*;

public class TreeSetUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        TreeSet<Integer> ts = new TreeSet<Integer>();

        ts.add(20);
        ts.add(50);
        ts.add(30);

        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(70);
        al.add(90);
        al.add(5);

        ts.addAll(al);

        System.out.println(ts);
        System.out.println(ts.ceiling(10)); // returns the least element greater than or equal to the given element.
        System.out.println(ts.ceiling(95));
        System.out.println(ts.higher(92)); // returns the least element greater than the given element.
        System.out.println(ts.floor(21)); // returns the greatest element less than or equal to the given element.
        System.out.println(ts.floor(2));
        System.out.println(ts.lower(20)); // returns the greatest element less than the given element.
        System.out.println(ts.contains(3));
        System.out.println(ts.isEmpty());
        System.out.println(ts.tailSet(2)); // returns all elements greater than or equal to the given element.
        System.out.println(ts.headSet(2)); // returns all elements less than the given element.
        System.out.println(ts.subSet(1, 2)); // returns all elements greater than or equal to the first element and less than the second element.
        System.out.println(ts.remove(4));
        System.out.println(ts.first());
        System.out.println(ts.last());
        System.out.println(ts.size());
        System.out.println();
        
    }
}
