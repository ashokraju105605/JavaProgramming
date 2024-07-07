import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Test2 {

    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        System.out.println( Solve.AllSubsets(new int[]{1,2,3}, 3));
        // System.out.println( Solve.AllSubsets(new int[]{1,2,3,3}, 4));
        //System.out.println( Solve.AllSubsets(new int[]{3,1,2,3}, 4));

        
    }
    public class Solve
    {
        public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n){
            LinkedHashSet <ArrayList <Integer>> res = new LinkedHashSet<>();
            ArrayList<ArrayList<Integer>> res1 = new ArrayList<>();
            ArrayList<Integer> set = new ArrayList<>();
            
            //res.add(set);
            store1(res,set,arr,0);
            return new ArrayList<>(res);
            //res1.add(set);
            //store3(res1,set,arr,0);
            //return new ArrayList<>(res1);
            

            
            
        }

        static void store(LinkedHashSet<ArrayList <Integer>> res,  ArrayList<Integer> set,int arr[], int index){
            if(index == arr.length) {
                return ;
            }
        
        set.add(arr[index]);
        res.add(new ArrayList<>(set));
        store(res,set,arr,index+1);
        
        set.remove(set.size()-1);
        store(res,set,arr,index+1);
        }
        static void store4(LinkedHashSet<ArrayList <Integer>> res,  ArrayList<Integer> set,int arr[], int index){

            res.add(new ArrayList<>(set));
            
            for(int i=index;i<arr.length;i++)
            {
                // if the order of the elements are not set in input array, then comparison of subsets is not possible,
                // when duplicates exists within the input array, so need to sort.
                // if result is held in hashset, then no need to do the below skipping of duplicates as adding
                // into hashset would be redundant with same duplicates in respective position.

                //if(i > index && arr[i] == arr[i-1]) continue;
                set.add(arr[i]);
                store4(res,set,arr,i+1);
                set.remove(set.size()-1);
            }
        }
        static void store1(LinkedHashSet<ArrayList <Integer>> res,  ArrayList<Integer> set,int arr[], int index){

            if(!res.contains(set)) res.add(new ArrayList<>(set));
            
            for(int i=index;i<arr.length;i++)
            {
                //if(i > index && arr[i] == arr[i-1]) continue;
                set.add(arr[i]);
                store1(res,set,arr,i+1);
                set.remove(set.size()-1);
            }
        }
        static void store2(ArrayList<ArrayList <Integer>> res,  ArrayList<Integer> set,int arr[], int index){

            res.add(new ArrayList<>(set));
            
            for(int i=index;i<arr.length;i++)
            {
                set.add(arr[i]);
                store2(res,set,arr,i+1);
                set.remove(set.size()-1);
            }
        }
        static void store3(ArrayList<ArrayList <Integer>> res,  ArrayList<Integer> set,int arr[], int index){

            res.add(new ArrayList<>(set));
            
            for(int i=index;i<arr.length;i++)
            {
                if(i > index && arr[i] == arr[i-1]) continue;
                set.add(arr[i]);
                store3(res,set,arr,i+1);
                set.remove(set.size()-1);
            }
        }
    }

}
