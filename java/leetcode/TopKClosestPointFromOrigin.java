package com.tool.java.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopKClosestPointFromOrigin
{
    // distance from x,y to origin => √(x1-x2)^2 + (y1-y2)^2 => √x^2 + y^2 => sort the array by x^2+y^2 comparision. 
    //o(nlogn)
    public int[][] kClosest(int[][] points, int K) {
        
        if(points == null || K == 0) return null;
        
        Arrays.sort(points, Comparator.comparing(a-> a[0]*a[0] + a[1]*a[1]));
        
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = points[i];
        }
        
        return res;
    }
    
    
    //o(nlogk) using priorityqueue
    
    public int[][] kClosest1(int[][] points, int K) {
        if(points==null){
            return null;
        }
        
        // this would compare from origin and puts the closes point in top of heap.
        //PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparing(a-> a[0]*a[0] + a[1]*a[1]));

         // this would compare the distance between the two points and origin and puts the furtherest  point in top of heap.
         PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
               public int compare(int[] p1, int[] p2) {
                   return (p2[0]*p2[0]+p2[1]*p2[1])-(p1[0]*p1[0]+p1[1]*p1[1]);
               } 
            }); 
         
        
        //remove if size >k
        for(int i=0; i<points.length;i++) {
            pq.add(points[i]);
            if(pq.size()>K){
                pq.remove();
            }
        }
        int[][] result = new int[K][2];
        int i=0;
        while(!pq.isEmpty()){
            result[i] = pq.remove();
            i++;
        }
        return result;
    }
    
    
    
    
    
    // method 3 -> seletion quick sort 
  //O(n) best case solution ...avg case - nlogn when partitions are split half, worst case n^2 when partition is like 1 and n-1  
    public int[][] kClosest2(int[][] points, int K) {
        if(points==null){
            return null;
        }
        int start=0;
        int end = points.length-1;
        while(true){ 
            int mid = (start+end)/2;
            int dist = getDist(mid, points);
            swap(points, mid, end); //swap the pivot elem to end
            int j=start-1;
            for(int i=start; i<end; i++) { //do not consider end i.e. pivot elem as it is to be added just after the points smaller than pivot
                 int dist1 = getDist(i, points);
                 if(dist1<dist) { //if smaller elem is found at it to the smaller elems list indicated by j
                     swap(points, i, j+1);
                     j++;
                 }
            }
            j++;
            swap(points, j, end); //add pivot elem just after the smaller elems
            int found = j-start+1; 
            if(found == K) {
                return Arrays.copyOfRange(points, 0, j + 1); //K elems found return subarray starting from 0
            } else if(found<K) {
                start= j+1; 
                K= K-found; //search in second half and decrement K 
            } else {
                end = j; //search is first half
            }
        }
        
    }
    private void swap(int[][] points, int i, int j){
         int[] temp = points[j];
         points[j] = points[i];
         points[i] = temp;
    }
    private int getDist(int i, int[][] points) {
        return points[i][0]*points[i][0]+ points[i][1]*points[i][1];
    }

}
