package com.tool.java.leetcode;

import java.util.*;

public class TopKFrequentWord
{
    // if the freq is same the output should be alphabetically ordered
    
    /* method 1 : 
       first use the hashmap to get the frequency. then we can create buckets array of frquency bucket (arraylist)
       
       1,1,4,1,2,4,2,3,4 => 1 -3 ; 2 -2; 3 -1; 4-3
       
       array of freq bucket of size (3) => _ _ _ _
       traverse map and put in the key in corresponding bucket list => _  3  2  1,4
       
       from back, traverse till k and print the top k freq elements
    
    */
    //methos2: Using freq map and priority queue o(nlogk)
    
        public static List<String> topKFrequent(String[] words, int k) {
        
        
        if (words == null || words.length == 0 || k <= 0) return null;
        
        // count frequencies by map, use foreach
        Map<String, Integer> map = new HashMap<>();
        for (String i : words) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // boundary check again
        if (k > map.size()) return null;
        
        // create a priority queue(min heap with regard to map.values())
        
        
        
        PriorityQueue<String> q = new PriorityQueue<String>((i1,i2) -> {return (map.get(i1)== map.get(i2))?i2.compareTo(i1):map.get(i1) - map.get(i2);});
        for (String key : map.keySet()) 
        {
            q.offer(key);
            
            // if the queue is > k, then remove the key with smallest freq
            if (q.size() > k) 
                q.poll();
        }
        
        // create result list
        List<String> res = new ArrayList<>();
        while(!q.isEmpty())
            res.add(0,q.remove());
        
        return res;
    }
        
    public static void main (String[] args)
    {
        topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
    }

}
