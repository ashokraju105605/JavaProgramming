package LearnBasics;
import java.time.*;
public class DateTimeUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");

        System.out.println(java.time.LocalTime.now());

        System.out.println(java.time.LocalDate.now());

        System.out.println(java.time.LocalDateTime.now());

        System.out.println(java.time.Clock.systemUTC().instant());

        long millis = System.currentTimeMillis();  

        System.out.println(millis);



        Instant instant = Instant.parse("2017-02-03T11:25:30.00Z");  
        instant = instant.minus(Duration.ofDays(125));  
        System.out.println(instant);   
    }
}
