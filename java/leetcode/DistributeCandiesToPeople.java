package com.tool.java.leetcode;

import com.tool.java.Util;

public class DistributeCandiesToPeople
{
 public int[] distributeCandies(int candies, int num_people) {
        
     int itr=0;
     int[] ppl = new int[num_people];
     
     while(candies>0)
     {
         for(int i=0; i<num_people && candies>0; i++ )
         {
             int cadies_given = Math.min((itr*num_people)+(i+1), candies);
             ppl[i] = ppl[i] + cadies_given;
             candies= candies - cadies_given;
         }
         itr++;
     }
     
     Util.printArray(ppl);
     return ppl;
     
    }
 
 public static void main (String[] args)
{
     DistributeCandiesToPeople m = new DistributeCandiesToPeople();
     
     m.distributeCandies(7, 4);
}

}
