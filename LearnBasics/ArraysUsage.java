package LearnBasics;

import java.util.*;

public class ArraysUsage {

    static class Person{
        String name;
        int age;
        public Person(String s, int a)
        {
            this.name = s;
            this.age = a;
        }
    }
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");

        int[] arr = new int[5];
        arr[0] = 10;
        int[] arr1 = { 1, 2, 3, 4, 5 };

        // Below throwing exception
        //Integer[] subarr1 = Arrays.asList(arr).subList(2, 4).toArray(new Integer[0]);
        //System.out.println(Arrays.toString(subarr1));
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr1, 1, 3)));

        // int[] a1 = new int[5];
        // int[] a2 = new int[4] { 1, 2, 3, 4 }; // doesn't work in java
        int[] arr3 = new int[] { 180, 60, 100, 120 };

        Arrays.sort(arr3);  // [60, 100, 120, 180]

        System.out.println(arr3); // doesn't print array
        System.out.println(Arrays.toString(arr)); //print array
        System.out.println(arr3.length);


        System.out.println(Arrays.binarySearch(arr3, 20));
        System.out.println(Arrays.binarySearch(arr3, 70));
        System.out.println(Arrays.binarySearch(arr3, 190));
        System.out.println(Arrays.binarySearch(arr3, 120));

        Arrays.fill(arr, -1);
        System.out.println(Arrays.toString(arr));

        // String[] test;

        System.out.println();

        for (int x : arr1) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        int[][] intArray = { { 1, 2, 3 }, { 4, 5 } };
        System.out.println(Arrays.deepToString(intArray));

        String[] animals = { "Cat", "Alligator", "Fox", "Donkey", "Bear", "Elephant", "Goat" };
        Arrays.sort(animals, 0, 3); // start inclusive, end exclusive in java per convention.
        System.out.println(Arrays.toString(animals));

        // System.out.println("%s", String.join(", ", animals)); // --doesn't work like
        // this

        String s = String.format("%s", String.join(", ", animals));
        System.out.println(s);

        int[] t = Arrays.copyOf(arr, 10);
        System.out.println(Arrays.toString(t));


        Person p[] = { new Person("samir", 20),
                       new Person("anil", 25), new Person("amit", 10),
                       new Person("rohit", 17), new Person("Geek5", 19),
                       new Person("sumit", 22), new Person("gourav", 24),
                       new Person("sunny", 27), new Person("ritu", 28) };
        Arrays.setAll(p, e -> {
            if(p[e].age < 18)
                return new Person("Teenager", p[e].age);
            else
                return new Person(p[e].name, p[e].age);
        });

        Arrays.stream(p).forEach( e -> System.out.println(e.name + " " + e.age));

        
    }
}