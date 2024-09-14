import java.math.BigDecimal;

public class Test13 {
    public static void main(String[] args)
    {
        Float a = 0.1f;
        Float b = 0.2f;
        if( a+b == 0.3)
        {
            System.out.println("Comparision works fine");
        }
        else
        {
            System.out.println("Comparision not working fine");
        }

        BigDecimal ba1 = BigDecimal.valueOf(0.1);
        BigDecimal ba2 = BigDecimal.valueOf(0.2);

        // Compares Double to BigDecimal
        if(ba1.add(ba2) == BigDecimal.valueOf(0.3)) 
        {
            System.out.println("Comparision works fine");
        }
        else
        {
            System.out.println("Comparision not working fine");
        }

        // equals is the righrt comparision approach.
        if((ba1.add(ba2)).equals(BigDecimal.valueOf(0.3)))
        {
            System.out.println("Comparision works fine");
        }
        else
        {
            System.out.println("Comparision not working fine");
        }
        
    }
}
