package com.tool.java.leetcode;

public class RLEIterator
{
    int[] A ;
    int pos ;

    public RLEIterator(int[] A) {
        this.A = A;
        this.pos = 0;

    }

    public int next(int n) 
    {   
        int res = -1;
        int count = n;
        
        while(pos < A.length && count > A[pos])
        {
            count = count - A[pos];
            A[pos] = 0;
            pos = pos+2;
        }
        
        if(pos >= A.length)
            return -1;
        A[pos] = A[pos] - count;
        res = A[pos+1];

        return res;
    }

    public static void main (String[] args)
    {
        RLEIterator r = new RLEIterator(new int[] {811,903,310,730,899,684,472,100,434,611});
        System.out.println(r.next(358));
        System.out.println(r.next(354));
        System.out.println(r.next(154));
        System.out.println(r.next(265));
        System.out.println(r.next(73));
        System.out.println(r.next(220));
        System.out.println(r.next(138));
        System.out.println(r.next(4));
        System.out.println(r.next(170));
        System.out.println(r.next(88));
    }
}
