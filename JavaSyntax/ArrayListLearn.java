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

        // Create, Init, Read, Update, Delete, Count, Search, Iterate, Comparision, Conversion, Print, Specifics.

         // Create
        List<Integer> al = new ArrayList<>();
        List<Integer> al1 = Arrays.asList(-9, -18, 0, 25, 4);
        List<Integer> number = Arrays.asList(2,3,4,5);
        ArrayList<Integer> al3 = new ArrayList<>();
        ArrayList<Integer> al4 = new ArrayList<>();
        List<String> list3 = Arrays.asList("3", "6", "8", "14", "15");
        


        // Init
        al.add(3);
        al.addAll(al1);
        al3.add(1);al3.add(2); al3.add(3);
        al4.add(1);al4.add(2); al4.add(3);

        // Read
        Integer element = al.get(1);
        //al.getOrDefault(5, 0); -- doesn't exist

        // Update
        Integer previous = al.set(1, 5);
        
        // Delete
        al.remove(5);
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

        // Conversion
        String alstr = al.toString();

        // Print
        System.out.println(al);

        // Specifics
        al.sort(null);
        al.sort(Comparator.comparing(Integer::intValue).reversed());
        al.sort(Comparator.reverseOrder());
        al.stream().sorted().forEach(System.out::println);
        System.out.println(Arrays.toString(al.toArray()));
        System.out.println(al.isEmpty());
        List<Integer> square = number.stream().map(x -> x*x).collect(Collectors.toList());
        int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
        Collections.sort(al);
        list3.stream().mapToInt(num -> Integer.parseInt(num))
        .filter(num -> num % 3 == 0)
        .forEach(System.out::println);
    }
}
