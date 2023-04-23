package Test;

import java.math.BigInteger;
import java.util.*;

public class Test {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        printPat(3);
        factorial(200);
        cubepair(9);
        KthDigit(3,3,1);
        KthDigit(5,2,2);
        int[] arr = {1, 2, 2, 2, 5, 7, 9};
        countsmaller(arr,2);
        int[] res = findTwoElement(new int[]{2,2},2);
        System.out.println(merge("ashok","raju"));
        uncommonChars("ashok","raju");
        System.out.println(count(new int[]{1, 1, 2, 2, 2, 2, 3},2));
        int i = first(new int[]{1, 2, 2, 3, 3, 3, 3},0,6,2);
        int j = last(new int[]{1, 2, 2, 3, 3, 3, 3},i,6,2,6);
        System.out.println(j-i+1);
        System.out.println(maxOnes(new int[]{1,0,0,1,0},5));
        System.out.println(maxOnes(new int[]{1,0,0,1,0,0,1},7));
        testFunc();
        testFunc1(43);
        testFunc3();
        LongestPalindromeSubString("babcbabcbaccba");
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
    public static void testFunc3()
    {
        int[] coins = new int[]{1,2,3};
        int N=3;
        long[] dp = new long[N+1];
        dp[0]=0;
        for(int i=0;i<=N;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(i+coins[j]<=N)
                    dp[i+coins[j]]=1+dp[i];
            }
        }
        //int[] arr = new int[]{1,2,3};
        //int min = Arrays.stream(arr).min(Integer::compare).get();
        //int max = Arrays(arr).stream().max();
    }
    public static void testFunc1(int N)
    {
        List<Integer> l = new ArrayList<Integer>();
        int[] denom = new int[]{1,2,5,10,20,50,100,200,500,2000};
        
        while(N>0)
        {
            int index = Arrays.binarySearch(denom, N);
            
            if(index >=0 ){
                N -= denom[index];
                l.add(denom[index]);
            }
            else
            {
                l.add(denom[Math.abs(index+1)-1]);
                N -= denom[Math.abs(index+1)-1];
            }
        }
    }
    public static int maxOnes(int a[], int n) {
        // Your code goes here
        int one =0;
        for(int i =0;i<n;i++){
            if(a[i]==0){
                a[i]=1;
            }
            else{
                a[i]=-1;
                one++;
            }
        }
        int cursum =0;
        int maxsum=0;
        for(int i =0;i<n;i++){
            cursum+=a[i];
            if(cursum>maxsum){
                maxsum=cursum;
            }
            if(cursum<0){
                cursum=0;
            }
        }
        return maxsum+one;
    }
        /* if x is present in arr[] then returns the
       index of FIRST occurrence of x in arr[0..n-1],
       otherwise returns -1 */
       static int first(int arr[], int low, int high, int x)
       {
         if(high >= low)
         {
           /*low + (high - low)/2;*/ 
           int mid = (low + high)/2; 
           if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x)
             return mid;
           else if(x > arr[mid])
             return first(arr, (mid + 1), high, x);
           else
             return first(arr, low, (mid -1), x);
         }
         return -1;
       }
         
       /* if x is present in arr[] then returns the
          index of LAST occurrence of x in arr[0..n-1],
          otherwise returns -1 */
       static int last(int arr[], int low, int high, int x,int n)
       {
         if(high >= low)
         {
           /*low + (high - low)/2;*/     
           int mid = (low + high)/2;
           if( ( mid == n-1 || x < arr[mid+1]) && arr[mid] == x )
             return mid;
           else if(x < arr[mid])
             return last(arr, low, (mid -1), x,n);
           else
             return last(arr, (mid + 1), high, x,n);     
         }
         return -1;
       }
        
    static int count(int[] arr, int x) {
        // code here
        int rindex = Arrays.binarySearch(arr,x);
        int i=rindex -1;
        int count=0;
        if(arr[rindex]==x)
            count=1;
        while(i>=0 && arr[i--]==x)
            count++;
        
        return count;
    }
    static void uncommonChars(String s1, String s2)
    {
        TreeSet<Character> ts1 = new TreeSet<Character>();
        

    }

    static String merge(String S1, String S2)
    { 
        // code here
        int m=S1.length();
        int n = S2.length();
        char[] ch = new char[2*Math.min(m,n)];
        for(int i=0;i<Math.min(m,n);i++)
        {
            ch[2*i]=S1.charAt(i);
            ch[2*i+1]=S2.charAt(i);
        }
        String merge = new String(ch);
        if(m>n)
            return merge+S1.substring(n);
        else if(m<n)
            return merge+S2.substring(m);
        else 
            return merge;
    }
    static int[] findTwoElement(int arr[], int n) 
    {
        // code here
        for(int i=0;i<arr.length;i++)
        {
            int index = (arr[i] % (n+1))-1;
            arr[index] += (n+1);
        }
        int[] res = new int[2];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]/(n+1) == 0)
                res[1] = i+1;
            else if (arr[i]/(n+1) == 2)
                res[0]= i+1;
            else
                continue;
        }
        return res;
    }
    static void countsmaller(int[] a, int b)
    {
        System.out.println( Arrays.binarySearch(a,b)+1);
    }
    static void cubepair(int n)
    {
        int count = 0;
        for(int i=1;i<= Math.cbrt(n);i++)
        {
            int cb = i*i*i;
            int diff = n - cb;
            int cbrtdiff = (int)Math.cbrt(diff);
            if(cbrtdiff*cbrtdiff*cbrtdiff == diff)
                count++;
        }
        System.out.println(count);
    }
    static void printPat(int n)
    {
         // Your code here
         printRec(n,0);
         
    }
    static void printRec(int n, int i)
    {
        if(i!=n)
        {
            printRec(n,i+1);
        }

        for( int j=n;j>0; j--)
            for(int k=0;k<i;k++)
                System.out.print( j+ " ");
        System.out.println();

    }
    static void factorial(int n)
    {
        BigInteger b = BigInteger.valueOf(1);
        for( int i=1;i<=n;i++)
            b = b.multiply(BigInteger.valueOf(i));
        
        System.out.println(b);

    }
    static void KthDigit(int a, int b, int k)
    {
        BigInteger sum = BigInteger.valueOf(a);
        sum = sum.pow(b);
        char[] arr = sum.toString().toCharArray();
        System.out.println(arr[arr.length-k]);
    }
    static void testFunc()
    {
        Set<Integer> linkhasset
        = new LinkedHashSet<Integer>();

    // Adding elements to above LinkedHashSet
    // Custom inputs
    linkhasset.add(26);
    linkhasset.add(23);
    linkhasset.add(24);
    linkhasset.add(21);
    linkhasset.add(25);
    linkhasset.add(22);

    // TreeSet storing elements in descending order by
    // adding all elements of HashSet in reverse order
    TreeSet<Integer> ts
        = new TreeSet<>(Collections.reverseOrder());
        
    // Add all elements from LinkedHashSet to TreeSet
    ts.addAll(linkhasset);

    ArrayList<Integer> al = new ArrayList<>();
    al.addAll(linkhasset);
        
    Stack<Integer> s = new Stack<Integer>();
    s.addAll(linkhasset);
        
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.addAll(linkhasset);

    while(!pq.isEmpty())
    {
        System.out.println(pq.poll());
    }

    LinkedList<Integer> ll = new LinkedList<>();
    ll.addAll(linkhasset);

    int[] a = new int[]{1,2,3,4,5};
    int sum = Arrays.stream(a).sum();
    System.out.println(sum);

    int[] arr = a;
    HashMap<Integer,Integer> hm = new HashMap<>();
    Integer sum2 = 0;
    for(Integer i=0;i<arr.length;i++)
    {
        if(arr[i]==0)
            //return true;
        sum += arr[i];
        if(hm.containsKey(sum2))
        {
            //return true;
        }
        hm.put(sum2, i);

        
    }
    }
    static String LongestPalindromeSubString(String s)
    {
       int strLen = 2 * s.length() + 3;
       char[] sChars = new char[strLen];

       /*
        * To ignore special cases at the beginning and end of the array
        * "abc" -> @ # a # b # c # $
        * "" -> @#$
        * "a" -> @ # a # $
        */
       sChars[0] = '@';
       sChars[strLen - 1] = '$';
       int t = 1;
       for (char c : s.toCharArray()) {
           sChars[t++] = '#';
           sChars[t++] = c;
       }
       sChars[t] = '#';

       int maxLen = 0;
       int start = 0;
       int maxRight = 0;
       int center = 0;
       int[] p = new int[strLen]; // i's radius, which not includes i
       for (int i = 1; i < strLen - 1; i++) {
           if (i < maxRight) {
               p[i] = Math.min(maxRight - i, p[2 * center - i]);
           }

           // expand center
           while (sChars[i + p[i] + 1] == sChars[i - p[i] - 1]) {
               p[i]++;
           }

           // update center and its bound
           if (i + p[i] > maxRight) {
               center = i;
               maxRight = i + p[i];
           }

           // update ans
           if (p[i] > maxLen) {
               start = (i - p[i] - 1) / 2;
               maxLen = p[i];
           }
       }

       return s.substring(start, start + maxLen);
    }
}
