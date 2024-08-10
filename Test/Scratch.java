import java.util.*;
public class Scratch {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        List<Integer> nums = List.of(1,2,3,4,5);
        boolean validate = nums.stream().anyMatch(num -> num == 5);
        boolean validate1 = nums.stream().allMatch(num -> num <=5);
        boolean validate2 = nums.stream().noneMatch(num -> num == 6);
    }
    
}
