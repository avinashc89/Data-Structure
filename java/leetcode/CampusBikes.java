package com.tool.java.leetcode;

import java.util.*;

public class CampusBikes
{

    public static int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] arr = new int[workers.length];
        
        //a => {w1,b1} b=> {w2,b2}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
           
            int i = a[0];           //workerA
            int j = a[1];           //bikeA
            
            int k = b[0];           //workerB
            int m = b[1];           //bikeB                 
            
          //find distance bet, workerA->bikeA = distanceA and workerB->bikeB = distancB
            //if (distanceA - distanceB) is same, then keep the worker with smallest index top, 
            // if that is equal, keep the bike with smaller index on top.
            
            int distanceA = Math.abs(workers[i][0] -  bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
            int distanceB = Math.abs(workers[k][0] -  bikes[m][0]) + Math.abs(workers[k][1] - bikes[m][1]);
            int diff = distanceA - distanceB;
            
            if(diff == 0) {
                if(i < k) return -1;  // if workerA comes first before workerB
                if(i > k) return 1;       
                if(j < m) return -1;
                if(j > m) return 1;
            }
            return diff;
        });
        
        for(int i = 0; i <= workers.length - 1; i++) {
            for(int j = 0; j <= bikes.length - 1; j++) {
                pq.add(new int[]{i, j});
            }
        }
        
        //at this point. worker with nearest bike is at the top and goes in increasing distance. 
        //take two hashset to maintain used worker and used bikes.
        // pop out the queue => this gives [w,b] if they are not taken, add to result.
        
        Set<Integer> taken_workers = new HashSet<>();
        Set<Integer> taken_bikes = new HashSet<>();
         
        while(!pq.isEmpty()) {
            int[] pop = pq.poll();
            int i = pop[0];         //worker
            int j = pop[1];         //bike
            if(taken_workers.contains(i) || taken_bikes.contains(j)) {
                continue;
            }
            taken_workers.add(i);
            taken_bikes.add(j);
            arr[i] = j;             //assign i(worker) to the j(bike)
        }

        return arr;
    }

    public static int distance(int x, int y, int a, int b) {
        return Math.abs(x - a) + Math.abs(y - b);
    }
    
    public static void main (String[] args)
    {
        int[][] worker = {{0,0},{1,1},{2,0}};
        int[][] bikes  = {{1,0},{2,2},{2,1}};
        
        assignBikes(worker,bikes);
    }
    
}
