package com.tool.java.leetcode;

import java.util.*;

public class GoogleCokeMachine
{

    /*
     
     Input: buttons = [[100, 120], [200, 240], [400, 410]], target = [100, 110]
    Output: false
    Explanation: if we press first button it might give us 120 volume of coke, not in the target range.
    
    Input: buttons = [[100, 120], [200, 240], [400, 410]], target = [90, 120]
    Output: true
    Explanation: press first button and you will always get amount of coke in the target range.
    
    Input: buttons = [[100, 120], [200, 240], [400, 410]], target = [310, 359]
    Output: false
    Explanation: we can press 1st button 3 times or 1st and 2nd button but it's possible to get only 300, not in the target range.
     */
    
    public static boolean coke(int[][] buttons, int[] target) {
        return coke(buttons, new int[2], target, new HashSet<>());
    }

    private static boolean coke(int[][] buttons, int[] curr, int[] target, Set<String> memo) {
        if (curr[0] >= target[0] && curr[1] <= target[1]) 
            return true;
       
        if (curr[1] > target[1]) 
            return false;

        String key = curr[0] + "-" + curr[1];
        if (memo.contains(key)) 
            return false;

        for (int[] button : buttons) {
            curr[0] += button[0];
            curr[1] += button[1];
            if (coke(buttons, curr, target, memo)) 
                return true;
            curr[0] -= button[0];
            curr[1] -= button[1];
        }
        memo.add(key);
        return false;
    }
    
    public static void main(String[] args) {
        int[][] buttons = {{100, 120}, {200, 240}, {400, 410}};
        int[] target = {290, 360};
        System.out.println(coke(buttons, target));
    }
}
