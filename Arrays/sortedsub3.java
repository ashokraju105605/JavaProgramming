package Arrays;

public class sortedsub3 {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        int[] nums = {1,2,-1,7,5};
   
        // Function Call
        find3Numbers(nums);
        find3Numbers(new int[]{12, 11, 10, 5, 6, 2, 30}); 
        find3Numbers(new int[]{1, 2, 3, 4});
        find3Numbers(new int[]{4, 3, 2, 1});
    }
    static void find3Numbers(int[] arr)
    {
        //int[] A = arr;
        int leftminindex = 0;
        int rightmaxindex = arr.length-1;

        int i=1,j=arr.length-2;

        while(i<arr.length-1 && arr[i]<arr[leftminindex])
        {
            leftminindex = i;
            i++;
        }
        while(j>0 && arr[j]>arr[rightmaxindex])
        {
            rightmaxindex = j;
            j--;
        }
        if(i<j)
        {
            while(i<j)
            {
                if(arr[i]>arr[leftminindex] && arr[i]<arr[rightmaxindex])
                    {
                        System.out.println( arr[leftminindex] + " " + arr[i] + " " + arr[rightmaxindex]);
                        return;
                    }
            }
        }
        else
        {
            System.out.println("Nothing possible");
            return;
        }

    }
}
