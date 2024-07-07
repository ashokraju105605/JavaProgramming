public class Test10 {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        System.out.println(maxPoints(new int[][]{{1,2,3},{1,5,1},{3,1,1}}));
    }
    public static long maxPoints(int[][] points) {
        int row = points.length;
        int col = points[0].length;
        long[] cur = new long[col];
        for(int i=0; i<row; i++){
            cur[0] += points[i][0];
            for(int j=1; j<col; j++)
                cur[j] = Math.max(cur[j-1]-1, cur[j]+points[i][j]);
            for(int j=col-2; j>=0; j--)
                cur[j] = Math.max(cur[j+1]-1, cur[j]);
        }
        
        long max = 0;
        for(long val: cur) max = Math.max(max, val);
        return max;
    }
}
