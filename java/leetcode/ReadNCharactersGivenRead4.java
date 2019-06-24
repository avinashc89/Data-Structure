package com.tool.java.leetcode;

public class ReadNCharactersGivenRead4 
{
    /*
     "abcdefghij"
     
       n = 5  7  12  1
     o/p = 5  7  10  1 
     
     
     */
    
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];

        int total = 0;
        while (total < n) {                                     // totally we can read upto n, if total read is less than n, then proceed
            int count = read4(tmp);                             // call read4() => this can give 4/3/2/1/0
            count = Math.min(count, total-n);                   // count can be whatever read or the available space.
            for( int i=0; i< count ; i++) {                     // thus count is achieved  
                buf[total++] = tmp[i];                          // copy the content to buf and increase the total read
            }
            if (count < 4) break;                               // if count is less than 4 => either all read or no more space available
        }
        return total;
    }
    
    public int read4(char[] buf)
    {
        return 0;
    }

}
