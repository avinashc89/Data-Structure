package com.tool.java.leetcode;

public class DominosRotation
{

    /*check which number is most present.
        
        check from 1->6, if the num is not present in any one dominos set{A,B}. then we can ignore that number. 
        basically we want a number that is present in all the sets.
        
        if such number exist get the min count where the num has to be replaced. 
        
        say in   {2,1,2,4,2,2},
                 {5,2,6,2,3,2};
        
        1 is not present in first set. so no matter what we cant replace 1 any where else, we can ignore it.
        2 is present in all the sets. so we need to find the min place where it is missing. 
        
        Acount => no of places where it is present in A and not in B
        Bcount => no of places where it is present in B and not in A
        
        we can ignore if that num is present in both places. 
        
        At max there can be only 2 numbers that can have such condition to appear in all sets. 
        and calculating for both numbers would give same result.
        ex: 2,4,4,2,4,2  4,2,4,4,4,4 => gives bcount =1 acount=3 => ans =1
        
    cant just take a[]
    */
    public int minDominoRotations(int[] A, int[] B) {
        int ans = -1;
        if(A.length != B.length) return -1 ;
        
        for(int i = 1 ; i <= 6 ; i++) {
            ans = checkMin(A,B,i);
            if(ans != -1) return ans;
        }
        return ans;
        
    }

    int checkMin(int[] A , int[] B , int num) {
        int acount = 0 , bcount = 0;
        for(int i = 0 ; i < A.length; i++) 
        {
            if(A[i] != num && B[i] != num) 
                return -1;
            if(A[i] != num || B[i] != num )
            {
                if(A[i] == num) 
                    acount++;   
                else 
                    bcount++; 
            }
        }
        return Math.min(acount,bcount);
    }


    public static void main (String[] args)
    {
        DominosRotation d =new DominosRotation();
        int[] A = {1,2,1,1,1,2,2,2};
        int[] B =  {2,1,2,2,2,2,2,2};
       System.out.println(d.minDominoRotations(A, B));
        System.out.println(d.minDominoRotations(new int[]{3,5,1,2,3}, 
                                                new int[]{3,6,3,3,4}));
        
    }

}
