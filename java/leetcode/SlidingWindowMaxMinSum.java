package com.tool.java.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaxMinSum
{
    
    public static int SumOfKsubArray(int arr[] , int k)  
    {  
        int sum = 0;  // Initialize result  
        
        // 2, 5, -1, 7, -3, -1, -2
        //
        // The queue will store indexes of useful elements  
        // in every window  
        // In deque 'G' - we have 1,2 -> increasing subarray from reverse
        // In deque 'S' - we have  2  -> decreasing subarray from reverse
        // once done, first element in both will have max and min respectively.G -1; S-2 
        
        Deque<Integer> S=new LinkedList<>();
        Deque<Integer>   G=new LinkedList<>(); 
  
        // Process first window of size K  
        int i = 0;  
        for (i = 0; i < k; i++)  
        {  
            // Remove all previous greater elements  
            // that are useless.  
            while ( !S.isEmpty() && arr[S.peekLast()] >= arr[i])  
                S.removeLast(); // Remove from rear  
    
            // Remove all previous smaller that are elements  
            // are useless.  
            while ( !G.isEmpty() && arr[G.peekLast()] <= arr[i])  
                G.removeLast(); // Remove from rear  
    
            // Add current element at rear of both deque  
            G.addLast(i);  
            S.addLast(i);  
        } 
        
        System.out.println(S);
        System.out.println(G);
    
        // Process rest of the Array elements  
        for (  ; i < arr.length; i++ )  
        {  
            // Element at the front of the deque 'G' & 'S'  
            // is the largest and smallest  
            // element of previous window respectively  
            sum += arr[S.peekFirst()] + arr[G.peekFirst()];  
    
            // Remove all elements which are out of this  
            // window  
            while ( !S.isEmpty() && S.peekFirst() <= i - k)  
                S.removeFirst();  
            while ( !G.isEmpty() && G.peekFirst() <= i - k)  
                G.removeFirst();  
    
            // remove all previous greater element that are  
            // useless  
            while ( !S.isEmpty() && arr[S.peekLast()] >= arr[i])  
                S.removeLast(); // Remove from rear  
    
            // remove all previous smaller that are elements  
            // are useless  
            while ( !G.isEmpty() && arr[G.peekLast()] <= arr[i])  
                G.removeLast(); // Remove from rear  
    
            // Add current element at rear of both deque  
            G.addLast(i);  
            S.addLast(i);  
        }  
    
        // Sum of minimum and maximum element of last window  
        sum += arr[S.peekFirst()] + arr[G.peekFirst()];  
    
        return sum;  
    }  
  
    public static void main(String args[])  
    { 
        int arr[] = {2, 5, -1, 7, -3, -1, -2} ;  
        int k = 3;  
        System.out.println(SumOfKsubArray(arr, k)); 
    }

}
