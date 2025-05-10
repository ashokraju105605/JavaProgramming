package InterviewQs;

import java.util.*;
import java.util.stream.Stream;
class StreamRandomSelect {
    static int selectRandom(Stream<Integer> stream) {
        Random rand = new Random();
        int result = -1;
        int count = 0;

        for (int num : (Iterable<Integer>) stream::iterator) {
            count++;
            // if k element sampling then selected random index should be 0 to k-1
            if (rand.nextInt(count) == 0) { // Probability of replacement: 1/count
                result = num;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // Example usage
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        int randomElement = selectRandom(stream);
        System.out.println("Randomly selected element: " + randomElement);
    }
}
/*
 * ✔ Time Complexity: O(n) (linear pass through stream) ✔ Space Complexity: O(1) (only one stored value)
 * selects a random element from a stream of integers using reservoir sampling and uniform probability.
 */