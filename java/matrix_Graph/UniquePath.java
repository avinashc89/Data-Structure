package com.tool.java.matrix_Graph;


public class UniquePath
{
    
    public int countPathsRecursive(int n, int m){
        if(n == 1 || m == 1){
            return 1;
        }
        return countPathsRecursive(n-1, m) + countPathsRecursive(n, m-1);
    }
    
    public int countPaths(int n,int m){
        int T[][] = new int[n][m];
        for(int i=0; i < n; i++){
            T[i][0] = 1;
        }
        
        for(int i=0; i < m; i++){
            T[0][i] = 1;
        }
        for(int i=1; i < n; i++){
            for(int j=1; j < m; j++){
                T[i][j] = T[i-1][j] + T[i][j-1];
            }
        }
        return T[n-1][m-1];
    }
    
    //with obstacles
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
        UniquePath nop = new UniquePath();
        System.out.print(nop.countPathsRecursive(3,3));
        
    }

}
