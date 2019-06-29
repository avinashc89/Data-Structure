package com.tool.java.leetcode;

public class Restroom_MaximizeDistanceToClosestPerson
{
    // like men going choose the urinal in restroom. the maximize the distanc to the next person
    
    // int previouslocation =-1
    
    public static int maxDistToClosest(int[] seats) {
        
        int previousLocation = -1;
        int distance =0;
        int result = 1 ;// since there is one empty slot and nearest distance is 1.
            
        for(int i=0 ; i< seats.length ; i++)
        {
            if(seats[i]==1)
            {
                if(previousLocation == -1)
                {
                    result = distance ; // he can chose the wall corner
                }
                else
                {
                    result = Math.max(result, (distance+1)/2  ) ; // he has to choose the center one
                }
                previousLocation = i;
                distance = 0;
            }
            else
            {
                distance ++;
            }
        }
        
        // can he choose last 
        result = Math.max(result , (distance));
        
        return result;
    }
    
    
    public static void main (String[] args)
    {
       System.out.println( maxDistToClosest(new int[] {0,1,0,0,0,1,0,1,0,0,0}));
       System.out.println( maxDistToClosest(new int[] {1,0,0,0}));
    }

}
