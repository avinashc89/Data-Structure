package com.tool.java.arrayString.numbers;

import java.util.Collections;
import java.util.HashMap;

public class FruitInBasket
{
    /*
     
     Input: [1,2,1]
    Output: 3
    Explanation: We can collect [1,2,1].
    
    given 2 baskets => Java-Longest-Subarray-with-atmost-2-Distinct-elements

            3,3,3,1,2,1,1,2,3,3,4
        start
          end
      
      move the end and add to hashmap<num,index>. 
          when hashmap size is > 2, remove the one with lesser index 
                  => move start index to that lesser index.
     */
    
    public static int totalFruit(int[] tree) {
        int start = 0;
        int n = tree.length;
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int end = 0; end < n; end++) {
            map.put(tree[end], end);
            if (map.size() > 2) {
                int minIndex = Collections.min(map.values());
                map.remove(tree[minIndex]);
                start = minIndex + 1;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
    
    public static void main (String[] args)
    {
        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }

}
