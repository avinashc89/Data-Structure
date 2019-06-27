package com.tool.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumber3
{
    
    // should fetch same value when rotated 180'  689 = T , 101 = T, 690 = F, 181 = T, 161 = F
    
    /*
          6 > 9 ,, 9 > 6 ,, 8 >> 8 ,, 0 >> 0 ,, 1 >> 1
     
        given n, print all strobo nums. n=2 => 69 96 11 88;  n=3 => 101 111 181 609 619 689 808 818 888 906 916 986 
        
        have left and right. choose a digit. put in l & r => l++, r--. recurse till l>r. then we have k digit formed.
        
        choose the part carefully with rules
        
        o(n!);
        
        formula => n===> no of StrobogrammaticNumber with n digits
        0====>0  => 0
        1====>3  => 3
        2====>4  => 4
        3====>12 => 4*f(n-2) => 4*f(1) => 4*3 => 12
        4====>20 => 5*f(n-2) => 5*f(2) => 5*4 => 20
        5====>60 => 5*f(n-2) => 5*f(3) => 5*12=> 60
        6====>100 => 5*f(n-2)
        7====>300
        8====>500
        9====>1500
        
        if  n=0 => 0
            n=1 => 3
            n=2 => 4
            n=3 => 4*f(n-2)
            n>3 => f(n) => 5*f(n-2)
        
    */
    
    
    public static void main (String[] args)
    {
//        System.out.println(strobogrammaticInRange("0","99999"));
//        System.out.println(strobogrammaticInRange("0","0"));
        String num ="1" , low ="0", high ="0";
        System.out.println(num.length()==low.length() && num.compareTo(low) < 0 || num.length()==high.length() && num.compareTo(high)>0 );
        System.out.println(num.compareTo(high) <= 0 );
       // System.out.println(strobogrammaticInRange("50","100"));
    }
    
    public static int strobogrammaticInRange(String low, String high) {
        
        int minRange = low.length();
        int maxRange = high.length();
        
        int count = 0;
        for(int i=minRange+1; i<maxRange ;i++)
        {
            count = count + countStrobo(i);
        }
        List<String> lowRange = findStrobogrammaticHelper(minRange,minRange );
        List<String> highRange = low != high? findStrobogrammaticHelper(maxRange,maxRange ): new ArrayList<>();
        
        lowRange.addAll(highRange); 
        
        for(String num : lowRange)
        {
            if(num.length()==low.length() && num.compareTo(low) >= 0 || num.length()==high.length() && num.compareTo(high)<=0 )
                count++;
        }
        
        return count;
    }
    
    //
    private static List<String> findStrobogrammaticHelper(int n, int m) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList("")); 
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
        List<String> list = findStrobogrammaticHelper(n - 2, m );
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); ++i) {
            String s = list.get(i);
            if (n != m) {
                res.add("0" + s + "0");             // if k=4, only when filling outermost(_xx_) digit, we omit 0
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
    
    public static int countStrobo(int k)
    {
        if(k==0) return 0;
        if(k==1) return 3;
        if(k==2) return 4;
        if(k==3) return 4*countStrobo(k-2);
        else
            return 5*countStrobo(k-2);
    }
    
    
    
    
    //way 2=
    private static char[][] PAIRS = new char[][]{{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    
    public int strobogrammaticInRange1(String low, String high) {
        int cnt = 0;
        for (int i = low.length(); i <= high.length(); ++i) {
            cnt += dfs(low, high, new char[i], 0, i - 1);
        }
        return cnt;
    }
    
    private int dfs(String low, String high, char[] c, int l, int r) {
        if (l > r) {
            String s = new String(c);
            if (c.length == low.length() && s.compareTo(low) < 0 ||
                c.length == high.length() && s.compareTo(high) > 0) {
                return 0;
            } else {
                return 1;
            }
        }
        int cnt = 0;
        for (char[] pair : PAIRS) {
            c[l] = pair[0];
            c[r] = pair[1];
            if (c.length != 1 && c[0] == '0') {
                continue;
            }
            if (l == r && pair[0] != pair[1]) {
                continue;
            }
            cnt += dfs(low, high, c, l + 1, r - 1);
        }
        return cnt;
    }

}
