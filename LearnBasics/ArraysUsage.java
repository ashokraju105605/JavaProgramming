package LearnBasics;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public static void usage(){
        // Create, Init, Read, Update, Delete, Count, Search, Iterate, Comparision, Conversion, Specifics.

        // Create
        int[] arr = {5,4,3,2,1};
        int[] arr1 = new int[]{1,2,3,4,5}; // cannot give dimention when initialization is provided
        int[] nums = {1,2,3,4,5};
        int[] arr2 = arr.clone(); // shallow copy, not deep copy.
        int[] arr3 = new int[5]; // default values are 0 for int, false for boolean, null for object.
        int[][] mat = {{0,0,0},{1,1,1}};

        // Init
        Arrays.fill(arr1, -1);
        int [][] dp=mat.clone();

        // Read
        int x = arr[2];

        // Update
        arr[2] = 8;

        // Delete
        // not possible as fixed structure container. similarly nothing like insert in array.

        // Count
        int len = arr.length;

        // Search
        boolean found = Arrays.stream(arr1).anyMatch(t -> t == 5);

        // Iterate
        for(int i=0; i<arr.length; i++)
            System.out.println(arr[i]);
        for( int a: arr)
        {
            System.out.println(a);
        }
        Arrays.stream(arr).forEach(System.out::println);

        // Comparision
        Arrays.equals(arr1, arr2);

        // Conversion
        String[] str = Arrays.stream(arr1).mapToObj(String::valueOf).toArray(String[]::new);
        int[] arr7 = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        //Specifics
        int[] arr4 = Arrays.copyOfRange(arr1, 1, 3);
        int[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Arrays.sort(arr5);
        Arrays.sort(arr,0,2);
        List<Integer> arrList = Arrays.stream(arr1).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(Arrays.toString(arr));
        int max = Arrays.stream(arr1).max().getAsInt();
        int min = Arrays.stream(arr1).min().getAsInt();
        int sum = Arrays.stream(arr1).sum();
        Double avg = Arrays.stream(arr1).average().getAsDouble();
        int index = Arrays.binarySearch(arr1,4);
        System.out.println(Arrays.deepToString(dp));
    }
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");

        // Learn all the below operations on any data structure to be proficient in the language
        //  Create, Init , Read, Update , Delete , Search, Navigate, BulkCopy, Count, Conversions

        usage();
        int[] arr = new int[5];
        arr[0] = 10;
        int[] arr1 = { 1, 2, 3, 4, 5 };
        Integer[] arr2 = {1,2,3,4,5};
        arr2[1] = new Integer(4);

        int [] nums = {1,2,3,4,5};
        int sum = Arrays.stream(nums).sum();
        System.out.println(sum);

        Collections.reverse(Arrays.asList(arr1));
        System.out.println(Arrays.asList(arr1)); // doesn't reverse

        List<Integer> arrList = Arrays.stream(arr1).boxed().collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(arrList); // works

        String[] str = {"ashok","raju","gadhiraju"};
        Collections.reverse(Arrays.asList(str));
        System.out.println(String.join(" ",str)); //works.

        Collections.reverse(Arrays.asList(arr2));
        System.out.println(Arrays.asList(arr2)); // REVERSES, works
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

        Predicate<Integer> pred = (x) -> x > 10;
        boolean temp = pred.test(5);
        temp = pred.test(15);

        System.out.println(Arrays.binarySearch(arr3, 20));
        System.out.println(Arrays.binarySearch(arr3, 70));
        System.out.println(Arrays.binarySearch(arr3, 130));
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
        // have more control on previous and next items while traversing the current element.
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        int[][] intArray = { { 1, 2, 3 }, { 4, 5 } };
        System.out.println(Arrays.deepToString(intArray));

        String[] animals = { "Cat", "Alligator", "Fox", "Donkey", "Bear", "Elephant", "Goat" };
        Arrays.sort(animals, 0, 3); // start inclusive, end exclusive in java per convention.
        Arrays.sort(animals,(String a1, String b1) -> a1.compareTo(b1));
        System.out.println(Arrays.toString(animals));

        // System.out.println("%s", String.join(", ", animals)); // --doesn't work like
        // this

        String s = String.format("%s", String.join(", ", animals));
        System.out.println(s);

        int[] t = Arrays.copyOf(arr, 10); // copyOf will create a new array of size 10 and copy the elements of arr to it.
        // The new array will be initialized with 0s for the remaining elements.
        // Best Use Case: When you need to resize an array (increase or decrease length).

        System.out.println(Arrays.toString(t));

        //int[] t = Arrays.copyOfRange(arr,0,arr.length);


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
        // Reverse an Integer.
        Long a = 1L;
        String slong = Long.toBinaryString(a);
        StringBuffer sb = new StringBuffer(slong);
        sb.reverse();
        Long b = Long.parseLong(sb.toString());
        
        copyArr();
        findMax();
        cloneMat();
        reverseArray();
    }
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // count frequency of each number
        Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
        // custom sort
        return Arrays.stream(nums).boxed()
                .sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
                .mapToInt(n -> n)
                .toArray();
    }
    public static void copyArr()
    {
        // OPTION 1
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        // System arrayCopy method is used to copy the elements of one array to another.
        // Does not create a new array—modifies the existing destination array.

        // OPTION 2
        int[] msis = Arrays.copyOfRange(arr1, 0, arr1.length);
        // This method creates a new array that is a copy of the specified range of the original array.
        // Automatically resizes the output array.
        // ✔ Best for: Creating new subarrays without modifying the original.
        // The new array does not resize beyond the selected elements.
    }
    public static void findMax()
    {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int max = Arrays.stream(arr1).max().getAsInt();
        int min = Arrays.stream(arr1).min().getAsInt();
        int sum = Arrays.stream(arr1).sum();
        Double avg = Arrays.stream(arr1).average().getAsDouble();
    }
    public static void convertArrayListToArray()
    {
            ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
            integerArrayList.add(1);
            integerArrayList.add(2);
            integerArrayList.add(3);
            integerArrayList.add(4);
            integerArrayList.add(5);
        int[] intArray = integerArrayList.stream().mapToInt(i -> i).toArray();
    }
    public static void convertArrayToArrayList()
    {
        int[] arr1 = new int[]{};
        List<Integer> arrList = Arrays.stream(arr1).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
    public static void reverseArray(){
        // doesn't work with primitive data types like int.
        int[] arr2 = new int[]{1,2,3,4,5};
        Collections.reverse(Arrays.asList(arr2));
        System.out.println(Arrays.toString(arr2));

        Integer[] arr = {1, 2, 3, 4, 5};
        Collections.reverse(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
    }
    public static void cloneMat()
    {
        int[][] mat = {{0,0,0},{1,1,1}};
        int [][] dp=mat.clone();

        int[] arr = {1,2,3};
        int[] arr1 = arr.clone();
    }
    public static void intToBooleanConv()
    {
        int value = 1;
        boolean result = (value != 0);
    }
    public int[] findFibSubset(int arr[], int n)
    {
        ArrayList<Integer>list = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            if(checkfib(arr[i])){
                list.add(arr[i]);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public static boolean checkfib(int n){
        int a=0, b=1, c=0;
        if(n==a || n==b){
            return true;
        }
        while(c<=n){
            c=a+b;
            if(c==n){
                return true;
            }
            a=b;
            b=c;
        }
        return false;
    }
    public static void directionsArrayInit()
    {
        int[][] dir4 = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        int[][] d4 = {{-1,0},{0,1},{1,0},{0,-1}};

        int[][] d8 = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

        // Knight Directions.
        int[][] KD = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
    }
    public static void arraySorting()
    {
        int[][] points = {{1,2},{3,4},{5,6}};

        //technique 1 -- SAFE
        Arrays.sort(points , (o1,o2) -> {
            if(o1[1]==o2[1]) return 0;
            if(o1[1]>o2[1]) return 1;
            else return -1;
        });

        //technique 2 - UNSAFE, INTEGER OVERFLOW
        // If the values of o1[1] and o2[1] are large enough, 
        // their difference could exceed the range of a 32-bit signed integer (int), which is [-2^31, 2^31 - 1]. 
        // This would result in an overflow, leading to incorrect sorting behavior.
        Arrays.sort(points , (o1,o2) -> o1[1]-o2[1]);

        //technique 3 -- SAFE
        //method internally handles comparisons without performing arithmetic operations that could overflow.
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));


    }
}