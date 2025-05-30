package LearnBasics;

import java.util.*;

public class BitSetUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");

        BitSet bs1 = new BitSet();
        BitSet bs2 = new BitSet(6);

        bs1.set(0);

        bs2.set(4);
        bs2.set(6);
        bs2.set(5);

        System.out.println(bs1);
        System.out.println(bs2);

        BitSet bs3 = new BitSet();
        bs3 = (BitSet) bs2.clone();

        System.out.println(bs3.cardinality()); // returns number of bits set to true
        System.out.println(bs3.size()); // return numbers of bits of space.

        bs3.set(79); // can set out of index bits as well, which is not the case with arraylist.

        System.out.println(bs3.cardinality());
        System.out.println(bs3.size());

        bs2.clear(5);

        bs2.clear(4,6);

        bs2.clear();

        System.out.println(bs1.length()); // returns the number of bits set to true in bs1

        bs1.xor(bs3);

        System.out.println(bs3.get(1,6)); // returns the subset of bits from 1 to 6 (exclusive)

        bs3.flip(4);

        System.out.println(bs3.isEmpty());
    }
}
