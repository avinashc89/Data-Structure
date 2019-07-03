package com.tool.java.leetcode;


public class UniquePath
{
    
    
    //total unique path without obstacles
    public int uniquePathsWithoutObstacles(int n,int m){
        int T[][] = new int[n+2][m];
        
        T[n][0] = 1;
        for(int j=1; j < m; j++){
            for(int i=n; i > 0 ; i--){
//                System.out.println(i+","+j);
                T[i][j] = T[i-1][j-1] + T[i+1][j-1] + T[i][j-1] ;
            }
        }
        return T[n][m-1];
    }
    /*
     [[0, 0, 0, 0, 0], 
     [0, 0, 0, 1, 4], 
     [0, 0, 1, 3, 9], 
     [0, 1, 2, 5, 12], 
     [1, 1, 2, 4, 9],
      [0, 0, 0, 0, 0]]
     */
    
    //total unique path with obstacles
    public int uniquePathsWithObstacles(int[][] arr) {
        
        if(arr==null||arr.length==0)
            return 0;
     
        int n = arr.length;
        int m = arr[0].length;

        int T[][] = new int[n+2][m];
        T[n][0] = 1;
        
        for(int j=1; j < m; j++){
            for(int i=n; i > 0 ; i--){
//                System.out.println(i+","+j);
                if(arr[i-1][j] == 0)
                    T[i][j] = 0;
                else
                    T[i][j] = T[i-1][j-1] + T[i+1][j-1] + T[i][j-1] ;
            }
        }
        return T[n][m-1];
    }
    
  //total unique path with obstacles
    public int uniquePathsWithObstaclesWithTouchingLine(int[][] arr, int top) {
        
        if(arr==null||arr.length==0)
            return 0;
     
        int n = arr.length;
        int m = arr[0].length;

        int T[][] = new int[n+2][m];
        T[n][0] = 1;
        
        for(int j=1; j < m; j++){
            for(int i=n; i > 0 ; i--){
//                System.out.println(i+","+j);
                if(arr[i-1][j] == 0)
                    T[i][j] = 0;
                else
                    T[i][j] = T[i-1][j-1] + T[i+1][j-1] + T[i][j-1] ;
            }
        }
        
        int count = 0;
        int start = n-top;
        int end = m-1-(n-top);
        for (int i = start ; i<= end ; i++)
        {
            count += T[top][i];
        }

            
        return count;
    }
    
    /*
     [[0, 0, 0, 0, 0], 
     [0, 0, 0, 0, 2], 
     [0, 0, 0, 2, 6], 
     [0, 1, 2, 4, 10], 
     [1, 1, 2, 4, 8], 
     [0, 0, 0, 0, 0]]
     */
    
    public static void main(String args[]){
        UniquePath nop = new UniquePath();
        //System.out.println(nop.uniquePathsWithoutObstacles(4,5));
        
        int[][] grid = {{1,1,1,1,1},
                        {1,1,0,1,1},
                        {1,1,1,1,1},
                        {1,1,1,1,1}
        };
        /*
         [[0, 0, 0, 0, 0], 
         [0, 0, 0, 0, 2], 
         [0, 0, 0, 2, 6], 
         [0, 1, 2, 4, 10], 
         [1, 1, 2, 4, 8], 
         [0, 0, 0, 0, 0]]
         */
        
        int[][] grid1 = {{1,1,1,1,1,1,1,1,1},
                        {1,1,0,1,1,1,1,1,1},
                        {1,1,1,1,1,1,0,1,1},
                        {1,0,1,1,1,1,1,1,1}
        };
        /*
         [[0, 0, 0, 0, 0, 0, 0, 0, 0], 
         [0, 0, 0, 0, 1, 4, 13, 38, 76], 
         [0, 0, 0, 1, 3, 9, 25, 38, 122], 
         [0, 1, 1, 2, 5, 12, 0, 46, 105], 
         [1, 0, 1, 2, 4, 9, 21, 21, 67], 
         [0, 0, 0, 0, 0, 0, 0, 0, 0]]
         */
       // System.out.println(nop.uniquePathsWithObstacles(grid));
        System.out.println(nop.uniquePathsWithObstaclesWithTouchingLine(grid1,1));
        
    }

}
