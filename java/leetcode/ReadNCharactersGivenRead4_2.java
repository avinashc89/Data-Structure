package com.tool.java.leetcode;

public class ReadNCharactersGivenRead4_2 //Hard
{
    //https://www.youtube.com/watch?v=HcmRR2If2Hk
    
    /*
    "abcdefghij"
    
      n = 6  3  4  2
    o/p = 6  3  1  0  => already all the characters are read 
    
    During the first call, read4() was called twice => till 'h' has been read. ie., till 8th char has been read. 
    But n =6 , so till f is saved in buff and 6 is printed.
    
    next call, n=3 => make sure the previous 2 char missed in previous call is put in buff. then call read4() => read till j,
    but n=3, so till i is saved in buff and 3 is printed. 
    
    next call, n=4 => again read from previous call's tmp and put in buff. call read4() => gives 0.
    
    */
    private int tmpCnt;
    private int tmpPnt;
    private char[] tmp = new char[4];
    
    public int read(char[] buf, int n) {
        int total = 0;
        while (total < n) {
            if (tmpPnt == 0) {
                tmpCnt = read4(tmp);
            }

            while (total < n && tmpPnt < tmpCnt) {
                buf[total++] = tmp[tmpPnt++];
            }
            if (tmpPnt == tmpCnt) tmpPnt = 0;
            if (tmpCnt < 4) break;
           
        }

        return total;
    }
    
    public int read4(char[] buf)
    {
        return 0;
    }

}
