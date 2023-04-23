package Arrays;

public class MajorityElement {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        findMajority(new int[]{ 1, 1, 2, 1, 3, 5, 1 });
    }
    static void findMajority(int[] arr)
    {
        int cand = arr[0];
        int count = 1;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==cand)
                count++;
            else
            {
                count--;
                if(count==0)
                {
                    count=1;
                    cand = arr[i];
                }
            }                
        }
        if(isMajority(arr, cand))
            System.out.println(cand);
        else
            System.out.println("No Candidate Available");
    }
    static boolean isMajority(int[] arr, int cand)
    {
        int i, count = 0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == cand)
                count++;
        }
        if (count > arr.length / 2)
            return true;
        else
            return false;
    }
}
