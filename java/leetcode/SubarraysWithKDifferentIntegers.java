package com.tool.java.leetcode;

import java.util.*;

public class SubarraysWithKDifferentIntegers
{
    //instead of 
    public static int subarraysWithKDistinct(int[] arr, int k)
    {
        int[] count = new int[arr.length+1];
        int unique=0;
        int i=0 ; 
        int total=0;
        int good=0;
        for(int j=0; j<arr.length; j++)
        {
            int num =arr[j] ;
            if(count[num]==0) 
                unique++;
            
            count[num] = count[num]+1;
            
            if(unique > k)
            {
                count[arr[i++]]--;
                unique--;
                good=0;
            }
           
            while(count[arr[i]]>1){
                count[arr[i]]--;
                i++;
                good++;
            }
            
            if(unique==k) 
                total += good+1;
        }
        return total;
    }

    
    
    /*
     Let f(x) denote the number of subarrays with x or less distinct numbers.
        ans = f(K) – f(K-1)
        
        ie., F(4) = contains atleast 4 digitis
             F(3) = contains atleast 3 digits
             ans = F(4) - F(3)
             
     */
    public static int subarraysWithKDistinct1(int[] a, int k) {
        return atmostK(a,k) - atmostK(a,k-1);
    }
    
    //Using hashmap <num,count>
    public static int atmostK(int[] a, int k)
    {
        int start=0, end=0;
        Map<Integer, Integer> t = new HashMap<>();
        int ans = 0;
        while(end < a.length) 
        {
            if(t.containsKey(a[end]))
                t.put(a[end], t.get(a[end])+1);
            else
                t.put(a[end],1);    
            end++;
            while(t.size() > k) 
            {
                t.put(a[start], t.get(a[start])-1);
                t.remove(a[start],0);
                start++;
            }
            ans += end-start;
        }
        return ans;
    }
    
    public static void main (String[] args)
    {
        System.out.println(subarraysWithKDistinct(new int[]{5,7,7,2,3,3,4,1,5,2,7,4,6,2,3,8,4,5,7}, 7));
    }

}
