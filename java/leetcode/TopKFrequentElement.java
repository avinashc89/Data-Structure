package com.tool.java.leetcode;

import java.util.*;

public class TopKFrequentElement
{
    /* method 1 : 
       first use the hashmap to get the frequency. then we can create buckets array of frquency bucket (arraylist)
       
       1,1,4,1,2,4,2,3,4 => 1 -3 ; 2 -2; 3 -1; 4-3
       
       array of freq bucket of size (3) => _ _ _ _
       traverse map and put in the key in corresponding bucket list => _  3  2  1,4
       
       from back, traverse till k and print the top k freq elements
    
    */
    //methos2: Using freq map and priority queue o(nlogk)
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        if (nums == null || nums.length == 0 || k <= 0) return null;
        
        // count frequencies by map, use foreach
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // boundary check again
        if (k > map.size()) return null;
        
        // create a priority queue(min heap with regard to map.values())
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((i1,i2) -> map.get(i1) - map.get(i2));
        for (Integer key : map.keySet()) 
        {
            q.offer(key);
            
            // if the queue is > k, then remove the key with smallest freq
            if (q.size() > k) 
                q.poll();
        }
        
        // create result list
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty())
            res.add(0, q.remove());
        
        return res;
    }

}
