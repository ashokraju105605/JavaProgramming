import java.util.*;

public class ArraysUsage {
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");

        int[] arr = new int[5];
        arr[0] = 10;
        int[] arr1 = { 1, 2, 3, 4, 5 };

        // int[] a1 = new int[5];
        // int[] a2 = new int[4] { 1, 2, 3, 4 }; // doesn't work in java
        int[] val = new int[] { 180, 60, 100, 120 };

        Arrays.sort(val);

        System.out.println(val[0]); // doesn't print array

        System.out.println(Arrays.binarySearch(val, 20));
        System.out.println(Arrays.binarySearch(val, 70));
        System.out.println(Arrays.binarySearch(val, 190));
        System.out.println(Arrays.binarySearch(val, 120));

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
        Arrays.sort(animals, 0, 3);
        System.out.println(Arrays.toString(animals));

        // System.out.println("%s", String.join(", ", animals)); // --doesn't work like
        // this

        String s = String.format("%s", String.join(", ", animals));
        System.out.println(s);
    }
}