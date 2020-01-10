package com.tool.java.leetcode;

public class Restroom_MaximizeDistanceToClosestPerson
{
    // like men going choose the urinal in restroom. the maximize the distanc to the next person
    
    // int previouslocation =-1
    
    public static int maxDistToClosest(int[] seats) {
        
        int previousLocation = -1;
        int distance = 0;   // distance from current postion to the next left encountered person 
        int result = 1 ;// if there is one empty slot and max closest distance is 1.
            
        for(int i=0 ; i< seats.length ; i++)
        {
            if(seats[i]==1)     //if occupied
            {
                if(previousLocation == -1)      //executed only once for the left wall. If there is no one encountered till now, the best place is to choose left most place(wall)  
                {
                    result = distance ; // he can choose the wall corner
                }
                else
                {
                    result = Math.max(result, (distance+1)/2  ) ; // now the distance -> from his position to left encountered(!=1). So he has to choose the center place => distance/2
                }
                previousLocation = i;
                distance = 0;
            }
            else
            {
                distance ++;
            }
        }
        
        // can he choose last, if the distance is more when he reaches right wall
        result = Math.max(result , (distance));
        
        return result;
    }
    
    
    public static void main (String[] args)
    {
       System.out.println( maxDistToClosest(new int[] {0,1,0,0,0,1,0,1,0,0,0}));
       System.out.println( maxDistToClosest(new int[] {1,0,0,0}));
    }

}
