import java.util.*;

public class Test3 {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        int[] arr = new int[]{2,1,2};
        int[] arr1 = new int[]{1,2,3,3};

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        subsets(res,temp,arr,0);
        System.out.println(res);

        Arrays.sort(arr); // to give subsets in lexicographic order
        res.clear();
        temp.clear();
        subsets(res,temp,arr,0);
        System.out.println(res);

        res.clear();
        temp.clear();
        subsetsUnique(res,temp,arr,0);
        System.out.println(res);

        res.clear();
        temp.clear();
        permutations(res,temp,new int[]{1,2,3});
        System.out.println(res);

        res.clear();
        temp.clear();
        int[] arr2 = new int[]{1,1,2};
        boolean[] vis = new boolean[arr2.length];
        permutationsUnique(res,temp,arr2,vis);
        System.out.println(res);

        res.clear();
        temp.clear();
        int[] arr3 = new int[]{2,3,5}; // sorted
        combinationSum(res,temp,arr3,8,0);
        System.out.println(res);

        res.clear();
        temp.clear();
        int[] arr4 = new int[]{10,1,2,7,6,1,5}; 
        Arrays.sort(arr4);
        combinationSumUnique(res,temp,arr4,8,0);
        System.out.println(res);

        List<List<String>> list = new ArrayList<>();
        palindromePartioning(list, new ArrayList<String>(), "aab", 0);
        System.out.println(list);

    }

    public static void subsets(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] arr,int index)
    {
        res.add(new ArrayList<>(temp));
        for(int i=index;i<arr.length;i++)
        {
            temp.add(arr[i]);
            subsets(res,temp,arr,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public static void subsetsUnique(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] arr,int index)
    {
        res.add(new ArrayList<>(temp));
        for(int i=index;i<arr.length;i++)
        {
            if(i>index && arr[i]==arr[i-1]) continue; // skip duplicates
            temp.add(arr[i]);
            subsetsUnique(res,temp,arr,i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void permutations(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] arr)
    {
        if(temp.size()==arr.length)
            res.add(new ArrayList<>(temp));
        else        
            for(int i=0;i<arr.length;i++)
            {
                if(temp.contains(arr[i])) continue;
                temp.add(arr[i]);
                permutations(res,temp,arr);
                temp.remove(temp.size()-1);
            }
    }
    public static void permutationsUnique(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] arr, boolean[] used)
    {
        if(temp.size()==arr.length)
            res.add(new ArrayList<>(temp));
        else
            for(int i=0;i<arr.length;i++)
            {
                // Skip if the number has already been used or if it's a duplicate that has already been used
                if(used[i] || i>0 && arr[i]==arr[i-1] && !used[i-1]) continue;
                used[i]=true;
                temp.add(arr[i]);
                permutationsUnique(res,temp,arr,used);
                used[i]=false;
                temp.remove(temp.size()-1);
            }
    }
    public static void combinationSum(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] arr,int remain, int index)
    {
        if(index >= arr.length || remain < 0)
            return;
        else if(remain ==0)
            res.add(new ArrayList<>(temp));
        else
            for(int i=index;i<arr.length;i++)
            {
                temp.add(arr[i]);
                combinationSum(res,temp,arr,remain-arr[i],i);// not i + 1 because we can reuse same elements
                temp.remove(temp.size()-1);
            }
    }
    public static void combinationSumUnique(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] arr,int remain, int index)
    {
        if(index >= arr.length || remain < 0)
            return;
        else if(remain ==0)
            res.add(new ArrayList<>(temp));
        else
            for(int i=index;i<arr.length;i++)
            {
                if(i>index && arr[i]==arr[i-1]) continue; // skip duplicates
                temp.add(arr[i]);
                combinationSumUnique(res,temp,arr,remain-arr[i],i+1);//  i + 1 because we cannot reuse same elements
                temp.remove(temp.size()-1);
            }
    }
    public static void palindromePartioning(List<List<String>> list, List<String> tempList, String s, int start)
    {
        if(start == s.length())
            list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    palindromePartioning(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
    public static boolean isPalindrome(String s, int low, int high){
        while(low < high)
           if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
     } 
}
