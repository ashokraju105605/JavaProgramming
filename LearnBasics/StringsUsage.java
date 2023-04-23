package LearnBasics;

import java.util.regex.*;
import java.util.*;

public class StringsUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        String s = "Jai Shree Ram";
        System.out.println(s.length());
        System.out.println(s.substring(4, 9)); // java picks always given -1 for the end indexes.
        System.out.println(s.substring(10));
        System.out.println(s.substring(3, 10).trim()); // start inclusive, end exclusive as per java convention.
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.indexOf("Ram"));
        System.out.println(s.charAt(10)); // cannot use s[index] like C#
        //System.out.println(s[3]);
        System.out.println(s.concat(" Siyaram"));
        System.out.println(s.contains("Ram"));
        System.out.println(s.endsWith("Ram"));
        System.out.println(s.startsWith("Jai"));
        System.out.println(s.isEmpty());  // "" is true for isEmpty, null also true for isEmpty.
        System.out.println(s.isBlank());  // " " is true for isBlank, same as trim and then check empty.
        System.out.println(s.matches("\\S+"));
        System.out.println(s.toCharArray());
        System.out.println(String.format("%s world", "hello"));

        System.out.println(Pattern.matches("[a-z]*", "ashok")); // use java.util.regex.*
        
        ArrayList<String> al = new ArrayList<String>();
        al.add("ashok");al.add("raju");al.add("gadhiraju");

        System.out.println( String.join(", ",al));

        System.out.println( String.join(", ",s.split(" ")));

        System.out.println();

        String s1 = "21212121";
        System.out.println( s1.replace("21", "23")); // returns a new string that is replaced with new substring.
        System.out.println(s1.replaceAll("\\23", "24"));
        System.out.println(s1);
        //char[] clist = s1.toCharArray();
        System.out.println(s1.matches("[0-9]+"));
        System.out.println(s1.chars().allMatch(Character::isDigit));

        String str = "ashok";
        List<Character> lch = new ArrayList<Character>();
        for( Character c:str.toCharArray())
            lch.add(c);
        Collections.reverse(lch);
        System.out.println(lch.toString());

        String str2 = (new StringBuffer("raju")).reverse().toString(); //StingBuilder is not thread safe in java, only used in C#. use only StringBuffer in java
        System.out.println(str2);
        
        String str3 = "ashok";
        System.out.println(str3.compareTo("raju")); // gives the diff in character value of the first mismatch.
        System.out.println(str3.compareTo("aashok"));
        System.out.println(str3.compareTo("ashok"));


        String[] arr = s.split(" ");
        String[] arr2 = new String[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            char[] ch = arr[i].toCharArray();
            ch[0] = Character.toUpperCase(ch[0]);
            arr2[i]=new String(ch);
        }
        System.out.println(String.join(" ", arr2));

        System.out.println("Jai Shree Ram".replaceAll("\\s", "%20"));
        System.out.println(FirstNonRepeating("aabc"));

        binaryStringOperations();

    }

    public static String FirstNonRepeating(String A)
    {
        // code here
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        String sb = "";

        for(int i=0;i<A.length();i++){
            map.put(A.charAt(i),map.getOrDefault(A.charAt(i),0)+1);
            char c = '#';
            for(char key: map.keySet()){
                if(map.get(key)==1){
                    c=key;
                    break;
                }
            }
            sb+=c;
        }
        return sb;
    }
    public static void binaryStringOperations()
    {
        int num1 = Integer.parseInt("1010", 2);
	    int num2 = Integer.parseInt("1001", 2);
	    String sum = Integer.toBinaryString(num1+num2);
        System.out.println(sum);
    }
}
