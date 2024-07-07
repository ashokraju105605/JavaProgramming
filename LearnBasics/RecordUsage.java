package LearnBasics;

import java.util.*;

public class RecordUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        check();
    }
    // just a data carrying class, like tuple in C#.
    // only valid from java 10 or higher.
    record Node(int i, String s){};
    public static void check()
    {
        ArrayList<Node> al = new ArrayList<>();
        al.add(new Node(2,"ashok"));
        Node t1 = new Node(5,"abc");
        System.out.println(t1.i);
        System.out.println(t1.s);

        System.out.println(al.get(0).i);
        System.out.println(al.get(0).s);
        var t = 100;
    }
}

class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, j = 0, ans = 0, countz = 0;
        while (j < nums.length) {
            if (nums[j++] == 0) {
                countz++;
            }
            while (countz > 1) {
                if (nums[i] == 0) {
                    countz--;
                }
                i++;
            }
            ans = Math.max(ans, j - i - 1);
        }
        return ans;
    }
}
