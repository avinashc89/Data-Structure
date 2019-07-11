package com.tool.java.leetcode;

import java.util.*;

public class RandomBlackList
{
    
    Map<Integer, Integer> map;
    Random random = new Random();
    int bound;
    public RandomBlackList(int N, int[] blacklist) {
        map = new HashMap<Integer, Integer>();
        bound = N-blacklist.length;     // allowed values length
        
        Set<Integer> set = new HashSet<>();
        for (int i: blacklist){
            set.add(i);
        }
        int idx = N-1;
        for (int i: blacklist){
            if (i < N-blacklist.length){
                while(set.contains(idx)){
                    idx--;
                }
                map.put(i, idx);
                idx--;
            }
        }
    }
    
    public int pick() {
        int r = random.nextInt(bound);
        return map.getOrDefault(r, r);
    }
    
    
    public static void main (String[] args)
    {
        RandomBlackList r = new RandomBlackList(20, new int[]{4,5,7,2,17,13} );
    }
}
