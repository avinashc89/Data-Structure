package com.tool.java.leetcode;


public class UniquePath2
{
    /*
     Input:
        [
          [0,0,0],
          [0,1,0],
          [0,0,0]
        ]
        Output: 2

        No of ways to travel from top-left to right-bottom. if 1 is obstacle
        
        Using DP. create new T[][]. 
        T(0,0) = 1. for first row & first column i.j =1. 
        
        for every i,j => T(i-1,j) + T(i,j-1)  + T(i-1,j-1) ways. 
                if grid(i,j==1) => T[i,j] =0.
     */
    
    
    //total unique path with obstacles
    public int uniquePathsWithObstacles(int[][] arr) {
        if(arr==null||arr.length==0)
            return 0;
        
        int m = arr.length;
        int n = arr[0].length;
     
        if(arr[0][0]==1||arr[m-1][n-1]==1) 
            return 0;
     
     
        int[][] T = new int[m][n];
        T[0][0]=1;
     
        //left column
        for(int i=1; i<m; i++){
            if(arr[i][0]==1){
                T[i][0] = 0;
            }else{
                T[i][0] = T[i-1][0];
            }
        }
     
        //top row
        for(int i=1; i<n; i++){
            if(arr[0][i]==1){
                T[0][i] = 0;
            }else{
                T[0][i] = T[0][i-1];
            }
        }
     
        //fill up cells inside
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(arr[i][j]==1){
                    T[i][j]=0;
                }else{
                    T[i][j]=T[i-1][j]+T[i][j-1];
                }
     
            }
        }
     
        return T[m-1][n-1];
    }
    
    public static void main(String args[]){
        UniquePath2 nop = new UniquePath2();
        
    }

}
