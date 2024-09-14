import java.util.*;
public class Solution5
{
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        int sum = FindMaxSum(new int[]{6,5,5,7},4);
        System.out.println(sum);
    }
    private static int FindMaxSum(int arr[], int n){
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = arr[0];
        
        for(int i = 1; i < n; i++){
//            if(dp[i] != -1){
//                return dp[i];
//            }
            int pick = arr[i];
            if(i>1){
                pick += dp[i-2];
            }
            int notPick = dp[i-1];
            
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n-1];
    }
}