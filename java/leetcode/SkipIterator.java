package com.tool.java.leetcode;

import java.util.*;

//Using Hashmap to store the skipping nums.
// when findnext is called if the next num is in map, reduce the count and 
class SkipIterator {
    private Iterator<Integer> itr;
    private boolean hasNext;
    private Integer nextElement;
    private Map<Integer, Integer> map = new HashMap<>();
    
    public SkipIterator(Iterator<Integer> itr) {
        this.itr = itr;
        findNext();
    }
    
    public boolean hasNext() {
        return hasNext;
    }
    
    public Integer next() {
        if(!hasNext) return null;
        Integer tmp = nextElement;
        findNext();
        return tmp;
    }
    
    public void skip(int num) {
        if(hasNext) {
            if(nextElement == num) {
                findNext();
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
    }
    
    private void findNext() {
        hasNext = false;
        nextElement = null;
        while(itr.hasNext()) {
            Integer e = itr.next();
            if(map.containsKey(e)) {
                map.put(e, map.get(e) - 1);
                if(map.get(e) == 0) map.remove(e);
            } else {
                hasNext = true;
                nextElement = e;
                return;
            }
        }
    }

}