package com.tool.java.leetcode;

public class MinimumJumpToReachEnd
{
    
    public static int minJump(int[] A)
    {
        
        if(A.length <=1) return 0;
        if (A[0] == 0)
            return -1;
        int ladder = A[0];
        int steps = A[0];
        
        int jump=1;
        
        for (int i=1 ; i < A.length ; i++)
        {
            if(i == A.length-1)
                return jump;
            if(i + A[i] > ladder)
            {
                ladder = i + A[i];
            }
            steps --;
            if(steps ==0)
            {
                if (i >= ladder)
                    return -1;
                jump++;
                steps = ladder-i;
            }
        }
        return jump;
        
    }

}
