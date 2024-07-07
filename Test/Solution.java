import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(Character c: t.toCharArray())
            hm.put(c, hm.getOrDefault(c,0)+1);
        int counter = hm.size();
        int begin=0,end=0,max=Integer.MAX_VALUE,head=0;
        while(end<s.length())
        {
            int tt = hm.get(s.charAt(end));
            tt--;
            if(tt == 0)
            {
                char key=s.charAt(end);
                hm.put(key,tt); 
                counter--;
            }
            while(counter == 0)
            {
                if(end-begin < max)
                    max = end - (head=begin);
                if(hm.get(s.charAt(begin))==0)
                {
                    hm.put(s.charAt(begin),hm.get(s.charAt(begin)++));
                    begin++;
                    counter++;
                }
            }
            end++;
        }
        return max == Integer.MAX_VALUE ? "" : s.substring(head,head+max);
    }
    
}