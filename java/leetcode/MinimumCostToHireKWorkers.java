package com.tool.java.leetcode;

import java.util.*;

public class MinimumCostToHireKWorkers
{
    
    /*
      Quality = 10   20    5    8
      wage    = 70   50    30   80
                 7   2.5    6    8
      so the employees demand atleast (cost per quality) = 7 2.5 6 8
      
      sort the data by (cost for 1 quality) =>
      
      20    5  10   8
      2.5   6  7    80
               ith
       now at ith position minimum salary given for all employees is 7 for 1 quality. so obviously the previous workers are also satisfies.
       
       if employees number is greater than k, we can skip the employer who will get higher salary. => he is the one with high quality.
       
       so maintain a max heap for quality, whenever more than k, remove the top quality.
       
       if k => minimum salary given at that point ith salary * total quality. 
       
       1. sort the array based on salary (wages per quality)
       2. create max heap and add quality for each worker.
       
       total cost at k => sum of total quality in heap * current read worker's salary
     */
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        List<Pair> pq = new ArrayList<>();
        int n = quality.length;
        for (int i = 0; i < n; ++i) {
            pq.add(new Pair(((double) wage[i]) / quality[i], quality[i]));
        }
        Collections.sort(pq, new PairComparator());
        int sum = 0;
        double min = Double.MAX_VALUE;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < pq.size(); ++i) {
            if (q.size() == K) {
                sum -= q.poll();
            }
            q.offer(pq.get(i).quality);
            sum += pq.get(i).quality;
            if (i >= K - 1) {
                min = Math.min(min, sum * pq.get(i).rank);
            }
        }
        return min;
    }
    
    private class PairComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            if (Double.compare(a.rank, b.rank) == 0) {
                return a.quality - b.quality;
            } else {
                return Double.compare(a.rank, b.rank);
            }
        }
    }
    
    private class Pair {
        double rank;
        int quality;
        
        Pair(double rank, int quality) {
            this.rank = rank;
            this.quality = quality;
        }
        @Override
        public String toString ()
        {
            // TODO Auto-generated method stub
            return "["+quality+":"+rank+"]";
        }
    }
    
    public static void main (String[] args)
    {
        MinimumCostToHireKWorkers m = new MinimumCostToHireKWorkers();
        
        m.mincostToHireWorkers( new int[]{10,20,5}, new int[]{70,50,30}, 2);
    }

}
