package Usage;

import java.util.Stack;

public class StackUsage {
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");
        Stack st = new Stack();

        st.push("1");
        st.push(5);
        st.push(false);

        System.out.println(st.peek());

        st.pop();

        System.out.println(st.peek());

        System.out.println(st.contains("1"));
        System.out.println(st.size());

        // generic stacks in java.

        Stack<Integer> st1 = new Stack<>();
        st1.push(5);
        st1.push(8);
        st1.pop();
        System.out.println(st1.peek());

    }

}
