package com.tool.java.arrayString.count;

public class PlusOneToArray
{

    public int[] digitPlusOne(int[] num)
    {
        for (int i = num.length-1 ; i>=0; i--)
        {
            if(num[i] < 9)
            {
                num[i]++;
                return num;
            }
            num[i] =0;   // if that digit is 9 then make it as zero and go on to leftdigit
        }
        
        int[] result = new int[num.length+1];
        result[0] = 1;
            
        return result;
    }
    
}
