import java.util.*;
public class BookAllocation {
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");
        int[] arr = {12, 34, 67, 90};
        int n = arr.length;
        int m = 2; // Number of students
        System.out.println("Minimum number of pages: " + findPages(arr, n, m));
    }

    static int findPages(int[] arr, int n, int m) {
        int left = Arrays.stream(arr).max().getAsInt();
        int right = Arrays.stream(arr).sum();
        
        if(n<m) return -1;
        int result = -1;
        while(left<right)
        {
            int mid = left + (right-left)/2;
            if(isPossible(arr,m, mid))
            {
                result = mid;   
                right = mid-1;
            }
            else
                left = mid+1;

        }
        return result;
    }
    static boolean isPossible(int[] arr, int m, int mid)
    {
        int cursize =0,numofstuds=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>mid)
                return false;
            if(cursize+arr[i]<=mid)
                cursize+=arr[i];
            else{
                numofstuds++;
                cursize = arr[i];
            }
        }
        return numofstuds<=m;
    }
}
