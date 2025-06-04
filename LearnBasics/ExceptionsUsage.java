package LearnBasics;

import java.io.IOException;

public class ExceptionsUsage {
    public static void main(String[] args) throws IOException
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
    public static void test2() throws IOException
    {
        try{
            throw new IOException("Hello exception"); // exception object needs to be created and thrown explicitly.
            // Note: IOException is a checked exception, so it must be either caught or declared in the method signature.
            // declaring it in the method signature will require the method to be declared with 'throws IOException'.
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
