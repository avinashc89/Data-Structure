package com.tool.java.leetcode;

import java.util.HashSet;

public class NextClosestTime
{
    
    /*
         method 1:  using hash set => put all the digits in the hashset
                    calculate the total min
                    add 1 to total min => convert back to hh:mm and check if all digits are there in hashset  
     */
    
    public static String nextClosestTime(String time) {
         
        //total minutes 
        int totalminutes = Integer.parseInt(time.substring(3)); //Integer.parseInt(time.substring(time.length()-2));
        totalminutes += Integer.parseInt(time.substring(0, 2))*60;
        
        HashSet<Integer> digits = new HashSet<Integer>();
        for(char ch : time.toCharArray())
        {
            if(ch!=':'){
                digits.add(ch-'0');
            }
        }
        while(true)
        {
            //add 1 min
            totalminutes = (totalminutes +1)% (24*60);   //=> totalmin in a day 0-1399 1400 => 0 , 1401=>1
            
            //convert the min to hh:mm                  =>totalminutes%60 = min totalminutes/60 => hour
            int[] nextTime= {totalminutes/60/10,totalminutes/60%10,totalminutes%60/10, totalminutes%60%10};
            boolean isValid = true;
            for(int digit : nextTime)
            {
                if(!digits.contains(digit))
                    isValid=false;
            }
            if(isValid)
                return new StringBuilder()
                    .append(nextTime[0])
                    .append(nextTime[1])
                    .append(":")
                    .append(nextTime[2])
                    .append(nextTime[3]).toString();
        }
    }
    
    /*
      method 2: using boolean array 0-9   flag[9]
                 read the digit and make true in all the index.
                 cal min and hr
                 
                 
                 for (i=min to 60)
                     check if min/10, min%10 is true =if yes return hr:i 
                 for(i=0 to min)
                     check if  min/10, min%10 is true =if yes then i is the min answer
                 
                 for (i=hr to 24)
                     check if hr/10, hr%10 is true =if yes return hr:i 
                 for(i=0 to min)
                     check if hr/10, hr%10 is true =if yes return hr:i 
     */
    public String nextClosestTime2(String time) {
        String hour = time.substring(0,2);
        int hInt = Integer.parseInt(hour);
        String minute = time.substring(3);
        int mInt = Integer.parseInt(minute);
        
        boolean[] digits = new boolean[10];
        digits[hInt/10] = true;
        digits[hInt%10] = true;
        digits[mInt/10] = true;
        digits[mInt%10] = true;
        
        //minute adjustment
        for (int i = mInt+1 ; i < 60 ; i++) {
            if(digits[i%10] && digits[i/10]) {
                return hour + ":" + Integer.toString(i/10) + Integer.toString(i%10);
            }
        }
        
        for (int i = 0 ; i <= mInt ; i++) {
            if(digits[i%10] && digits[i/10]) {
                mInt = i;
                break;
            }
        }
        
        for (int i = hInt+1; i <= 23; i++) {
            if(digits[i%10] && digits[i/10]) {
                return Integer.toString(i/10) + Integer.toString(i%10) +":" + Integer.toString(mInt/10) + Integer.toString(mInt%10);
            }
        }
        
        for (int i = 0; i <= hInt; i++) {
            if(digits[i%10] && digits[i/10]) {
                return Integer.toString(i/10) + Integer.toString(i%10) +":" + Integer.toString(mInt/10) + Integer.toString(mInt%10);
            }
        }
        return null;
    }
    
    public static void main (String[] args)
    {
        System.out.println(nextClosestTime("23:59"));
    }

}
