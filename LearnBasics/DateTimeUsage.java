package LearnBasics;
import java.text.SimpleDateFormat;
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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
        String formattedDate = sdf.format(new java.util.Date());
        System.out.println("Formatted Date: " + formattedDate);

        LocalDate futureDate = LocalDate.now().plusDays(7); // ✅ Add 7 days
        LocalDate pastDate = LocalDate.now().minusMonths(1); // ✅ Subtract 1 month
        LocalTime futureTime = LocalTime.now().plusHours(2); // ✅ Add 2 hours

        LocalDate startDate = LocalDate.of(2024, 6, 1);
        LocalDate endDate = LocalDate.of(2025, 6, 7);

        Period difference = Period.between(startDate, endDate);
        System.out.println("Years: " + difference.getYears() + ", Months: " + difference.getMonths() + ", Days: " + difference.getDays());

        DayOfWeek day = LocalDate.of(2025, 6, 7).getDayOfWeek();
        System.out.println("Day: " + day); // ✅ Output: SATURDAY

        LocalDate today = LocalDate.now();
        LocalDate givenDate = LocalDate.of(2025, 6, 7);

        System.out.println(today.isBefore(givenDate)); // ✅ true
        System.out.println(today.isAfter(givenDate));  // ❌ false
    }
}
