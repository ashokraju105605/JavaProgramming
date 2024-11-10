package JavaSyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListLearn {
    public static void main(String[] args) {

        System.out.println(
            "Jai Shree Ram");

        // ArrayList: Uses a dynamic array to store elements. It resizes when the array becomes full by creating a new array and copying elements over.
        // Insertion/Deletion	O(n) in middle, go with LinkedList if more insertions/deletions. as it is O(1) in LL.

        // Create, Init, Read, Update, Delete, Count, Search, Iterate, Comparision, Conversion, Print, Specifics.

         // Create
        List<Integer> al = new ArrayList<>();
        List<Integer> al1 = Arrays.asList(-9, -18, 0, 25, 4); // fixed list but mutable
        List<Integer> al2 = List.of(1,2,3,4,5); // fixed and immutable.
        List<Integer> number = Arrays.asList(2,3,4,5);
        ArrayList<Integer> al3 = new ArrayList<>();
        ArrayList<Integer> al4 = new ArrayList<>();
        List<String> list3 = Arrays.asList("3", "6", "8", "14", "15");
        


        // Init
        al.add(3);
        al.addAll(al1);
        al3.addFirst(1);
        al3.addLast(2); 
        al4.add(1);al4.add(2); al4.add(3);
        al4.add(2,23);  // INSERT AT 2, shift the rest to right.
        // al4[3]; // Can't access like this, though underlying array is used dynamically.

        // Read
        Integer element = al.get(1);
        al.getFirst();
        al.getLast();
        //al.getOrDefault(5, 0); -- doesn't exist

        // Update
        Integer previous = al.set(1, 5);
        
        // Delete
        al.remove(5);
        al.removeFirst();
        al.removeLast();
        // non existing element removal will be index out of bounds exception
        //Integer removed = al.remove(al.indexOf(3));

        // Count
        int size = al.size();
        boolean empty = al.isEmpty();

        // Search
        boolean exists = al.contains(3);
        int index = al.indexOf(3);

        // Iterate
        Iterator<Integer> it = al.iterator();
        if(it.hasNext())
        {
            Integer item = it.next();
            it.remove(); // will not cause ConcurrentModificationException
        }
        
        for( int i=0;i<al.size();i++)
        {
            System.out.println(al.get(i));
        }

        for(String s: list3)
        {
            System.out.println(s);
        }

        al3.forEach(s -> System.out.println(s));

        // Comparision
        boolean equals = al3.equals(al4);
        // Collections.equals() -- doesn't have this.

        // Conversion
        String alstr = al.toString();

        // Print
        System.out.println(al);

        // Specifics
        al.sort(null);
        al.sort(Comparator.comparing(Integer::intValue).reversed());
        al.sort(Comparator.reverseOrder());
        System.out.println(al.toArray());
        al.stream().sorted().forEach(System.out::println);
        System.out.println(Arrays.toString(al.toArray()));
        System.out.println(al.isEmpty());
        List<Integer> square = number.stream().map(x -> x*x).collect(Collectors.toList());
        int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
        Collections.sort(al);
        Collections.binarySearch(al, 3);
        al.subList(0,3);
        list3.stream().mapToInt(num -> Integer.parseInt(num))
        .filter(num -> num % 3 == 0)
        .forEach(System.out::println);
        al.removeAll(al1); // Removes all elements from this list that are contained in the specified collection (optional operation).
        al.retainAll(al3); // Retains only the elements in this list that are contained in the specified collection (optional operation).
        al.clear(); // Removes all of the elements from this list (optional operation).
        al.addAll(al1); 
        System.out.println(Collections.max(al1));
        System.out.println(Collections.min(al1));
        Collections.fill(al1, -1);
        // Arrays.fill(al1,-1); -- works only for primitives.
        Collections.shuffle(al1);
    }
}
