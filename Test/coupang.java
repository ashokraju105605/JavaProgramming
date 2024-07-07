/*
* Given a 0-1 m x n matrix; 0 connected to edges represents ocean/salt water; 0 not connected to edges represents lake/fresh water; 1 represents land; return the number of disconnected lakes
0 1 0
1 0 1  —> 1 lake
0 1 0
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class coupang {
   
 static int[][] mat = {{0,1,0},{1,0,1},{0,1,0}};
 static boolean[][] vis = new boolean[mat.length][mat[0].length];
 static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}}; // four directions 
 public static void main(String[] args) {
     
     int n = mat.length;
     
     for(int i=0;i<mat.length;i++)
        for(int j=0;j<mat[0].length;j++)
        {
            if(i==0 || i== n-1 || j==0 || j== n-1)
            {
                if(mat[i][j]==0)
                    dfs(mat, i,j); // just convert boundary salt water to land;
            }
        }
        
    int count = 0;
    for(int i=0;i<mat.length;i++)
        for(int j=0;j<mat[0].length;j++)
        {
            if(!vis[i][j] && mat[i][j]==0)
            {
                dfs(mat, i,j); // not visited and new lake then count the fresh water lakes
                count++;
            }
        }
    System.out.println("number of fresh lakes : " + count);
   }
   
   static void dfs(int[][] mat, int i, int j)
   {
       vis[i][j] = true;
       mat[i][j] = 1;
       
       for(int k = 0;k<dir.length;k++)
       {
           int nexti = i + dir[k][0];
           int nextj = j + dir[k][1];
           if(nexti >=0 && nexti < mat.length && nextj>= 0 && nextj < mat[0].length)
           {
               if(!vis[nexti][nextj] && mat[nexti][nextj]==0)
               {
                   dfs(mat, nexti,nextj);
               }
           }
       }
   }
}
/*
complextity O ( v + E) 
*/