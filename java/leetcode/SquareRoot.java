package com.tool.java.leetcode;

public class SquareRoot
{
    //using binary search.
    public static int floorSqrt(int x) 
    { 
        // Base Cases 
        if (x == 0 || x == 1) 
            return x; 
  
        int start = 1, end = x, ans=0; 
        while (start <= end) 
        { 
            int mid = (start + end) / 2; 
  
            // If x is a perfect square 
            if (mid*mid == x) 
                return mid; 
  
            // Since we need floor, we update answer when mid*mid is 
            // smaller than x, and move closer to sqrt(x) 
            if (mid*mid < x) 
            { 
                start = mid + 1; 
                ans = mid; 
            } 
            else   // If mid*mid is greater than x 
                end = mid-1; 
        } 
        return ans; 
    } 
    
    
    //we can even consider end =x/2,since Floor of square root of x cannot be more than x/2 when x > 1.

}
