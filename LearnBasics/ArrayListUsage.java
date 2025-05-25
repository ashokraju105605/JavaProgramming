package LearnBasics;


import java.util.*;
import java.util.stream.Collectors;

import java.io.*;
// import java.lang.Integer // java.lang is imported implicitly.

public class ArrayListUsage {
    // Create, Init, Read, Update, Delete, Count, Search, Iterate, Comparision, Conversion, Specifics.
    public static void usage(){
        // Create
        List<Integer> al = new ArrayList<>();
        List<Integer> al1 = Arrays.asList(-9, -18, 0, 25, 4); // Immutable list, cannot add or remove elements.
        // List<Integer> al2 = new ArrayList<>(al1); // This will create a mutable copy of the immutable list.
        List<Integer> number = Arrays.asList(2,3,4,5);
        ArrayList<Integer> al3 = new ArrayList<>();
        ArrayList<Integer> al4 = new ArrayList<>();
        List<String> list3 = Arrays.asList("3", "6", "8", "14", "15");
        //List<int> list4 = new ArrayList<>(); // Commented out as it is incorrect syntax.
        // because collections store objects, and primitive types are not objects.
        // Java generics (<>) only accept reference types, meaning List<int> is invalid.

        // Init
        al.add(3);
        al.addAll(al1);
        al3.add(1);al3.add(2); al3.add(3);
        al4.add(1);al4.add(2); al4.add(3);
        al4.add(0,3); //insert into middle of dynamic array, 
        //all elements till end will be shifted to right, costly operation/depends.

        // Read
        Integer element = al.get(1);
        //al.getOrDefault(5, 0); -- doesn't exist

        // Update
        Integer previous = al.set(1, 5);
        
        // Delete
        al.remove(5); // all elements till end will be shifted to left, costly operation/depends.
        // non existing element removal will be index out of bounds exception
        //Integer removed = al.remove(al.indexOf(3));
        al.removeIf(x-> (x==3)); // remove all occurrences of 3

        // Count
        int size = al.size();
        boolean empty = al.isEmpty();

        // Search
        boolean exists = al.contains(3);
        int index = al.indexOf(3); // returns -1 if not found

        // Iterate -- use this to avoid ConcurrentModificationException
        Iterator<Integer> it = al.iterator();
        if(it.hasNext())
        {
            Integer item = it.next();
            it.remove();
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

        // Specifics
        al.sort(null);
        al.sort(Comparator.comparing(Integer::intValue).reversed());
        al.sort(Comparator.reverseOrder());
        al.sort(Collections.reverseOrder()); // both does the same thing. internally calls comparator.reverseOrder()
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
    public static void main(String[] args)
    {
        usage();
        testing();
        //testing1();
        testing2();
        arrayStreamReduceTest();
        List<Integer> list1 = Arrays.asList(-9, -18, 0, 25, 4);
        list1.stream().sorted().forEach(System.out::println);
        ArrayList<String> al = new ArrayList<String>();
        System.out.println("Jai Shree Ram");
        al.add("ashok");
        System.out.println(al.size());
        al.add("raju");
        System.out.println(Arrays.toString(al.toArray()));
        ArrayList<String> al2 =  new ArrayList<String>();
        al2.add("Gadhiraju");
        al.addAll(2, al2);
        System.out.println(Arrays.toString(al.toArray()));
        System.out.println(al.isEmpty());
        System.out.println(al.contains("Gadhiraju"));
        System.out.println(al.get(2));
        System.out.println(al.indexOf("Gadhiraju"));
        System.out.println(al.set(1, "Raju"));
        System.out.println(Arrays.toString(al.toArray()));
        System.out.println(al.remove(1));
        System.out.println();

        // IF int is used for also the data, then remove will always take it as index, so use wrapper classes for data elements, instead of primitives.
        al.remove("5");
        System.out.println(Arrays.toString(al.toArray()));

        // Creating a list of Strings
        List<String> list3 = Arrays.asList("3", "6", "8", 
        "14", "15");

        // create a list of integers
        List<Integer> number = Arrays.asList(2,3,4,5);
    
        // demonstration of map method
        List<Integer> square = number.stream().map(x -> x*x).
                            collect(Collectors.toList());
        System.out.println(square);
            // demonstration of reduce method
            int even =
            number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);

        System.out.println(even);

        // Using Stream mapToInt(ToIntFunction mapper)
        // and displaying the corresponding IntStream
        list3.stream().mapToInt(num -> Integer.parseInt(num))
        .filter(num -> num % 3 == 0)
        .forEach(System.out::println);

        RelativeSorting();

        Iterator<String> it = al.iterator();

        while(it.hasNext())
            System.out.println(it.next());

        for(String t: al)
        {
            System.out.println(t);
        }
        al.add("Ananya");
        System.out.println(al.toString());
        Collections.sort(al);// Sorting method for ArrayList.
        System.out.println(al.toString());

        Student s1=new Student(101,"Rama",23);  
        Student s2=new Student(102,"Sita",21);  
        Student s3=new Student(103,"Laxmana",25); 
        ArrayList<Student> al3=new ArrayList<Student>();  
        al3.add(s1);//adding Student class object  
        al3.add(s2);  
        al3.add(s3); 

        for( int i=0;i<al3.size();i++)
        {
            System.out.println(al3.get(i).name);
        }

        for(Student s: al3)
        {
            System.out.println(s.name + " " + s.age + " " + s.rollno);
        }

        al3.forEach(s -> System.out.println(s.name + "-- " + s.age + "-- " + s.rollno));


        try  
        {  
            //Serialization  
            FileOutputStream fos=new FileOutputStream("file");  
            ObjectOutputStream oos=new ObjectOutputStream(fos);  
            oos.writeObject(al);  
            fos.close();  
            oos.close();  
            //Deserialization  
            FileInputStream fis=new FileInputStream("file");  
            ObjectInputStream ois=new ObjectInputStream(fis);  
            ArrayList<String>  list = (ArrayList<String>) ois.readObject();
            ois.close();
            fis.close();  
            System.out.println(list);    
        }catch(Exception e)  
        {  
            System.out.println(e);  
        } 

        testequals();

    }

    static class Student{  
        int rollno;  
        String name;  
        int age;  
        Student(int rollno,String name,int age){  
         this.rollno=rollno;  
         this.name=name;  
         this.age=age;  
        }  
    } 
    static void RelativeSorting()
    {
        int A1[] = { 2, 1, 2, 5, 7, 1, 9, 9, 3, 6, 8, 8 };
        int A2[] = { 2, 1, 8, 3, 1 };
        int m = A1.length;
        int n = A2.length;
        // HashMap to store the indices of elements in
        // the second array
        HashMap<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // Consider only first occurrence of element
            if (!index.containsKey(A2[i]))
                // Assign value of i+1
                index.put(A2[i], i + 1);
        }
        int[] tmp
        = Arrays.stream(A1)
                  .boxed()
                  .sorted((p1, p2) -> {
                      int idx1 = index.getOrDefault(p1, 0);
                      int idx2 = index.getOrDefault(p2, 0);

                      // If both p1 and p2 are not present
                      // in the second array,
                      // sort them in ascending order
                      if (idx1 == 0 && idx2 == 0)
                          return p1 - p2;

                      // If only p2 is present in the second
                      // array, p2 comes before p1
                      if (idx1 == 0)
                          return 1;

                      // If only p1 is present in the second
                      // array, p1 comes before p2 (no swap)
                      if (idx2 == 0)
                          return -1;

                      // If both p1 and p2 are present in
                      // the second array, sort them
                      // according to their respective
                      // indices
                      return idx1 - idx2;
                  })
                  .mapToInt(i -> i)
                  .toArray();
                          // Sorted values are copied to the original
        // array
        for (int i = 0; i < m; i++) {
            A1[i] = tmp[i];
        }
        System.out.println(Arrays.toString(A1));
    }
    static void testing()
    {
        ArrayList<Integer> al = new ArrayList<Integer>(){};
        al.add(1);
        System.out.println(al.get(0));
        //al.set(1,al.get(0));

        int A1[] = { 2, 1, 2, 5, 7, 1, 9, 9, 3, 6, 8, 8 };
        ArrayList<Integer> atl = new ArrayList<Integer>();
        
        Arrays.stream(A1).boxed();

        ArrayList<ArrayList<Integer>> alll = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        alll.add(list);

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,2,3));
        System.out.println(alll.contains(list1));

        System.out.println(alll.size());

    }
    static void ArraydqTesting()
    {
        Deque<Long> q = new ArrayDeque<Long>();

        q.descendingIterator();
    }
    public static void testing1()
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(4);
        // al[0] -- WRONG.
        System.out.println(); // cannot read an element like this.
        System.out.println(al.get(0));
        System.out.println(al.indexOf(4));
        // Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
        //System.out.println(al.set(1, 5));
        
        // Can only set elements that are in the list.
        
        System.out.println(al.set(0,8));
        System.out.println(al.get(0));
        // be careful with primitive data types on arraylist as remove(int index) and remove(object o) can both be same with int.
       
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<Integer>());
        adj.get(0).add(1,3);  

        

    }
    public static void testing2()
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(0,2); // insert
        System.out.println(al.get(0));
        
        al.set(0,5); // update
        System.out.println(al.get(0));
        //al.remove(7); // problem as the remove is multiplexed, between index and also object.
                            // so avoid arraylist of integers.
        /*if you want to remove object check contains first and then remove */
        al.add(7);
        
        al.remove(al.indexOf(7));
        al.remove(1);
        System.out.println(al.toString());
    }
    public static void arrayStreamReduceTest()
    {
        // String array
        String[] array = { "test", "with", "temp" };

        // The result of the reduce() method is
        // an Optional because the list on which
        // reduce() is called may be empty.
        Optional<String> String_combine = Arrays.stream(array)
                                            .reduce((str1, str2) -> str1 + "-" + str2);
    
        // Displaying the combined String
        if (String_combine.isPresent()) {
            System.out.println(String_combine.get());
        
        }
    }
    public static void testequals()
    {
        // used for comparing list of elements into an array(array(int))
        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(1);al1.add(2); al1.add(3);

        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(1);al2.add(3); al2.add(2);

        if(al1.equals(al2))
            System.out.println("EQUALS"); // if order and elements are same, then equals will return true.
        else
            System.out.println("NOT EQUALS"); // if order or elements are not same, then equals will return false.
    }
}
