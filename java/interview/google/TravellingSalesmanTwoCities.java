package com.tool.java.interview.google;

import java.util.Arrays;

public class TravellingSalesmanTwoCities
{
    
    /*
     Given two cities, with profit earned on the days, what is  maximum profit eaned by the travelling salesman?
     
     CityA[] = { 2, 2, 3, 5 }
     CityB[] = { 1, 3, 7, 2 }
     
     int cost = 2 , if he travels from cityA to cityB or viceversa
      
     */

    public static int getMaximumProfit(int a[], int b[], int k)
    {
        if(a==null && b==null)
            return 0;
        
        if(a==null)
            return Arrays.stream(b).sum();
        if(b==null)
            return Arrays.stream(a).sum();
        
        int dpA[] = new int[a.length];
        int dpB[] = new int[b.length];
        
        int i=0,j=0;
        //calculate the maximum profit earned on first day.
        
        dpA[0] = 0+a[0];
        dpB[0] = 0+b[0];
       
        i++; j++;
        
        while(i<a.length && j<b.length)
        {
            dpA[i] = Math.max(dpA[i-1]+ a[i] , dpB[j-1] - k + a[i]);
            dpB[i] = Math.max(dpB[j-1]+ b[j] , dpA[i-1] - k + b[j]);
            i++;j++;
        }
        
        int maxProfit = Math.max(dpA[i-1], dpB[j-1]);
        
        return maxProfit;
        
    }
    
    public static void main (String[] args)
    {
        int CityA[] = { 2, 2, 3, 5 };
        int CityB[] = { 1, 3, 7, 2  };
        int cost = 2;
        System.out.println(getMaximumProfit( CityA, CityB , cost));
    }
}
