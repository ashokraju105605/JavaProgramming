package LearnBasics;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapUsage {
    public static void usage(){
        // Create, Init, Read, Update, Delete, Count, Search, Iterate, Comparision, Conversion, Specifics.

        // Create
        HashMap<Integer, String> hm = new HashMap<>();
        HashMap<Integer, String> hm1 = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, ArrayList<String>> map2 = new HashMap<>();
        // HashMap is not synchronized, if you want to use it in multi-threaded environment, use ConcurrentHashMap.

        // Init
        hm1.put(101, "Amit");
        hm1.put(101,"Ammit"); // will trample of the existing key, if you don't want to do it, use putIfAbsent
        hm1.put(102, "Vijay");
        hm1.put(103, "Rahul");

        // Read
        System.out.println(hm1.get(1));
        System.out.println(hm.getOrDefault(103,"test-----"));
        
        // Update
        hm1.put(101, "Amit");
        hm1.put(104, "Ravi");
        hm1.merge(105, "newValue", (oldValue, newValue) -> oldValue + newValue); //newValue
        hm1.merge(103, "ashok", String::concat); //Rahulashok.
        // merge is used to update the value of the key if it exists, else it will add the key-value pair.
        // if values were integers then you can use Integer::sum as well. for merging values if key already exists.

        // Using put() + getOrDefault()
        map.put("apple", map.getOrDefault("apple", 0) + 1);
        map.merge("banana", 1, Integer::sum);// Adds 1 to the value at key "banana", creating a new entry if it doesn't exist.
        // better than using getOrDefault() + put() as it is more readable and concise.
        
        map2.computeIfAbsent(22, k -> new ArrayList<>()).add("value"); // Adds "value" to the list at key 22, creating a new list if it doesn't exist.
        // this is very useful when you want to add a value to a list at a specific key in the map. also creates a new list if the key doesn't exist.
        // if key exists, it will add the value to the existing list, else it will create a new list and add the value to it.
        // no need to check if the key exists or not, avoids manual initialization of the list, creates/updates seamlessly.

        // Using merge() with Integer::sum
        map.merge("banana", 1, Integer::sum);

        System.out.println(map); // Output: {apple=1, banana=1}
        // ✔ More readable → Directly expresses intent (sum operation). 
        // ✔ Safer → Avoids potential NullPointerException if getOrDefault() fails. 
        // ✔ Built-in handling → No need for a manual conditional check.
        System.out.println(hm1.get(104));
        
        // Delete
        hm1.remove(104);
        System.out.println(hm1.get(104));
        
        // Count
        System.out.println(hm1.size());
        System.out.println(hm1.keySet().size());
        System.out.println(hm1.values().size());
        System.out.println(hm1.entrySet().size());
        System.out.println(hm1.isEmpty());
        
        // Search
        System.out.println(hm1.containsKey(1));
        System.out.println(hm1.containsValue("Amit"));

        // Iterate
        for(Map.Entry<Integer,String> m: hm1.entrySet())
        {
            System.out.println(m.getKey()+" "+m.getValue());
        }
        // Below is useful when navigation and removal on hashmap is needed concurrently.
        Iterator<Map.Entry<Integer,String>> it = hm.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Integer,String> kvp = it.next();
            //it.remove();
            System.out.println(kvp.getKey() + " " + kvp.getValue());
        }
        hm.forEach( (key,value) -> System.out.println(key + " ### " + value));
        
        // Comparision
        System.out.println(hm1.equals(hm));
        System.out.println(hm1.hashCode());
        System.out.println(hm1.toString());
        
        // Conversion
        System.out.println(hm1.entrySet());
        System.out.println(hm1.keySet());
        System.out.println(hm1.values());
        
        // Specifics
        System.out.println(hm1.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        System.out.println(hm1.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey)));
        System.out.println(hm1.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a)));
        // no submap on hashmap, only on linkedhashmap and treemap.
        

    }
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        usage();
        HashMap<Integer,String> hm=new HashMap<Integer,String>();    

        System.out.println("Initial list of elements: "+hm);  
        hm.put(100,"Amit");    
        hm.put(101,"Vijay");    
        hm.put(102,"Rahul");   

        for(Map.Entry<Integer,String> m: hm.entrySet())
        {
            System.out.println(m.getKey()+" "+m.getValue());
            System.out.println(m.toString());
        }

        // Below is useful when navigation and removal on hashmap is needed concurrently.
        Iterator<Map.Entry<Integer,String>> it = hm.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Integer,String> kvp = it.next();
            //it.remove();
            System.out.println(kvp.getKey() + " " + kvp.getValue());
        }

        System.out.println(hm.containsKey(103));
        System.out.println(hm.containsValue("Amit"));
        System.out.println(hm.isEmpty());
        System.out.println(hm.size());
        System.out.println(hm.values().toString());
        System.out.println(hm.keySet().toString());
        System.out.println(hm.entrySet().toString());
        System.out.println(hm.get(101));
        System.out.println(hm.put(104, "ashok"));
        System.out.println(hm.remove(103));
        System.out.println(hm.remove(102));
        System.out.println(hm.replace(104, "raju"));
        System.out.println(hm.getOrDefault(103,"test-----"));
        System.out.println(hm.toString());
        System.out.println();
        hm.forEach( (key,value) -> System.out.println(key + " ### " + value));


        // SAME OPERATIONS FOR LINKEDHASHMAP, instead of array it used linkedlist for buckets.
        // can be used as LRU Cache as this uses doubly linked list of buckets. and also maintains insertion order.
        LinkedHashMap<Integer,String> lhm = new LinkedHashMap<Integer,String>();
        lhm.put(100,"Amit"); 
        lhm.put(102,"Rahul");     
        lhm.put(101,"Vijay");  
        System.out.println(lhm.toString());
        System.out.println(lhm.firstEntry().getKey());
        System.out.println(lhm.lastEntry().getKey());
        System.out.println(lhm.remove(lhm.firstEntry().getKey()));
        System.out.println(lhm.firstEntry().getKey());
        System.out.println(lhm.firstEntry());
        // System.out.println(lhm.subMap(100, 102)); // submap doesn't work on linkedhashmap, only on treemap.
        // System.out.println(lhm.headMap(101)); // headmap doesn't work on linkedhashmap, only on treemap.
        // System.out.println(lhm.tailMap(101)); // tailmap doesn't work on linkedhashmap, only on treemap.

        // TreeMap is a Red-Black tree based implementation of Map interface.
        // Java TreeMap class is a red-black tree based implementation
        // It provides an efficient means of storing key-value pairs in sorted order.
        TreeMap<Integer,String> tm = new TreeMap<Integer,String>();
        tm.put(100,"Amit");    
        tm.put(101,"Vijay");    
        tm.put(102,"Rahul"); 

        System.out.println(tm.toString());
        System.out.println(tm.values().toString());
        System.out.println(tm.ceilingKey(90));
        System.out.println(tm.floorKey(105));
        System.out.println(tm.getClass());
        System.out.println(tm.higherKey(90));
        System.out.println(tm.lowerKey(105));
        System.out.println(tm.descendingKeySet());
        System.out.println(tm.descendingMap());
        System.out.println(tm.navigableKeySet());
        System.out.println(tm.remove(102));
        System.out.println(tm.firstKey());
        System.out.println(tm.lastKey());
        System.out.println(tm.firstEntry());
        System.out.println(tm.lastEntry());
        System.out.println(tm.subMap(100, 102)); // submap from key 100 to 102, exclusive of 102.
        System.out.println(tm.headMap(101)); // headmap from key 100 to 101, exclusive of 101.
        System.out.println(tm.tailMap(101)); // tailmap from key 101 to end, inclusive of 101.

        
    }

    public static void mapDefault()
    {
        HashMap<String,ArrayList<String>> mp = new HashMap<>();
        String sort = "abc";
        // below doesn't work because the get doesn't return the arraylist after adding.
        // The error in the code is that the add() method of the ArrayList class returns a boolean value 
        // indicating whether the operation was successful or not
        //mp.put(sort,mp.getOrDefault(sort,new ArrayList()).add("bac"));

        /* Correct Way is below.
         * ArrayList<String> list = mp.getOrDefault(sort,new ArrayList());
            list.add("bac");
            mp.put(sort,list);
         */
    }

    /*
     * You are getting a ConcurrentModificationException because you are trying to modify the HashMap while iterating over it. 
     * To fix this issue, you can use an Iterator and its remove() method to safely remove elements from the HashMap while iterating. 
     * Here's a corrected version of your code:
     * 
     * Iterator<Map.Entry<Long,ArrayList<Character>>> iterator = hm.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long,ArrayList<Character>> me = iterator.next();
            Long t = me.getKey();
            if (t < (ts - windowtimesize)) {
                iterator.remove();
                windowsize -= me.getValue().size();
            }
        }


        The ConcurrentModificationException in the context of a HashMap usually occurs 
        when you modify the map (e.g., adding or removing entries) while iterating over 
        its elements using an iterator or enhanced for loop. This can happen if you modify 
        the map directly within the loop or if another thread modifies the map during the 
        iteration.
     */

    class RangeModule {
        // https://leetcode.com/problems/range-module/solutions/2904396/cleanest-easiest-to-understand-treemap/?envType=featured-list&envId=top-google-questions 
        TreeMap<Integer, Integer> m = new TreeMap<>();
        public RangeModule() {}
        
        public void addRange(int s, int e) { // s: start, e: end
            // find overlap ranges, calc merged range, clear overlapped ranges, insert merged range
            var L = m.floorEntry(s); // left possible overlap entry
            var R = m.floorEntry(e); // right possible overlap entry

            if (L != null && L.getValue() >= s) s = L.getKey(); // update overlap start
            if (R != null && R.getValue() > e) e = R.getValue(); // update overlap end

            m.subMap(s, e).clear(); // clear all overlapped entries
            m.put(s, e); // save final merged entry
        }
        
        public boolean queryRange(int s, int e) {
            var L = m.floorEntry(s);
            return L != null && L.getValue() >= e; // if there exist a range: start <+ s, end >= e
        }
        
        public void removeRange(int s, int e) {
            var L = m.floorEntry(s); // left possible overlap entry
            var R = m.floorEntry(e); // right possible overlap entry

            if (L != null && L.getValue() > s) m.put(L.getKey(), s); // after removal, if anything left
            if (R != null && R.getValue() > e) m.put(e, R.getValue()); // after removal, if anything left

            m.subMap(s, e).clear(); // removal
        }
    }
}
