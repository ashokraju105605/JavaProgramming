import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test9 {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
    }
    class Solution {
        public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
            int pointer = 0;
            List<Double> lis = new ArrayList<>();
            for(List<Integer> point : points){
                if(point.get(0) - location.get(0) == 0 && point.get(1) - location.get(1) == 0) {
                    pointer++; continue;
                }
                lis.add(Math.toDegrees(Math.atan2(point.get(0) - location.get(0), point.get(1) - location.get(1))));
            }
            
            double[] arr = new double[lis.size() * 2];
            int counter = 0, output = pointer;
            for(Double v : lis){
                arr[counter++] = v; arr[counter++] = v + 360;
            }
            Arrays.sort(arr);
            for(int i=0,j=i+1;i<arr.length;i++){
                while(arr[i] - arr[j] > angle) j++;
                output = Math.max(output, pointer+i-j+1);
            }
            return output;
        }
    }
}
