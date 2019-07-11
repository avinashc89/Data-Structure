package com.tool.java.leetcode;

import java.util.PriorityQueue;

public class MinimumDistGasStation
{

    //distance between adjacent station divide by 1. is the idea for comparision.
    // ie., 1,3 => distance =2 & there are one empty slot => 2/1
    //  14,20 => 6/1 
    // pq => 6,1  5,1  3,1  2,1  2,1  1,1

    // when we insert a gas station , we poll the one which has larger distance between them => 6,1 => 
    // add 1 gas station => 6/2 =>  |___|___|  => distance to conpare is => 6/2 => 3.

    // => PQ becomes => 5,1  3,1  6,2  2,1  2,1 1,1   top will always have larger distance.

    public double minmaxGasDist(int[] stations, int K) {
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>(
            (a,b) -> (a[0]/a[1] < b[0]/b[1]) ? 1 : -1);     
        for(int i = 1; i < stations.length; ++i)
        {
            double[] d = new double[]{stations[i] - stations[i-1], 1.0};
            pq.add(d);     
        } 
        while(K > 0){
            double [] cur = pq.poll();
            cur[1]++;
            pq.add(cur);
            K--;
        }
        double[] value =  pq.poll();
        return value[0]/value[1];
    }

    public static void main (String[] args)
    {
        MinimumDistGasStation g = new MinimumDistGasStation();

        System.out.println( g.minmaxGasDist(new int[]{1, 3, 4, 6, 9,14,20}, 9));
    }







    public double diff(double a, double b) {
        return a > b ? a - b : b - a;
    }

    public double minmaxGasDist1(int[] stations, int K) {
        double start = 0d;
        double end = 10E8d;
        double minimumMaxDistance = binarySearch(stations, (double)K, start, end);
        return minimumMaxDistance;
    }

    public double binarySearch(int[] stations, double k, double start, double end) {
        if (diff(start, end) <= 10E-6d) {
            return start;
        }
        double middle = start + (end - start) / 2;
        if (canFit(stations, k, middle)) {
            return binarySearch(stations, k, start, middle);                        
        } else {
            return binarySearch(stations, k, middle, end);
        }
    }

    public boolean canFit(int[] stations, double availableStations, double maxAllowedDistance) {
        for (int i = 1; i < stations.length; i++) {
            double distance = (double)(stations[i] - stations[i - 1]);
            if (distance > maxAllowedDistance) {
                double stationsInBetween = Math.floor(distance / maxAllowedDistance);
                availableStations -= stationsInBetween;
            }

            if (availableStations < 0) {        //loosely fit.. increase maxallowed distance    
                return false;
            }
        }       

        return true;
    }

}
