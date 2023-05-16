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
        Integer[] arr2 = {1,2,3,4,5};

        int [] nums = {1,2,3,4,5};
        int sum = Arrays.stream(nums).sum();
        System.out.println(sum);

        Collections.reverse(Arrays.asList(arr1));
        System.out.println(Arrays.asList(arr1)); // doesn't reverse

        String[] str = {"ashok","raju","gadhiraju"};
        Collections.reverse(Arrays.asList(str));
        System.out.println(String.join(" ",str)); //works.

        Collections.reverse(Arrays.asList(arr2));
        System.out.println(Arrays.asList(arr2)); // REVERSES
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

        // OPTION 2
        int[] msis = Arrays.copyOfRange(arr1, 0, arr1.length);
    }
    public static void findMax()
    {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int max = Arrays.stream(arr1).max().getAsInt();
        int min = Arrays.stream(arr1).min().getAsInt();
        int sum = Arrays.stream(arr1).sum();
        Double avg = Arrays.stream(arr1).average().getAsDouble();
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
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    }
}