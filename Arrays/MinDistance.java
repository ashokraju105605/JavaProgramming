package Arrays;

public class MinDistance {
    public static void main(String[] args)
    {

        MinDistance min = new MinDistance();
        System.out.println("Jai Shree Ram");
        int arr[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
        int n = arr.length;
        int x = 3;
        int y = 6;

        System.out.println("Minimum distance between " + x + " and " + y
                + " is " + min.minDist(arr, n, x, y));
    }
    int minDist(int[] a, int n, int x, int y)
    {
        int min = Integer.MAX_VALUE;
        int xindex = -1;
        int yindex = -1;
        for( int i=0;i<a.length;i++)
        {
            if(a[i]==x || a[i]==y)
            {
                if(a[i]==x)
                    xindex = i;
                else
                    yindex = i;

                if(xindex != -1 && yindex!=-1)
                {
                    min = Math.min(min, Math.abs(yindex-xindex));
                }
            }
        }
        if(min == Integer.MAX_VALUE)
            return -1;
        return min;
    }
}
