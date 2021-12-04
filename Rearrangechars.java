import java.util.Comparator;
import java.util.PriorityQueue;

class Key {
    char c;
    int freq;

    public Key(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}

class KeyComparator implements Comparator<Key> {
    public int compare(Key k1, Key k2) {
        if (k2.freq > k1.freq)
            return 1;
        else if (k1.freq > k2.freq)
            return -1;
        else
            return 0;
    }
}

public class Rearrangechars {
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");
        String str = "bbbaa";
        String str1 = "aaba";
        Rearrangechars rc = new Rearrangechars();
        rc.rearrange(str);
        rc.rearrange(str1);
    }

    void rearrange(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        PriorityQueue<Key> maxHeap = new PriorityQueue<Key>(new KeyComparator());
        for (char i = 'a'; i <= 'z'; i++) {
            int val = i - 'a';
            if (count[val] > 0)
                maxHeap.offer(new Key(i, count[val]));
        }
        Key prev = new Key('#', 0);
        String result = "";
        while (maxHeap.size() != 0) {
            Key top = maxHeap.peek();
            maxHeap.poll();

            result += top.c;
            top.freq--;

            if (prev.freq != 0)
                maxHeap.offer(prev);

            prev = top;
        }
        if (result.length() != str.length()) {
            System.out.println(" Not Possible");
        } else {

            System.out.println(result);
        }

    }
}

/**
 * key things to note. string indexing doesn't work like str[i] in java like in
 * C# char types can only be subtracted to get the int value, addition is having
 * issues. forgot to add the final results length check, which is again a
 * failure.
 */