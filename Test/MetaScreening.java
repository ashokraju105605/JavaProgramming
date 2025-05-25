import java.util.*;
public class MetaScreening {
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");
        String str = "2 + 5 + [ 3 + [ 5 + 6 ] + 10 ] + 4";
        System.out.println("Result: " + evaluateExpression(str));
    }
    // if there is only one kind of operator below processing works , as no precedence using monotonic stack is required.
    // if there are multiple operators, we need to use a stack to handle precedence.
    static int evaluateExpression(String str) {
        String[] tokens = str.split(" ");
        int currentSum = 0;
        int depth = 1; // Start with depth 1 to account for the outermost brackets

        for (String token : tokens) {
            if (token.equals("+")) {
                continue; // Skip the '+' operator
            } else if (token.equals("[")) {
                depth++;
            } else if (token.equals("]")) {
                depth--;
            } else {
                currentSum += depth * Integer.parseInt(token); // Add the number to the current sum
            }
        }

        return currentSum; // Return the total sum
    }
}
// 11 + 26 + 33 // 70