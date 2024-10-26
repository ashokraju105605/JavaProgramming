package JavaSyntax;

import java.util.*;

public class HashMapLearn {
        public static void main(String[] args)
        {
            System.out.println("Jai Shree Ram");

            // Create, Init, Read, Update, Delete, Count, Search, Iterate, Comparision, Conversion, Print, Specifics.

            // Create
            HashMap<String, Integer> hm = new HashMap<>();

            // Init
            hm.put("ashok",1);
            hm.put("raju", 2);
            hm.put("ananya", 3);
            hm.put("test", 4);
            hm.put("test", 102); // this would trample existing value, if you want to be careful use putIfAbsent

            // Read
            System.out.println(hm.get("ashok"));
            System.out.println(hm.get("ashok1"));
            System.out.println(hm.getOrDefault("ashok1", 100));

            // Update
            System.out.println(hm.put("ashok", 100));

            // Delete
            System.out.println(hm.remove("test"));
            System.out.println(hm.remove("test1"));

            // Count
            System.out.println(hm.size());
            System.out.println(hm.isEmpty());

            // Search
            System.out.println(hm.containsKey("ashok"));
            System.out.println(hm.containsValue(100));
            System.out.println(hm.containsValue(1000));

            // Iterate
            Iterator<Map.Entry<String, Integer>> it = hm.entrySet().iterator();
            while (it.hasNext())
            {
                Map.Entry<String, Integer> entry = it.next();
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

            hm.forEach((k, v) -> System.out.println(k + " " + v));
            
            // Comparision
            HashMap<String, Integer> hm2 = new HashMap<>();
            hm2.put("ashok",1);
            hm2.put("raju", 2);
            hm2.put("ananya", 3);
            System.out.println(hm.equals(hm2));

            // Conversion
            // Nothing like it.

            // Print
            System.out.println(hm);

            // Specifics
            System.out.println(hm.keySet());
            System.out.println(hm.values());
            System.out.println(hm.entrySet());
            System.out.println(hm.putIfAbsent("test", 23));
            System.out.println(hm.putIfAbsent("test", 29));
            hm.merge("ashok",3,Integer::sum);
            hm.computeIfAbsent("ashok", k -> {
                return 100;
            });
            hm.computeIfPresent("ashok", (k, v) -> {
                return v+1;
            });
            hm.computeIfPresent("ashok", (k, v) -> {
                return null;
            });
            System.out.println(hm.entrySet());
        }                
}
