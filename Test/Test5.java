public class Test5 {
    
}

/*
 * Click `Run` to execute the snippet below!
 */

 import java.io.*;
 import java.util.*;
 
 /*
  * To execute Java, please define "static void main" on a class
  * named Solution.
  *
  * If you need more classes, simply define them inline.
  */
 
 class Solution {
   public static void main(String[] args) {
     int[][] mat = {{0,0,0,0,0},
                    {0,0,1,0,0},
                    {0,0,1,0,0},
                    {0,0,1,0,0},
                    {0,0,0,0,0}};
 
     solve(mat);
   }
   public static void solve(int[][] mat)
   {
     Queue<int[]> live = new LinkedList<int[]>();
     Queue<int[]> dead = new LinkedList<int[]>();
 
     for(int i=0;i<mat.length;i++)
     {
       for(int j=0;j<mat[0].length;j++)
       {
         if(mat[i][j]==1)
         {
           int liveneighs = count(mat, i,j);
           if(liveneighs == 0 || liveneighs == 1)
             live.add(new int[]{i,j});
           else if(liveneighs > 3)
             live.add(new int[]{i,j});
         }
         else
         {
           int liveneighs = count(mat,i,j);
           if(liveneighs == 3)
             dead.add(new int[]{i,j});
         }
       }
     }
 
     while(!live.isEmpty())
     {
       int[] pos = live.poll();
       mat[pos[0]][pos[1]] = 0;
     }
     while(!dead.isEmpty())
     {
       int[] pos = dead.poll();
       mat[pos[0]][pos[1]] = 1;
     }
 
     for(int i=0;i<mat.length;i++)
     {
       for(int j=0;j<mat[0].length;j++)
       {
         System.out.print(mat[i][j] + " ");
       }
       System.out.println();
     }
   }
   public static int count(int[][] mat, int i,int j)
   {
     int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
     int count = 0;
     for(int[] d: dir)
     {
       if(i+d[0]>=0 && i+d[0] < mat.length && j+d[1]>=0 && j+d[1]<mat[0].length)
       {
         if(mat[i+d[0]][j+d[1]] == 1)
           count++;
       }
     }
     return count;
   }
 }
 
 // Any live cell with fewer than two live neighbours dies, as if by underpopulation.(1,0 live neighbors=> dead)
 // Any live cell with two or three live neighbours lives on to the next generation. (2,3 live neighbors=> lives for next gen)
 // Any live cell with more than three live neighbours dies, as if by overpopulation.(4,5,6... live neighbors => dead)
 // Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction. ( 3 live neighbors => live)
 
 
 // 8 neighbours for a cell
 // only 2 kinds of cells, live/dead. 
 
 // 00000
 // 00100
 // 00100
 // 00100
 // 00000
 /*
 live queue - top1, bottom1 
 
 dead queue - left0 of middle 1, right0 of middle 1 
 
 // 00000
 // 00000
 // 01110
 // 00000
 // 00000
 
 */
 
 // [(1,2), (2,2), (2,3), (-100000000,10000000)] => [(2,1), (2,2), (2,3)]
 
 
 class Solution1 {
   public static void main(String[] args) {
     int[][] mat = {{0,0,0,0,0},
                    {0,0,1,0,0},
                    {0,0,1,0,0},
                    {0,0,1,0,0},
                    {0,0,0,0,0}};
 
     solve(mat);
   }
   public static void solve(int[][] mat)
   {
     Queue<int[]> live = new LinkedList<int[]>();
     Queue<int[]> dead = new LinkedList<int[]>();
 
     ArrayList<int[]> list = new ArrayList<>(); // input list of cartesian points
       for(int[] elem: list)
       {
         if(mat[i][j]==1) // don't need the check
         {
           int liveneighs = count(mat, i,j);
           if(liveneighs == 0 || liveneighs == 1)
             live.add(new int[]{i,j});
           else if(liveneighs > 3)
             live.add(new int[]{i,j});
 
           // loop through 8 nerighbors and check if it is zero and do the zero's processing.
           if()
           {
             int liveneighs = count(mat,i,j);
             if(liveneighs == 3)
               dead.add(new int[]{i,j});
           }
         }
 
       }
 
     while(!live.isEmpty())
     {
       int[] pos = live.poll();
       mat[pos[0]][pos[1]] = 0; // need to remove the data point from the input list.
     }
     while(!dead.isEmpty())
     {
       int[] pos = dead.poll();
       mat[pos[0]][pos[1]] = 1; // add the position into the inputlist as is.
     }
 
 
   }
   public static int count(int[][] mat, int i,int j)
   {
     int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
     int count = 0;
     for(int[] d: dir)
     {
         if(mat[i+d[0]][j+d[1]] == 1)
           count++;
     }
     return count;
   }
 }

//
// https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life