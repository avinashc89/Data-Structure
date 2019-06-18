package com.tool.java.arrayString.numbers;

import com.tool.java.matrix_Graph.Util;

public class PrintDuplicates
{
    
    static void printDuplicates(int arr[], int n) 
    { 
        int i; 
      
        int fl = 0; // to print -1 if flag is not set - no duplicates found
        for (i = 0; i < n; i++)  
        { 
            if (arr[arr[i] % n] >= n)  
            { 
                if (arr[arr[i] % n] < 2 * n)  
                { 
                    System.out.print( arr[i] % n + " "); 
                    fl = 1; 
                } 
            } 
            arr[arr[i] % n] += n; 
            
            Util.printArray(arr);
        } 
      
        // If flag variable is not set 
        // then no repeating element is 
        // found. So print -1. 
        if (!(fl > 0)) 
            System.out.println("-1"); 
    } 
    
    public static void main (String[] args)  
    { 
        int arr[] = { 1, 6, 3, 1, 3, 6, 6 }; 
        int arr_size = arr.length; 
        printDuplicates(arr, arr_size); 
    } 

}
