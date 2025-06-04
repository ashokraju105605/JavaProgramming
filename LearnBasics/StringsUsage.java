package LearnBasics;

import java.util.regex.*;

import java.util.*;

public class StringsUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        String s = "Jai Shree Ram";
        System.out.println(s.length());
        System.out.println(s.substring(4, 9)); // java picks always given -1 for the end indexes(exclusive).
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
        System.out.println(String.format("%1$s world,  %1$s %2$s", "hello", "ashok"));

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
        convertNumtoString();
        StringBuilderUsage();
        characterUsage();
        traverseString();
        charToIntConv();
        testing12();
        stringComparision();

    }
    public static void StringBuilderUsage()
    {
        StringBuilder sb = new StringBuilder(); // not thread safe, but faster than StringBuffer.
        sb.append('a');
        sb.append("shok");
        sb.insert(2,"raju");
        sb.reverse();
        sb.indexOf("raju", 1);
        sb.charAt(2);
        sb.setCharAt(2, 'a');
        sb.substring(2,5);
        sb.compareTo(sb);
        sb.equals(sb);
        sb.isEmpty();
        sb.length();
        sb.substring(2);
        sb.lastIndexOf("ram", 5);
        sb.subSequence(0, sb.length());
        System.out.println(sb);
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
    public static void convertNumtoString()
    {
        String str = String.valueOf(545); // return the boxed value of the integer as a string.
        StringBuffer sb = new StringBuffer(str); // StringBuffer is synchronized, so it is thread safe, but slower than StringBuilder.
        sb.reverse();
        System.out.println(str.equals(""+sb));

        StringBuffer sb2 = new StringBuffer("123");
        sb2.reverse();
        System.out.println(sb2.toString());

    }

    public static void characterUsage()
    {
        Character ch = 'a';
        System.out.println(Character.toUpperCase(ch));
        System.out.println(Character.valueOf('a')); // returns the Character object for the given char.
        System.out.println(Character.isDigit(ch)); // checks if the character is a digit
        System.out.println(ch.isDigit(0));
        
        String s = "i.like.this.program.very.much";
        String[] str = s.split("\\.");
        Collections.reverse(Arrays.asList(str));
        String res = String.join(".",str);
    }
    public static void StringOps()
    {
        String S = "Ashok";
        for(char ch:S.toCharArray()){
            Character.toUpperCase(ch);
            
        }
        String sorted = "abc";
        StringBuilder reversed= new StringBuilder();
        
        reversed.append(sorted);
        reversed.reverse();
        String.valueOf(reversed);
        String s = "I am :IronnorI Ma, i";
        String str=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();


        String[] str1 = S.split("\\."); // . means any character, so use escape sequence \\
        Collections.reverse(Arrays.asList(str1));
        String res = String.join(".",str1);

        s.indexOf("x");
    }
    public static void traverseString()
    {
        String s = "ashok";
        for(Character c: s.toCharArray())
            System.out.println(c);

        char[] carr = s.toCharArray();
        int[] arr = new int[128]; // ASCII characters range from 0 to 127.
        for(char c : carr)
        {
            arr[c]++;
        }
        System.out.println(arr.toString()); // doesn't print as the function doesn't apply 
        // to primitives
        // but it is using the toString() method on the array object, which returns a string representation 
        // of the array object itself, not its contents.
        // To print the contents of the array, you can use Arrays.toString(arr) method which converts 
        // the array to a string representation of its contents.
        System.out.println(Arrays.toString(arr));
    }
    public static void charToIntConv()
    {
        String s = "ashok";
        char[] carr = s.toCharArray();
        int[] arr = new int[128]; // ASCII characters range from 0 to 127.
        for(char c : carr)
        {
            arr[(int)c]++;
        }
        System.out.println(arr.toString()); // doesn't print as the function doesn't apply 
        // to primitives
        // but it is using the toString() method on the array object, which returns a string representation 
        // of the array object itself, not its contents.
        // To print the contents of the array, you can use Arrays.toString(arr) method which converts 
        // the array to a string representation of its contents.
        System.out.println(Arrays.toString(arr));

        StringBuilder str = new StringBuilder();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
                str.append((char)i); // char casting needed otherwise direct number is taken
        }
        System.out.println(str);
        
    }
    public static boolean testing12()
    {
        String s = "A man, a plan, a canal: Panama";
        String str = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        if(sb.toString().equals(s))
            return true;
        else
            return false;
    }
    public static void stringComparision()
    {
        /*
        To compare strings in Java, we should use the equals method instead of the == operator, 
        as it only compares object references. Also, the equality check for the empty string 
        should be done by calling its isEmpty() method.
        */
        String[] s = {"ashok","raju"};
        if(s[0]=="ashok")     // WORKED , but not recommended.
            System.out.println("Comparision worked");
        else
            System.out.println("Comparision using == fails");

        if(s[0].equals("ashok"))  // works. and recommended.
            System.out.println("comparision works");
        else
            System.out.println("comparision failed");

        int[] a = {2,3};
        String key = a[0]+"@"+a[1];
        System.out.println(key); 
    }

    /*
     * 
     *  \d	Any digits, short of [0-9]
        \D	Any non-digit, short for [^0-9]
        \s	Any whitespace character, short for [\t\n\x0B\f\r]
        \S	Any non-whitespace character, short for [^\s]
        \w	Any word character, short for [a-zA-Z_0-9]
        \W	Any non-word character, short for [^\w]
        \b	A word boundary
        \B	A non word boundary
     */
}
