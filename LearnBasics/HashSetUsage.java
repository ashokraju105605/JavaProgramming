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
        System.out.println(); 

        
        
        
        
        // LINKED HASH SET has same interface methods as hash set , only diff is it used linked list rather than arraylist.
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        lhs.add("Ashok");
        lhs.add("Raju");
        lhs.add("Gadhiraju");

        System.out.println(lhs.remove("rama"));

        System.out.println(lhs);
        


        // TREE SET gives unique advantage that it can provide the floor , ceil, headset, tailset methods due to its sorted order of contents.
        TreeSet<String> sts = new TreeSet<String>(); // if you use SortedSet for the sts type, then you will lose ceiling, floor methods.
        sts.add("ashok");
        sts.add("raju");
        sts.add("rama");
        sts.add("sita");
        sts.add("laxman");

        System.out.println(sts.contains("rama"));
        System.out.println(sts.first());
        System.out.println(sts.toString());
        System.out.println(sts.last());
        System.out.println(sts.headSet("sita"));
        System.out.println(sts.tailSet("rama"));
        System.out.println(sts.ceiling("sita"));
        System.out.println(sts.ceiling("manu"));
        System.out.println(sts.floor("manu"));
        
    }
}
