package com.tool.java.leetcode;

import java.util.*;

public class RandomizedSet
{
    Random rand = new Random();
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    
    public RandomizedSet() {

    }

    //add to list and update the hashmap with index, if not presen in hashmap.  
    public boolean insert(int val) 
    {
        if(map.containsKey(val))
        {
            return false;
        }
        map.put(val, list.size()); // since list adds element at last. 
        list.add(val);
         
        
        System.out.println(list);
        System.out.println(map);
        
        return true;
    }

    // idea: swapping with last num in list and update map 
    //if present: get the index of val -> and remove from map and list.remove(index)
    // but removing from list will decrement all the right index by 1. 
    //                  so swap the last number to this postion. 
    //                  update the map last num.
    //                  delete the last index in map.
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int indexToRemove = map.get(val);
        int valueLast = list.get(list.size() - 1);

        list.set(indexToRemove, valueLast);
        list.remove(list.size() - 1);

        map.put(valueLast, indexToRemove);
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        System.out.println(list);
        System.out.println(map);
        return list.get(rand.nextInt(list.size()));
    }
    
    public static void main (String[] args)
    {
        RandomizedSet r = new RandomizedSet();
        System.out.println(r.insert(-1));
        System.out.println(r.insert(-2));
        System.out.println(r.remove(-1));
        
    }
    
}
