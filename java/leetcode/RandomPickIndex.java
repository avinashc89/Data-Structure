package com.tool.java.leetcode;

import java.util.*;
import java.util.Random;

public class RandomPickIndex
{
    private int[] nums;

    public RandomPickIndex(int[] nums) {
        this.nums=nums;
    }

    public int pick(int target) {
        
        Random r= new Random();
        int count=0;
        int pick = -1;
        for(int i=0; i<nums.length ; i++)
        {
            if(nums[i]==target)
            {
                count++;
                int x =  r.nextInt(count);
                if(x==0)
                    pick = i;
            }
        }
        return pick;
    }

    public static void main (String[] args)
    {
        int a[] = {2,6,1,46,8,23,67,41,76,32,6,8,2,10,5,67};
        RandomPickIndex r = new RandomPickIndex(a);
        System.out.println(r.pick(6));
    }

    
    private Map<Integer, List<Integer>> map;
    
    
    //using hashmap<int, list of indexex>
    public RandomPickIndex(int[] nums, int x)
    {
        map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) 
                map.put(nums[i], new ArrayList<Integer>()); 
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick1(int target) {
        return map.get(target).get(new Random().nextInt(map.get(target).size()));
    }
    
    

}







