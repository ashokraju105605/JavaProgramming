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
        System.out.println(s.indexOf("Ram"));
        System.out.println(s.charAt(10));
        System.out.println(s.concat(" Siyaram"));
        System.out.println(s.contains("Ram"));
        System.out.println(s.endsWith("Ram"));
        System.out.println(s.startsWith("Jai"));
        System.out.println(s.isEmpty());  // "" is true for isEmpty, null also true for isEmpty.
        System.out.println(s.isBlank());  // " " is true for isBlank, same as trim and then check empty.
        System.out.println(s.matches("\\S+"));
        System.out.println(s.toCharArray());
        System.out.println(String.format("%s world", "hello"));

        System.out.println(Pattern.matches("[a-z]", "ashok")); // use java.util.regex.*
        
        ArrayList<String> al = new ArrayList<String>();
        al.add("ashok");al.add("raju");al.add("gadhiraju");

        System.out.println( String.join(", ",al));

        System.out.println( String.join(", ",s.split(" ")));

        System.out.println();

        String s1 = "21212121";
        System.out.println( s1.replace("21", "23")); // returns a new string that is replaced with new substring.
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

        StringBuffer str2 = new StringBuffer("raju");
        System.out.println(str2.reverse());

    }
}
