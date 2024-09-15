package JavaSyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysLearn {
    public static void main(String[] args) {

        System.out.println("Jai Shree Ram");


        // Create, Init, Read, Update, Delete, Count, Search, Iterate, Comparision, Conversion, Print, Specifics.

         // Create
        int[] arr = {5,4,3,2,1};
        int[] arr1 = new int[]{1,2,3,4,5}; // cannot give dimention when initialization is provided
        int[] nums = {1,2,3,4,5};
        int[] arr2 = arr.clone();
        int[][] mat = {{0,0,0},{1,1,1}};
        List<Integer> arr3 = Arrays.asList(1,2,3,4,5);

        // Init
        Arrays.fill(arr1, -1);
        int [][] dp=mat.clone();

        // Read
        int p = arr[2];

        // Update
        arr[2] = 8;

        // Delete
        // not possible as fixed structure container.

        // Count
        int len = arr.length;
        long len1 = Arrays.stream(arr).count();
        int sum = Arrays.stream(arr).sum();

        // Search
        boolean found = Arrays.stream(arr1).anyMatch(x -> x == 5);
        Arrays.binarySearch(arr1, 2);

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
        int[] arr9 = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        // Print
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.deepToString(mat));


        //Specifics
        int[] arr4 = Arrays.copyOfRange(arr1, 1, 3);
        int[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Arrays.sort(arr5);
        Arrays.sort(arr,0,2);
        List<Integer> arrList = Arrays.stream(arr1).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(Arrays.toString(arr));
        int max = Arrays.stream(arr1).max().getAsInt();
        int min = Arrays.stream(arr1).min().getAsInt();
        int sum1 = Arrays.stream(arr1).sum();
        Double avg = Arrays.stream(arr1).average().getAsDouble();
        int index = Arrays.binarySearch(arr1,4);
    }
    
}
