package com.tool.java.leetcode;

import java.util.*;

public class KLargestValuesWithLabels
{
    /*
     
     Input: values = [9, 8, 6, 8, 7], 
            labels = [A, A, B, A, A], k = 3, m = 2
        Output: [9, 8, 6]
        
      find k largest numbers such that corresponding label count should not be more than m
     
     */
    
    /*
      method 1 - using PQ. O(nlogn)
      For every label get the top k elements. 
      now choose top k among them. so that corresponding labels will never be more than m.
     */
    public static List<Integer> topK(int[] values, char[] labels, int k, int m) 
    {
       
        Map<Character, Queue<Integer>> map = new HashMap<>();
        for (int i=0 ; i< values.length; i++)
        {
            char label = labels[i];
            Queue<Integer> pq = map.getOrDefault(label, new PriorityQueue<>(m + 1));
            pq.add(values[i]);
            if (pq.size() > m) 
                pq.poll();
            map.put(label, pq);
        }
        
        Queue<Integer> result = new PriorityQueue<>(k + 1);
        for (Queue<Integer> pq : map.values()) {
            for (int val : pq) {
                result.add(val);
                if (result.size() > k) result.poll();
            }   
        }
        
        return new ArrayList<>(result);
    }
    
    public static void main (String[] args)
    {
        KLargestValuesWithLabels k = new KLargestValuesWithLabels();
        System.out.println(k.topK2(new int[]{9, 8, 6, 8, 7}, new char[]{'A', 'A', 'B', 'A', 'A'}, 3, 2));
        
    }

    
    /*
      o(n) using quickselect - avg case. worst case - o(n^2)
      
     */
    public static List<Integer> topK2(int[] values, char[] labels, int k, int m) {
        
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) 
        {
            char label = labels[i];
            map.putIfAbsent(label, new ArrayList<>());
            map.get(label).add(values[i]);
        }
        
        //do quickselect in each label list.
        List<Integer> result = new ArrayList<>();
        for (List<Integer> vals : map.values()) 
        {
            qselect(vals, m);
            result.addAll(vals.subList(0, Math.min(m, vals.size()))); //do quickselect and add first m numbers in result. 
        }
        
        qselect(result, k);
        
        return result.subList(0, Math.min(k, result.size()));

    }
    //Quick select => 
    private static void qselect(List<Integer> arr, int k) 
    {
        if (k >= arr.size()) return;
        k--; // k zero baised for convenience
        
        int lo = 0;
        int hi = arr.size() - 1;
        while (lo < hi) {
            int p = partition(arr, lo, hi);
            if (p < k) {
                lo = p + 1;
            } else if (p > k) {
                hi = p - 1;
            } else {
                break;
            }
        }
    }

    //take left as pivot, 
    //start i from left j from right. travel i till it finds num>pivot and travel j till it finds num<pivot. 
    // swap i&j. travel till i>j.
    // swap pivot and j.
    //return j => index where number is sorted and in correct place.
    
    
    private static int partition(List<Integer> arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int pivot = arr.get(lo);
        while (true) {
            while (i < hi && arr.get(++i) > pivot);
            while (arr.get(--j) < pivot);

            if (i >= j) break;
            Collections.swap(arr, i, j);
        }
        Collections.swap(arr, lo, j);
        return j;
    }

    
    
}
