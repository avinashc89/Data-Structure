package com.tool.java.leetcode;

public class RLEIterator2
{
    int pos;
    int currentCount;
    int[] A;
    
    public RLEIterator2(int[] A) {
        this.pos = 0;
        this.currentCount = 0;
        this.A = A;
        
    }
    
    public int next(int n) 
    {   
        currentCount+=n;
        while(pos<A.length-1 && currentCount>A[pos]){
            currentCount-=A[pos];
            pos+=2;
        }
        if(pos>=A.length-1) 
            return -1;
        return A[pos+1];
    }
    
    public static void main (String[] args)
    {
        RLEIterator2 r = new RLEIterator2(new int[] {3,8,0,9,2,5});
        System.out.println(r.next(2));
        System.out.println(r.next(1));
        System.out.println(r.next(1));
        System.out.println(r.next(2));
    }
}
