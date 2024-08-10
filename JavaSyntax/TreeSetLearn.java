package JavaSyntax;
import java.util.*;
public class TreeSetLearn {
      public static void main(String[] args) {
          System.out.println("Jai Shree Ram");
          // Create, Init, Read, Update, Delete, Count, Search, Iterate, Comparision, Conversion, Print, Specifics.

          // Create
          TreeSet<String> ts = new TreeSet<String>();
          TreeSet<String> ts1 = new TreeSet<String>(new Comparator<String>() {
               @Override
               public int compare(String o1, String o2) {
                   return o1.compareTo(o2);
                }
          });

          // Init
          ts.add("ashok");
          ts.add("raju");
          ts.add("ananya");

          // Read
          System.out.println(ts.first());
          System.out.println(ts.last());
          System.out.println(ts.lower("ashok"));
          System.out.println(ts.higher("raju"));

          // Update
          // Nothing like it.

          // Delete
          System.out.println(ts.remove("test"));
          System.out.println(ts.remove("test"));

          // Count
          System.out.println(ts.size());
          System.out.println(ts.isEmpty());

          // Search
          System.out.println(ts.contains("ashok"));
          System.out.println(ts.contains("ashok1"));

          // Iterate
          Iterator<String> it = ts.iterator();
         while (it.hasNext()) {
             System.out.println(it.next());
         }
         ts.forEach(System.out::println);

         // Comparision
         TreeSet<String> ts2 = new TreeSet<String>();
         ts2.add("ashok");
         ts2.add("raju");
         ts2.add("ananya");
         System.out.println(ts.equals(ts2));

         // Conversion
         String[] arr = ts.toArray(new String[ts.size()]);
         for (String s: arr) {
             System.out.println(s);
         }

         // Specifics
         System.out.println(ts.ceiling("ashok"));
         System.out.println(ts.floor("ashok"));
         System.out.println(ts.floor("ashok1"));
         System.out.println(ts.ceiling("ashok1"));
         System.out.println(ts.floor("ashok1"));
         System.out.println(ts.headSet(ts.first()));
         System.out.println(ts.headSet(ts.first(), true));
         System.out.println(ts.headSet(ts.first(), false));
         System.out.println(ts.tailSet(ts.first()));
         System.out.println(ts.tailSet(ts.first(), true));
         System.out.println(ts.tailSet(ts.first(), false));
         System.out.println(ts.subSet(ts.first(), ts.last()));
         System.out.println(ts.subSet(ts.first(), true, ts.last(), true));
         System.out.println(ts.subSet(ts.first(), false, ts.last(), false));
         System.out.println(ts.subSet(ts.first(), false, ts.last(), true));
         System.out.println(ts.removeAll(ts2));  // gives the 1st set after removing the 2nd set. Subraction
         System.out.println(ts.retainAll(ts2));  // gives the 1st set after retaining the 2nd set. Intersection


      }    
}
