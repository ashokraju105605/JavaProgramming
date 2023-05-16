package LearnBasics;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        
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
    }
}
