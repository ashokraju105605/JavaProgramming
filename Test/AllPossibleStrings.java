package Test;
import java.util.*;
public class AllPossibleStrings {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        System.out.println(allPossibleStrings("abc"));
    }
    public static List<String> allPossibleStrings(String s)
    {
        // Code here
        ArrayList<String> al=new ArrayList<>();
        for(int i=0;i<Math.pow(2,s.length());i++){
            String s1="";
            for(int j=0;j<s.length();j++){
                if(((i>>j)&1)==1){
                    s1=s1+s.charAt(j);
                }
            }
            if(s1!=""){
            al.add(s1);
            }
        }
        Collections.sort(al);
    
        return al;
    }
}
