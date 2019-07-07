package com.tool.java.leetcode;

import com.tool.java.Util;

public class BookingFlight
{

public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int[] res = new int[n];
        if(bookings==null || bookings.length ==0)
            return res;
        
        for(int[] booking : bookings)
        {
            for(int i = booking[0]-1 ; i<= booking[1]-1 ; i++)
            {
                res[i] = res[i]+booking[2];
            }
        }
        Util.printArray(res);
        return res;
    }

public static void main (String[] args)
{
    BookingFlight b = new BookingFlight();
    int n =5;
    int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
    b.corpFlightBookings(bookings, n);
}
}
