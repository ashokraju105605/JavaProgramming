// # Write a Time Limited Counter class that holds an expiring count for a given key press.
// # The expiration time window is defined when the class is constructed.  (for example, 300 milliseconds)
// # The functions that need to be implemented are:

// # 1. void press(key)
// # 2. int getCount(key)
// # 3. int getTotalCount()
// # Example:
// # Time Window: 300 milliseconds
// # +------------+--------------------+-----------------------------------------------------------+
// # | timestamp  |     operation      |                          result                           |
// # +------------+--------------------+-----------------------------------------------------------+
// # | 1647718624 | press(‘a’)         | -                                                         |
// # | 1647718630 | press(‘a’)         | -                                                         |
// # | 1647718730 | press(‘b’)         | -                                                         |
// # | 1647718730 | getCount(‘a’)     | 2                                                         |
// # | 1647718731 | getTotalCount()  | 3 (2 ‘a’ and 1 ‘b’)                                       |
// # | 1647718925 | getCount(‘a’)     | 1 (‘a’ at timestamp 1647718925 - 1647718624 = 301 is out of the time window) |
// # | 1647718925 | getTotalCount()  | 2 (1 ‘a’ and 1 ‘b’)                                       |
// # +------------+--------------------+-----------------------------------------------------------+ (edited) 


import java.io.*;
import java.util.*;

// Main class should be named 'Solution' and should not be public.
class Solution {
    //System.currentTimeMillis()
    Long ts = 0L;
    LinkedHashMap<Long, ArrayList<Character>> hm = new LinkedHashMap<>();
    int windowsize;
    int windowtimesize;
    
    public static void main(String[] args) {
        System.out.println("Hello, World");
        
    Solution tc = new Solution(300);
    tc.ts = 1647718624L;
    tc.press('a');
    
    tc.ts = 1647718630L;
    tc.press('a');
    
    tc.ts = 1647718730L;
    tc.press('b');
    
    tc.ts = 1647718730L;
    System.out.println(tc.getCount('a'));
    
    tc.ts = 1647718731L;
    System.out.println(tc.getTotalCount());
    
    tc.ts = 1647718925L;
    System.out.println(tc.getCount('a'));
    
    tc.ts = 1647718925L;
    System.out.println(tc.getTotalCount());
        
    }
    Solution(int x)
    {
        windowtimesize = x;
    }
    public void press(Character c)
    {
        if(!hm.containsKey(ts))
        {
            ArrayList<Character> al = new ArrayList<>();
            hm.put(ts,al);
        }
        hm.get(ts).add(c);
        windowsize++;
        
        // code to remove stale time keys.
        /*
        for(Map.Entry<Long,ArrayList<Character>> me: hm.entrySet())
        {
            Long t = me.getKey();
            if(t < (ts - windowtimesize))
            {
                hm.remove(t);
                windowsize -= me.getValue().size();
            }
        }
        */
         
        Iterator<Map.Entry<Long, ArrayList<Character>>> it = hm.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Long, ArrayList<Character>> ent = it.next();
            Long t = ent.getKey();
            if(t < (ts - windowtimesize))
            {
                it.remove();
                windowsize -= ent.getValue().size();
            }
            
        }
        
    }
    public int getCount(Character k)
    {
        int count = 0;
        
        // code to remove stale time keys.
        /*
        for(Map.Entry<Long,ArrayList<Character>> me: hm.entrySet())
        {
            Long t = me.getKey();
            if(t < (ts - windowtimesize))
            {
                hm.remove(t);
                windowsize -= me.getValue().size();
            }
        }
        */
        
        Iterator<Map.Entry<Long, ArrayList<Character>>> it = hm.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Long, ArrayList<Character>> ent = it.next();
            Long t = ent.getKey();
            if(t < (ts - windowtimesize))
            {
                it.remove();
                windowsize -= ent.getValue().size();
            }
            
        }
        
        // get the proper count after the stale keys removal.
        for(Map.Entry<Long, ArrayList<Character>> me: hm.entrySet())
        {
            ArrayList<Character> al = me.getValue();
            for(Character c: al)
            {
                if(c==k)
                    count++;
            }
        }
        return count;
    }
    public int getTotalCount()
    {
        return windowsize;
    }
    static class Counter
    {
        Long timestamp;
        Character x;
    }
}
