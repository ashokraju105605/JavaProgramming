package LearnBasics;

import java.math.BigInteger;

public class NumbersUsage {
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Float.NEGATIVE_INFINITY);
        System.out.println(Float.POSITIVE_INFINITY);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.parseInt("123"));
        System.out.println(Long.parseLong("123"));
        System.out.println(Integer.reverse(32));
        System.out.println(Float.parseFloat("123.23"));
        System.out.println(Float.isNaN(123));
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);

        long mod = 1000_000_007;  // often written as 10^9+7 , largest prime number that fits in a 32-bit integer. first 10-digit prime number.
        System.out.println(mod);
        testing();
        FactorialBigInt();
        mathLibTests();
        ConvertIntegerToString();
        PalindromeCheck();
        ReverseDigits();
        BinStringToDecimal();

        
        byte b = 2;
        short c = 3;
        int a=1;
        long d = 100L;
        float e = 2.3f;
        double db = 19.99d;

        Byte f = 2;
        Short g = 3;
        Integer h = 5;
        Long i = 20L;
        Float j = 2.22F;
        Double k = 13.3333D;

        Integer abc = null;

        if(abc==null)
            System.out.println("abc Integer is null");         

        

    }
    public static void testing()
    {
        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.parseInt("101",2));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.bitCount(5));
        System.out.println(Integer.valueOf("23"));
        System.out.println(Integer.valueOf(25));
        System.out.println(Integer.toString(23));
        System.out.println(Integer.compare(2,3));
        System.out.println(Integer.compare(3,3));
        System.out.println(Integer.signum(-300));

        System.out.println(Double.isNaN(0));
        System.out.println(Double.NaN);
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);

        System.out.println(Character.isDigit('1'));       

    }
    public static void FactorialBigInt()
    {
        BigInteger res = BigInteger.ONE;
        for(int i=2;i<10;i++)
            res = res.multiply(BigInteger.valueOf(i));
        System.out.println(res.longValue());
    }
    public static void mathLibTests(){
        double sol = Math.cbrt(8);
        double sol1 = Math.sqrt(4);
        int sol2 = Math.abs(-1);
        double sol3 = Math.pow(2,4);
        double sol4 = Math.ceil(23.2);
        double sol5 = Math.exp(2);
        double sol6 = Math.floor(23.2);
        double sol7 = Math.round(23.5);
        double sol8 = (int)(Math.random()* 10);
    }

    public static void ConvertIntegerToString()
    {
        String s = Integer.toString(53);
        String s1 = String.valueOf(53);

        StringBuilder sb = new StringBuilder("35");
        sb.reverse();

        if(s.equals(s1))
            System.out.println(s);
        if(s1.equals(""+sb))
            System.out.println(sb);
    }
    public static void PalindromeCheck()
    {
        int sum = 53;
        String num1 = String.valueOf(sum);
        StringBuilder sb = new StringBuilder(num1);
        sb.reverse();
        if (num1.equals(""+sb)) {
            System.out.println("PALINDROME");
        }
    }
    public static void ReverseDigits()
    {
        Long n = 1234L;
        String numString = Long.toString(n);
        String reversedString = new StringBuilder(numString).reverse().toString();
        System.out.println( Long.parseLong(reversedString));
    }
    public static void BinStringToDecimal()
    {
        System.out.println(Integer.parseInt("1011",2));
    }
    public static void boolTest()
    {
        boolean flag = true;
        Boolean flag1 = false;

        flag1.toString();
    }
}