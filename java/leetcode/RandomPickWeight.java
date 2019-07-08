package com.tool.java.leetcode;

import java.util.Random;
import java.util.TreeMap;

public class RandomPickWeight
{
    //explanation in RandomPointInRectangle.java
    int[] prefix;
    Random rand;

    public RandomPickWeight(int[] w) {
        rand = new Random();
        prefix = new int[w.length];
        prefix[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefix[i] = prefix[i-1] + w[i];
        }
    }
    
    public int pickIndex() {
        int val = rand.nextInt(prefix[prefix.length-1]); // total = prefix[prefix.length-1]
        int l = 0;
        int r = prefix.length - 1;        
        // invariant: prefix:(0, l) <= val && val < prefix:[r, ...)
        while (l < r) {
            int m = l+(r-l)/2;            
            if (prefix[m] <= val) {
                l = m+1;
            } else {
                r = m;
            }
        }
        return r;
    }
   
    
    public static void main (String[] args)
    {
        RandomPickWeight w =  new RandomPickWeight(new int[]{1,3,2,1,4,5,2,3});
        System.out.println(w.pickIndex());
    }
}
