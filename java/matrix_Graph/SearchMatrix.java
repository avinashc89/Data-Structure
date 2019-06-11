package com.tool.java.matrix_Graph;


public class SearchMatrix
{
    
    /*
     Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

        1.Integers in each row are sorted in ascending from left to right.
        2. Integers in each column are sorted in ascending from top to bottom.
     
     Time Complexity: O(m + n) 
     */
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length-1;
        int n=matrix[0].length-1;
     
        int i=m; 
        int j=0;
     
        while(i>=0 && j<=n){
            if(target < matrix[i][j]){
                i--;
            }else if(target > matrix[i][j]){
                j++;
            }else{
                return true;
            }
        }
     
        return false;
    }
    
    

}
