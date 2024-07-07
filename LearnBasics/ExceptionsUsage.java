package LearnBasics;

import java.io.IOException;

public class ExceptionsUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        test();
        test2();

        // for more information on types of excpetion classes and their uses
        // https://www.geeksforgeeks.org/types-of-exception-in-java-with-examples/
    }
    public static void test()
    {
        try{
            int a = 2/0;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void test2()
    {
        try{
            throw new IOException("Hello exception");
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
