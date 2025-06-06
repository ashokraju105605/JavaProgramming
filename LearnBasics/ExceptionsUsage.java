package LearnBasics;

import java.io.BufferedReader;
import java.io.FileReader;
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

    void validateAge(int age) throws IllegalArgumentException {
        if (age < 18) throw new IllegalArgumentException("Age must be 18 or above.");
    }

    class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    void validate(int value) throws InvalidInputException {
        if (value < 0) throw new InvalidInputException("Negative values not allowed!");
    }

    void test1(){
        // Try-With-Resources (Auto Closing)
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("File error!");
        }
    }

    // ✔ Checked Exceptions(enforced at compile time) (IOException, SQLException) → Must be handled (throws or try-catch). 
    // ✔ Occur during compile-time, meaning the program won’t compile unless handled. 
    // ✔ Typically used when failures are expected and need recovery (e.g., file operations, networking).

    void riskyOperation() throws IOException { // ✅ Checked exception
        throw new IOException("File not found!");
    }
    // ✔ Unchecked Exceptions (NullPointerException, ArithmeticException) → Runtime errors not enforced by the compiler.
    // ✔ Do not require explicit handling, but can be caught if needed. 
    // ✔ Occur during runtime, meaning the compiler won’t force handling. 
    // ✔ Typically caused by programming errors (e.g., null references, division by zero).
    void riskyOperationUnchecked() { // ❌ Unchecked exception
        throw new RuntimeException("Runtime error occurred!");
    }

}
