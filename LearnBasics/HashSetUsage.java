package LearnBasics;

import java.util.*;
import java.util.stream.Collectors;

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
        //HashSet does not provide any method to maintain the insertion order. Comparatively, LinkedHashSet maintains the insertion order 
        // of the elements.
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        lhs.add("Ashok");
        lhs.add("Raju");
        lhs.add("Gadhiraju");
        lhs.add("Ashok");
        //lhs.add("ashok");

        System.out.println(lhs.remove("rama"));

        System.out.println(lhs);
        
        Iterator<String> it = lhs.iterator();
        while(it.hasNext())
        {
            String str = it.next();
            System.out.println(str);
        }

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
        System.out.println(sts.subSet("raju","sita").toString());
        System.out.println(sts.ceiling("sita"));
        System.out.println(sts.ceiling("manu"));
        System.out.println(sts.floor("manu"));

        Addprimitivestohashset();
        check();
        
    }
    public static void Addprimitivestohashset()
    {
        int[] arr1 = new int[]{1, 4, 45, 6, 10, 8};
        HashSet<Integer> hs1 = new HashSet<>();
        hs1.addAll(Arrays.stream(arr1).boxed().collect(Collectors.toSet()));
        
        long[] a1 = {1,2,3,4};
        // Cannot use HashSet below for hs3 type as the return is to a Set from RHS.
        Set<Long> hs3 = Arrays.stream(a1).boxed().collect(Collectors.toSet());
    }
    public static void check()
    {
        HashSet<ArrayList<Integer>> hs = new HashSet<>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(3);al.add(1);al.add(2);
        hs.add(al);

        ArrayList<Integer> al1 = new ArrayList<Integer>();
        al1.add(1);al1.add(2);al1.add(3);

        ArrayList<Integer> al2 = new ArrayList<Integer>();
        al2.add(3);al2.add(1);al2.add(2);

        System.out.println(hs.contains(al1)); // false
        System.out.println(hs.contains(al2)); // true
    }
    public String isSubset( long a1[], long a2[], long n, long m) {
        
        HashSet<Long> hs1 = new HashSet<Long>();
        Set<Long> hs3 = Arrays.stream(a1).boxed().collect(Collectors.toSet());
        for(long x:a1)
            hs1.add(x);
        HashSet<Long> hs2 = new HashSet<Long>();
        for(long x:a2)
            hs2.add(x);
        hs1.retainAll(hs2);
        if(hs1.size()<Math.min(m,n))
            return "No";
        else
            return "Yes";
    }
}
