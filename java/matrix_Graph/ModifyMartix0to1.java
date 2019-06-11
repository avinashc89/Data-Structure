package com.tool.java.matrix_Graph;


public class ModifyMartix0to1
{
    
    public static void modifyMatrix(int mat[][]){ 
        
        // variables to check if there are any 1  
        // in first row and column 
        boolean row_flag = false; 
        boolean col_flag = false; 
                  
        // updating the first row and col if 1 
        // is encountered 
        for (int i = 0; i < mat.length; i++ ){ 
                for (int j = 0; j < mat[0].length; j++){ 
                        if (i == 0 && mat[i][j] == 1) 
                            row_flag = true; 
                          
                        if (j == 0 && mat[i][j] == 1) 
                            col_flag = true; 
                          
                        if (mat[i][j] == 1){ 
                              
                            mat[0][j] = 1; 
                            mat[i][0] = 1; 
                        }
                        
                        System.out.println("step -");
                        printMatrix(mat); 
                          
                    } 
                } 
        System.out.println("step -");
        printMatrix(mat); 
                  
        // Modify the input matrix mat[] using the  
        // first row and first column of Matrix mat 
        for (int i = 1; i < mat.length; i ++){ 
                for (int j = 1; j < mat[0].length; j ++){ 
                          
                    if (mat[0][j] == 1 || mat[i][0] == 1){ 
                            mat[i][j] = 1; 
                        } 
                    } 
                } 
                  
        // modify first row if there was any 1 
        if (row_flag == true){ 
            for (int i = 0; i < mat[0].length; i++){ 
                        mat[0][i] = 1; 
                    } 
                } 
                  
        // modify first col if there was any 1 
        if (col_flag == true){ 
            for (int i = 0; i < mat.length; i ++){ 
                        mat[i][0] = 1; 
            } 
        } 
    } 
              
    /* A utility function to print a 2D matrix */
    public static void printMatrix(int mat[][]){ 
        for (int i = 0; i < mat.length; i ++){ 
            for (int j = 0; j < mat[0].length; j ++){ 
                System.out.print( mat[i][j] ); 
            } 
                System.out.println(""); 
        } 
    } 
              
    // Driver function to test the above function 
    public static void main(String args[] ){ 
                  
        int mat[][] = {{0, 0, 1, 0}, 
                {0, 1, 1, 0}, 
                {0, 0, 0, 0}}; 
                  
        System.out.println("Input Matrix :"); 
        printMatrix(mat); 
              
        modifyMatrix(mat); 
              
        System.out.println("Matrix After Modification :"); 
        printMatrix(mat); 
              
    } 

}
