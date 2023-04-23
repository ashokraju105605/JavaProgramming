package LearnBasics;

public class NumbersUsage {
    public static void main(String[] args) {
        System.out.println("Jai Shree Ram");
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Float.NEGATIVE_INFINITY);
        System.out.println(Float.NEGATIVE_INFINITY);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.parseInt("123"));
        System.out.println(Long.parseLong("123"));
        System.out.println(Integer.reverse(32));
        System.out.println(Float.parseFloat("123.23"));
        System.out.println(Float.isNaN(123));
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);

        long mod = 1000_000_007;
        System.out.println(mod);
        testing();
    }
    public static void testing()
    {
        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.parseInt("101",2));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.bitCount(5));
        System.out.println(Integer.valueOf("23"));
        System.out.println(Integer.valueOf(25));
        System.out.println(Integer.compare(2,3));
        System.out.println(Integer.compare(3,3));
        System.out.println(Integer.signum(-300));

        System.out.println(Double.isNaN(0));
        System.out.println(Double.NaN);
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);

        System.out.println(Character.isDigit('1'));
        

    }
}