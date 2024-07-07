import java.util.*;

public class Test1
{
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");

        ArrayList<Integer> al = new ArrayList<>();
        
        // java.lang.IndexOutOfBoundsException: Index 5 out of bounds for length 0
        // al.set(5, 32);

        System.out.println(al);
        System.out.println(orangesRotting(new int[][]{{0,1,2},{0,1,2},{2,1,1}}));
    }

    public static int orangesRotting(int[][] grid)
    {
        // Code here
        int[][] d4 = {{-1,0},{0,1},{1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int time=0;
        
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j] == 2)
                    q.add(new int[]{i,j});
            }
        while(!q.isEmpty())
        {
            time++;
            int count = q.size();
            while(count-->0)
            {
                int[] rot = q.poll();
                for(int k=0;k<d4.length;k++)
                {
                    int adj[] = new int[]{rot[0]+d4[k][0], rot[1]+d4[k][1]};
                    if(adj[0]>=0 && adj[0]<grid.length && adj[1]>=0 && adj[1]<grid[0].length && grid[adj[0]][adj[1]] == 1)
                    {
                        grid[adj[0]][adj[1]] = 2;
                        q.add(new int[]{adj[0],adj[1]});
                    }
                }
                
            }
        }
        
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j] == 1)
                    return -1;
            }
        return time;
    }
}