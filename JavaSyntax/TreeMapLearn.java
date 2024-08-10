package JavaSyntax;
import java.util.*;

public class TreeMapLearn {
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");
        // Create, Init, Read, Update, Delete, Count, Search, Iterate, Comparision, Conversion, Print, Specifics.

        // Create
        TreeMap<String, Integer> tm = new TreeMap<>();
        TreeMap<String, Integer> tm1 = new TreeMap<>(new Comparator<String>() {
             @Override
             public int compare(String o1, String o2) {
                 return o1.compareTo(o2);
              }
        });

        // Init
        tm.put("ashok",1);
        tm.put("raju", 2);
        tm.put("ananya", 3);

        // Read
        System.out.println(tm.firstKey());
        System.out.println(tm.lastKey());
        System.out.println(tm.lowerKey("ashok"));
        System.out.println(tm.higherKey("ashok"));
        System.out.println(tm.floorKey("ashok"));
        System.out.println(tm.ceilingKey("ashok"));
        System.out.println(tm.firstEntry());
        System.out.println(tm.lastEntry());
        System.out.println(tm.getOrDefault("test", 100));

        // Update
        System.out.println(tm.put("ashok", 100));
        System.out.println(tm.put("ashok1", 100));

        // Delete
        //System.out.println(tm.pollFirstEntry());
        //System.out.println(tm.pollLastEntry());
        System.out.println(tm.remove("test"));
        System.out.println(tm.remove("test1"));

        // Count
        System.out.println(tm.size());
        System.out.println(tm.isEmpty());

        // Search
        System.out.println(tm.containsKey("ashok"));
        System.out.println(tm.containsValue(100));

        // Iterate
        Iterator<Map.Entry<String, Integer>> it = tm.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String, Integer> entry = it.next();
             System.out.println(entry.getKey() + " " + entry.getValue());
        }
        tm.forEach((k, v) -> System.out.println(k + " " + v));

        // Comparision
        TreeMap<String, Integer> tm2 = new TreeMap<>();
        tm2.put("ashok",1);
        tm2.put("raju", 2);

        System.out.println(tm.equals(tm2));

        // Conversion
        String[] arr = tm.keySet().toArray(new String[tm.size()]);

        for (String s: arr) {
             System.out.println(s);
         }

         // Specifics
         System.out.println(tm.ceilingKey("ashok"));
         System.out.println(tm.floorKey("ashok"));
         System.out.println(tm.floorKey("ashok1"));
         System.out.println(tm.ceilingKey("ashok1"));
         System.out.println(tm.floorKey("ashok1"));
         System.out.println(tm.headMap(tm.firstKey()));
         System.out.println(tm.tailMap(tm.firstKey()));
         System.out.println(tm.subMap(tm.firstKey(), tm.lastKey()));
         System.out.println(tm.subMap(tm.firstKey(), true, tm.lastKey(), true));
         System.out.println(tm.subMap(tm.firstKey(), false, tm.lastKey(), false));
         System.out.println(tm.subMap(tm.firstKey(), true, tm.lastKey(), false));
         System.out.println(tm.subMap(tm.firstKey(), false, tm.lastKey(), true));
         System.out.println(tm.headMap(tm.firstKey(), true));
         System.out.println(tm.headMap(tm.firstKey(), false));
         System.out.println(tm.tailMap(tm.firstKey(), true));
         System.out.println(tm.tailMap(tm.firstKey(), false));
         System.out.println(tm.descendingKeySet());
         System.out.println(tm.descendingMap());


    }
}
