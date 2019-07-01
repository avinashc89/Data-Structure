package com.tool.java.leetcode;

import java.util.*;

public class RotatedDigits
{
    /*
     when rotated 180'.. it shoudl fetch a valid number but not the same number. 101 => 101 not a good rotated, 191 => 161 is good rotated
     618 => 918 good rotated number.

     Input: 10
    Output: 4
    Explanation: 
    There are four good numbers in the range [1, 10] : 2, 5, 6, 9. 

     */


    public static int rotatedDigits1(int N) {

        int rotated[] = {0,1,5,-1,-1,2,9,-1,8,6};
        int newNum;
        int i;
        int old,x;
        int count=0;

        for(int p=1; p <= N ; p++){
            old=p;
            newNum = 0;
            i = 0;

            while(old > 0){    
                x = old % 10;
                if(rotated[x]== -1) 
                    break;
                else 
                    x = rotated[x];
                newNum =(int) (newNum + x * Math.pow(10, i));
                old = old / 10;
                i++;
            }
            if(p != newNum) count++;
        }

        return count;
    }

    /*
       if 4/3/7 is present it will not give rotated number,
       
       so our numbers can have only 0125689 digits.
       even in this no use for 0/1/8 since rotating that will give same number.
       so our number must have atleast one of the 2,5,6,9 in it,
     */
    public static int rotatedDigits(int N) {

        int count = 0;
        for(int i=1;i<N+1;i++)
        {
            String x = i+"";
            if(x.indexOf('3') ==-1 && x.indexOf('4') ==-1 && x.indexOf('7') ==-1)
            {
                if(x.indexOf('2')!=-1 || x.indexOf('5')!=-1 ||x.indexOf('6')!=-1 || x.indexOf('9')!=-1){
                    count ++;
                }
            }

        }
        return count;
    }


    public static void main (String[] args)
    {
        System.out.println(rotatedDigits(857));
    }

}
