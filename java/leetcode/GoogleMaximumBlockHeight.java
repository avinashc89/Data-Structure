package com.tool.java.leetcode;

public class GoogleMaximumBlockHeight
{

    //Given the left view and front view of the skyline of a block as two arrays, find the maximum total height of buildings in the block.
    /*
     
     Input: leftView = [4, 2, 3], frontView = [3, 2, 3, 4]
    Output: 31
    
    => 
                3      <=left view
                2
          3 2 3 4
           
             front view
             
        now calcuate total height of the building in that entire block
        
       j   3 2 3 4 
     i 3   3 2 2 3
       2   2 2 2 2
       4   3 2 3 4   => is the highest possible approach
        
        total = 31
        
     */
    
    
    //Method 1: at any particular point the height can be min of height viewed from either side.
    // ie., if I see 4 from front and 3 from left, max height of that building is 3.
    
    int maxSum(int[] left, int[] front)   // O(f*l)
    {
        int res = 0;
        for(int i =0 ; i< front.length ; i++) 
            for(int j=0 ; j< left.length ; j++) 
                res+=Math.min( front[i], left[j]);
        
        return res;
     }
    
    
    //method 2: sort and calculate prefix sum of front.
    
    /*
         1. sort front
         2. calculate prefix sum
            num      => 2 3 3 4
            pref sum => 2 5 8 12
         3. for each num in Left, find in front using binary search, get the prefix sum. Apply formula (ps + num * (len-index))
             4 => 12 + 4 * (3-3) => 12  
             2 => 2 +  2 * (3-0) => 8                    
             3 => 5 + 3 * (3-1)  or 8 + 3*(3-2) => 11 
             
             logic is, when we chose corresponding prefix sum (say 8), 
             we have already finished for 3 building.So we need the hight of one more building , which can be only 3
             8+3 => 11
             
            T: O(flogf + llogf)  S: O(f)
             
      
     */
    

}
