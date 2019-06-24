package com.tool.java.leetcode;

public class CountFrequency
{
    
    /*
     
     check a[i],
     if <0 then move on, since processed
     lets say  6 -> then go to index 5 (a[i]-1) and put -1
             if index 5 has number then place in a[i] and then put -1
             if index 5 has -1 then decrement it to -2 and no need to store any thing in a[i] , so a[i] =0 and move on
     
     */
    
    
    public static void findCounts(int arr[], int n)  
    { 
        // Traverse all array elements 
        int i = 0; 
        while (i < n)  
        { 
            // If this element is already processed, 
            // then nothing to do 
            if (arr[i] <= 0)  
            { 
                i++; 
                continue; 
            } 
  
            int elementIndex = arr[i] - 1; 
  
            // If the elementIndex has an element >-1
            if (arr[elementIndex] > 0)  
            { 
                arr[i] = arr[elementIndex]; 
  
                // After storing arr[elementIndex], change it 
                // to store initial count of 'arr[i]' 
                arr[elementIndex] = -1; 
            }  
            else 
            { 
                // If this is NOT first occurrence of arr[i], 
                // then decrement its count. 
                arr[elementIndex]--; 
  
                // And initialize arr[i] as 0 means the element 
                // 'i+1' is not seen so far 
                arr[i] = 0; 
                i++; 
            } 
        } 
  
        System.out.println("Below are counts of all elements"); 
        for (int j = 0; j < n; j++) 
            System.out.println(j+1 + "->" + Math.abs(arr[j])); 
    } 
    
    
    public static void main(String[] args)  
    { 
        int arr[] = {2, 3, 3, 2, 5}; 
        findCounts(arr, arr.length); 
  
    }
}
