package com.tool.java.leetcode;

import java.util.*;

public class LexicographicalNumber
{

    /*
         given 14 => 1,10,11,12,13,14,2,3,4,5,6,7,8,9
         
         dfs(1)
             => dfs(10)             since we need 1, 10, 100, 101,..
                 =>dfs(100)
         if(curr%10 < 9)
             dfs(1+1);
     */
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        dfs(res, n, 1);
        System.out.println(res.size());
        return res;
    }
    
    private void dfs(List<Integer> res, int n, int cur) {
        if(cur > n) 
            return;
        res.add(cur);
        dfs(res, n, cur * 10);
        if(cur % 10 < 9)                    // if curr is 9 => 9%10 =9 we need to stop here.                
            dfs(res, n, cur + 1);
    }
    
    public static void main (String[] args)
    {
        LexicographicalNumber l = new LexicographicalNumber();
        System.out.println(l.lexicalOrder(43));
    }
}
