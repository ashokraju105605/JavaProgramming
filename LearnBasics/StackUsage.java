package LearnBasics;

import java.util.*;

public class StackUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        Stack<Integer> s = new Stack<Integer>();
        s.add(5);
        s.add(6);
        s.add(7);

        s.push(8);

        System.out.println(s.pop());
        System.out.println( s.capacity());
        System.out.println(s.contains(7));
        System.out.println(s.empty());
        System.out.println(s.indexOf(6));
        System.out.println(s.indexOf(8));
        System.out.println(s.size());
        System.out.println(s.toString());
        s.stream().forEach(System.out::println);
        System.out.println(s.peek());
        
        Stack<String> s2 = new Stack<>();

        System.out.println(s2.push("ashok"));
    }
}
