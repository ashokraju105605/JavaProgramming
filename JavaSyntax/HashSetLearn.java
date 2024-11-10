package JavaSyntax;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetLearn {
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");

        // Create, Init, Read, Update, Delete, Count, Search, Iterate, Comparision, Conversion, Print, Specifics.

        // Create
        HashSet<String> hs = new HashSet<String>();
        
        // Init
        hs.add("ashok");
        hs.add("raju");
        hs.add("ananya");
        hs.add("test");

        // Read
        // No indexOf, get, methods

        // Update
        // Nothing like it.

        // Delete
        System.out.println(hs.remove("test"));
        System.out.println(hs.removeIf(x -> x.equals("test")));

        // Count
        System.out.println(hs.size());
        System.out.println(hs.isEmpty());

        // Search
        System.out.println(hs.contains("ashok"));

        // Iterate
        Iterator<String> it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        hs.forEach(System.out::println);
        
        // Comparision
        HashSet<String> hs2 = new HashSet<>();
        hs2.add("ashok");
        hs2.add("raju");
        hs2.add("ananya");
        hs2.add("test");

        System.out.println(hs.equals(hs2));

        // Conversion
        String[] arr = hs.toArray(new String[hs.size()]);
        for (String s: arr) {
            System.out.println(s);
        }

        // Print
        System.out.println(hs);

        // Specifics
        // No specific methods.
        HashSet<String> hs1 = new HashSet<>();
        hs1.add("ashok");
        hs.removeAll(hs1); // Difference A - B.
        hs.retainAll(hs1); // Intersection A & B.

    }
    
}
