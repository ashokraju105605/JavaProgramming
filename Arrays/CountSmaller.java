package Arrays;

import java.util.*;

public class CountSmaller {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        int[] arr2 = {1, 2, 4, 5, 8, 10};
        int arr[] = { 1, 2, 4, 5, 8, 10 };
        int key = 11;
        System.out.println(countOfElements(arr, arr.length, key));
        System.out.println(countOfElements(arr2, arr2.length, 9));
        System.out.println(countOfElements(new int[]{1, 2, 2, 2, 5, 7, 9}, 7, 2));
    }
    static int countOfElements(int[] arr, int n, int key)
    {
        int count = Arrays.binarySearch(arr, key);
        if(count>0)
            return count+1;
        else
            return Math.abs(count)-1;
    }
}
