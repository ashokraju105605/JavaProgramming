package LearnBasics;

import java.lang.Math;
import java.util.Arrays;
import java.util.Random;

public class RandomUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        System.out.println(Math.random());

        int max = 10, min = 1;
        int range = max - min + 1;
        //System.out.println( (int)(Math.random()*range) + min);
        System.out.println("Using Math.random");
        for( int i=0;i<10;i++)
        {
            System.out.println((int)(Math.random()*range) + min);
        }

        System.out.println("Using Random Class");

        Random r = new Random();

        System.out.println(r.nextInt(10)); // 0 to 10 exclusive
        System.out.println(r.nextInt());
        System.out.println(r.nextBoolean());
        System.out.println(r.nextDouble());
        System.out.println(r.nextFloat());
        System.out.println(r.nextLong());
        System.out.println(r.nextInt(5, 10)); // 5 to 10 exclusive


        // Generate Stream of Random things as required.
        r.ints(5).forEach(System.out::println);
        r.ints(5,10,30).forEach(System.out::println);
        System.out.println(Arrays.toString( r.ints(5,10,30).toArray()));
        
    }
}
