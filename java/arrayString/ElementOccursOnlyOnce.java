package com.tool.java.arrayString;

import com.tool.java.matrix_Graph.Util;

public class ElementOccursOnlyOnce
{
    
    //every other element occurs N times
    
    public static void main(String args[]) {
        int[] arr = { 5, 5, 4, 8, 4, 5, 8, 9, 4, 8 };
        System.out.print("Input Matrix : ");
 
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "  ");
 
        System.out.println("\n\nThe number which occured only once is: " + findRequiredNum(arr, 3));
    }
    
    public static int findRequiredNum(int arr[], int N) {
        
        int countSetBit[] = new int[32];  //there are 32 bits in integer
 
        // For each element run the loop.
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < 32; k++) {
                int kthBit = 1 << k;          // this gives kth bit as 1 and rest as 0
                // If the kth bit is set, then increment the count of countSetBit[k].
                if ((arr[i] & kthBit) == kthBit)
                    countSetBit[k]++;
            }
        }
        
        Util.printArray(countSetBit);
         
        // Required number.
        int occurredOnce = 0;
 
        // Iterate over countSetBit.
        for (int k = 0; k < 32; k++) {
            /*
             *  Find the remainder of each element with N so as to see what is
             *  the representation of the single occurred element.
             */
            countSetBit[k] = countSetBit[k] % N;
 
            /*
             * After mod operation, each element of countSetBit represent bits
             * of required element(occurredOnce). Therefore, set ith bit in 
             * occurredOnce if countSetBit[i] is 1.
             */
            if (countSetBit[k] == 1)
                occurredOnce = occurredOnce | (1 << k);
        }
        Util.printArray(countSetBit);
        return occurredOnce;
    }
    

}
