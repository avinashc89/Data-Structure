package com.tool.java.leetcode;

import java.util.*;

public class RandomizedSet2  // duplicates allow. use hashset to store the indeces
{
    Random rand = new Random();
    List<Integer> list = new ArrayList<>();
    Map<Integer, Set<Integer>> map = new HashMap<>();

    
    public RandomizedSet2() {

    }

    //add to list and create/update the hashmap with index. if set size is 1 return true, else false.  
    public boolean insert(int val) 
    {
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>()); 
        }
        map.get(val).add(list.size());      // since list adds element at last. 
        list.add(val);
         
        return map.get(val).size() == 1;
    }

    // idea: swapping with last num in list and update map 
    // get the val's next index.
    // get the lastnum. 
    //  update the list with lastnum at index.
    //  put val's index in lastnum's set and remove last index(list.size())
    //  remove the index from val's set
    public boolean remove(int val)
    {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }

        int index = map.get(val).iterator().next();
        int lastnum = list.get(list.size() - 1);          //get the last num in list. this map of this num contains list.size() in hashset

        
        list.set(index, lastnum);
        list.remove(list.size() - 1);

        // update Map for val: remove indexToRemove.
        map.get(val).remove(index);     
        
        // update Map for valueLast: add indexToRemove and remove lastindex. 
        map.get(lastnum).add(index);
        map.get(lastnum).remove(list.size());
        
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
    
    
    
    public static void main (String[] args)
    {
        RandomizedSet2 r = new RandomizedSet2();
        System.out.println(r.insert(-1));
        System.out.println(r.insert(-2));
        System.out.println(r.remove(-1));
        
    }
    
}
