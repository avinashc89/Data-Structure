package com.tool.java;


public class Util
{
    
    /* A utility function to print a 2D matrix */
    public static void printMatrix(int mat[][]){ 
        for (int i = 0; i < mat.length; i ++){ 
            for (int j = 0; j < mat[0].length; j ++){ 
                System.out.print( mat[i][j]+"  ," ); 
            } 
                System.out.println(""); 
        } 
    } 
    
    public static void printMatrix(boolean mat[][]){ 
        System.out.println("_____________________");
        for (int i = 0; i < mat.length; i ++){ 
            for (int j = 0; j < mat[0].length; j ++){ 
                System.out.print( mat[i][j]?"T  ":"F  " ); 
            } 
                System.out.println(""); 
        } 
        
        System.out.println("_____________________");
    } 
    
    public static void printArray(int mat[]){ 
        System.out.println("\n_____________________");
        for (int i = 0; i < mat.length; i ++){ 
                System.out.print( mat[i] +"  "); 
                
        } 
        System.out.println("\n_____________________");
    }
    
    public static void printArray(double mat[]){ 
        System.out.println("\n_____________________");
        for (int i = 0; i < mat.length; i ++){ 
                System.out.print( mat[i] +"  "); 
                
        } 
        System.out.println("\n_____________________");
    }
    
    public static void printArray(char mat[]){ 
        System.out.println("\n_____________________");
        for (int i = 0; i < mat.length; i ++){ 
                System.out.print( mat[i] +"  "); 
                
        } 
        System.out.println("\n_____________________");
    }

}
