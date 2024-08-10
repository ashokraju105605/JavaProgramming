package JavaSyntax;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class StackLearn {
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");

        // Create, Init, Read, Update, Delete, Count, Search, Iterate, Comparision, Conversion, Print, Specifics.
    
        // Create
        Stack<String> stack = new Stack<String>();
        stack.push("Ashok");
        stack.push("Raju");
        stack.push("Gadhiraju");

        // Init
        stack.push("test");
        stack.push("temp");

        // Read
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.get(2));

        // Update
        // No Update of elements on stack.

        // Delete
        System.out.println(stack.remove(2));

        // Count
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());

        // Search
        System.out.println(stack.contains("raju"));
        System.out.println(stack.search("raju"));

        // Iterate
        Iterator<String> it = stack.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        stack.forEach(System.out::println);

        // Comparision
        Stack<String> stack2 = new Stack<String>();
        stack2.push("Ashok");
        stack2.push("Raju");
        stack2.push("test");
        System.out.println(stack.equals(stack2));

        // Conversion
        String[] strArr = stack.toArray(new String[0]);

        // Print
        System.out.println(stack);
        System.out.println(Arrays.toString(strArr));
        System.out.println(String.join("," , strArr));

        // Specifics
        System.out.println(stack.search("Raju"));
        // Stack is a Last In First Out (LIFO) Data Structure.
    }
}
