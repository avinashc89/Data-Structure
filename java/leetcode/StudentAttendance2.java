package com.tool.java.leetcode;

public class StudentAttendance2
{

    /*

     A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

     Input: n = 2
    Output: 8 
    Explanation: "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
        Only "AA" won't be regarded as rewardable owing to more than one absent times. 

     */

    public int checkRecord(int n) {

        return 0;
    }


    public static void main (String[] args)
    {
        StudentAttendance2 a = new StudentAttendance2();

        System.out.println(a.checkRecord(2));
        System.out.println(a.checkRecord(4));
    }
}
