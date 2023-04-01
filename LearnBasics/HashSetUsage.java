package LearnBasics;

import java.util.*;

public class HashSetUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        HashSet<String> hs = new HashSet<String>();
        hs.add("Ashok");
        hs.add("Raju");
        hs.add("Gadhiraju");
        System.out.println(hs.add("Ananya"));
        System.out.println(hs.contains("ananya"));
        System.out.println(hs.isEmpty());
        System.out.println(hs.size());
        System.out.println(Arrays.toString(hs.toArray()));
        HashSet<String> hs2 = new HashSet<String>();
        hs2.add("rama");hs2.add("sita");hs2.add("Laxman");
        hs.addAll(hs2);   // UNION of 2 sets into first set.
        hs.remove("Raju");
        //System.out.println(hs.get(2)); -- not possible as this is unordered list using hashing
        System.out.println(hs.toString());

        hs.retainAll(hs2); // INTERSECT of set.
        System.out.println(hs.toString());

        hs.removeAll(hs2); //SUBTRACT all elements of set 2 from set 1
        System.out.println(hs); 

        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        lhs.add("Ashok");
        lhs.add("Raju");
        lhs.add("Gadhiraju");

        System.out.println(lhs.remove("rama"));

        System.out.println(lhs);
    }
}
