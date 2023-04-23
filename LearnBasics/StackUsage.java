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
        System.out.println(s.isEmpty());
        System.out.println(s.toString());
        s.stream().forEach(System.out::println);
        System.out.println(s.peek());
        
        Stack<String> s2 = new Stack<>();

        System.out.println(s2.push("ashok"));

        Stack<Integer> stk = new Stack<Integer>();
        stk.push(3);
        stk.push(2);
        stk.push(1);
        Integer[] arr5 = stk.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr5));
        testing();
    }
    public static void testing()
    {
        Stack<Integer> st = new Stack<Integer>();

        // will have java.util.EmptyStackException.
        System.out.println(st.pop());

    }
}
