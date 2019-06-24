package com.tool.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedChunks
{
    
    public List<Integer> mergeUsingHeap(List<List<Integer>> chunks){
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<Triplet> queue = new PriorityQueue<Triplet>();
        //add first element of every chunk into queue
        for(int i=0; i < chunks.size(); i++){
            Triplet p = new Triplet();
            p.pos = i;
            p.val = chunks.get(i).get(0);
            p.index = 1;
            queue.add(p);
        }
        
        while(!queue.isEmpty()){
            Triplet p = queue.poll();
            result.add(p.val);
            if(p.index < chunks.get(p.pos).size()){
                p.val = chunks.get(p.pos).get(p.index);
                p.index += 1;
                queue.add(p);
            }
        }
        return result;
    }
    
    class Triplet implements Comparable<Triplet>{
        int pos;
        int val;
        int index;
        @Override
        public int compareTo(Triplet o) {
            if(val <= o.val){
                return -1;
            }else{
                return 1;
            }
        }
    }

}
