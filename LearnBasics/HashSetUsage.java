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

        
        // if you just want to retrieve any first element from the set, you can use iterator.
        System.out.println(hs.iterator().next()); // returns any one element from the set, as it is unordered.
        
        
        // LINKED HASH SET has same interface methods as hash set , only diff is it used linked list rather than arraylist.
        //HashSet does not provide any method to maintain the insertion order. Comparatively, LinkedHashSet maintains the insertion order 
        // of the elements.
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        lhs.add("Ashok");
        lhs.add("Raju");
        lhs.add("Gadhiraju");
        lhs.add("Ashok");
        //lhs.add("ashok");

        System.out.println(lhs.getFirst());
        System.out.println(lhs.getLast());

        System.out.println(lhs.remove("rama"));

        System.out.println(lhs);
        
        Iterator<String> it = lhs.iterator();
        while(it.hasNext())
        {
            String str = it.next();
            System.out.println(str);
        }
        // System.out.println(lhs.subSet("raju", "sita")); // doesn't exist in LinkedHashSet, only in TreeSet.
        // System.out.println(lhs.headSet("ashok")); // doesn't exist in LinkedHashSet, only in TreeSet.
        // System.out.println(lhs.tailSet("ashok")); // doesn't exist in LinkedHashSet, only in TreeSet.

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
        System.out.println(sts.headSet("sita")); // returns all elements < "sita"
        System.out.println(sts.tailSet("rama")); // returns all elements >= "rama"
        System.out.println(sts.subSet("raju","sita")); // returns all elements >= "raju" and < "sita"
        System.out.println(sts.subSet("raju","sita").toString());
        System.out.println(sts.ceiling("sita")); // returns the least element >= "sita"
        System.out.println(sts.higher("sita")); // returns the least element > "sita"
        System.out.println(sts.floor("manu")); // returns the greatest element <= "manu"
        System.out.println(sts.lower("manu")); // returns the greatest element < "manu"


        Addprimitivestohashset();
        check();
        customObjectSetUsage();
        
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

        System.out.println(hs.contains(al1)); // false as the order is different.
        System.out.println(hs.contains(al2)); // true as the order is same.
    }
    public String isSubset( long a1[], long a2[], long n, long m) {
        
        HashSet<Long> hs1 = new HashSet<Long>();
        Set<Long> hs3 = Arrays.stream(a1).boxed().collect(Collectors.toSet());
        for(long x:a1)
            hs1.add(x);
        HashSet<Long> hs2 = new HashSet<Long>();
        for(long x:a2)
            hs2.add(x);
        hs1.retainAll(hs2); // intersect of 2 sets.
        if(hs1.size()<Math.min(m,n))
            return "No";
        else
            return "Yes";
    }
    static class Person1 {
        String name;
        Person1(String name) { this.name = name; }
    }

    static class Person {
        String name;
        Person(String name) { this.name = name; }
        
        // ✔ Ensures that objects are compared based on their content, not memory references.
        // ✔ Set uses equals() to avoid duplicate elements.
        // ✔ Map uses equals() to compare keys and check for existing entries.
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Person)) return false;
            Person p = (Person) obj;
            return name.equals(p.name);
        }
        
        // ✔ HashMap, HashSet, and HashTable use hashing to optimize storage and lookup.
        // ✔ Hashing is based on the hashCode() method, which should be consistent with equals().
        // hashcode() is used to determine the bucket location in the hash table.
        // ✔ If two objects are equal (equals() returns true), they must have the same hash code.
        // ✔ If two objects have the same hash code, they are not necessarily equal (hash collision).
        @Override
        public int hashCode() {
            return name.hashCode(); // Hash based on name value
        }

    }
    public static void customObjectSetUsage()
    {
        // ✔ Sets (HashSet) → Used to check whether an element already exists, ensuring uniqueness
        // Problem: Since equals() isn’t overridden, Java checks object references instead of values, leading to duplicates in Set.
        Set<Person1> people1 = new HashSet<>();
        people1.add(new Person1("Alice"));
        people1.add(new Person1("Alice")); // Duplicate?
        
        System.out.println(people1.size()); // ❌ Expected: 1, Got: 2 (incorrect!)

        Set<Person> people = new HashSet<>();
        people.add(new Person("Alice"));
        people.add(new Person("Alice")); // Duplicate?
        
        System.out.println(people.size()); // ✔ Expected: 1, Got: 1 (correct!)
        System.out.println(people.contains(new Person("Alice")));

        // ✔ Maps (HashMap, Hashtable) → Used to determine the bucket location for storing/retrieving keys efficiently.
        Map<Person, Integer> map = new HashMap<>();
        map.put(new Person("Alice"), 25);  // Uses hashCode() for bucket placement
        map.put(new Person("Bob"), 30);

        Integer num1 = 10;
        Integer num2 = 10;
        System.out.println(num1 == num2); // true, as both point to the same object in the Integer cache
        System.out.println(num1.equals(num2)); // true, as values are the same
        System.out.println(num1.hashCode() + " " + num2.hashCode()); // true, as both have the same hash code,  hashcode = 10. same as intValue
    }
}
