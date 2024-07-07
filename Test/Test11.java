import java.util.*;
public class Test11 {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        Test11 t = new Test11();
        Test11.Solution sol = t.new Solution();
        sol.amountPainted(new int[][]{{1,5},{2,4}});
    }
    class Solution {

        public int[] amountPainted(int[][] paint) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            int[] workload = new int[paint.length];
            for (int i=0;i<paint.length;i++) {
            Integer floorStart = map.floorKey(paint[i][0]);
            Integer floorEnd = map.floorKey(paint[i][1]);
            int start = paint[i][0];
            int end = paint[i][1];
            if (floorStart!=null && map.get(floorStart)>=start) start = floorStart; 
            if (floorEnd!=null && map.get(floorEnd)>=end) end = map.get(floorEnd);

            int sum = 0;
            Map<Integer, Integer> subMap = map.subMap(start, true, end, true);
            for (Map.Entry<Integer, Integer> entry : subMap.entrySet()) {
                sum+=entry.getValue()-entry.getKey();
            }
            workload[i]=end-start-sum;
            subMap.clear();
            map.put(start, end);
            }
            return workload;
        }
    }
}

