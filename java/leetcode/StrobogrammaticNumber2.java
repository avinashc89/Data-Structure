package com.tool.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumber2
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
    
    
    // way 1 - filling outside in 
    public static List<String> isStrobogrammatic(int k) {
        
        char[] choice = {'0', '1', '6', '8', '9'};
        List<String> result = new ArrayList<String>();
        char[] num = new char[k];
        helper(num , choice, 0 , k-1 , result );
        return result;
    } 
    
   
    public static void helper(char[] num, char[] choice, int left, int right, List<String> res)
    {
        if(left > right)
        {
            System.out.println(num);
            res.add(new String(num));
            return;
        }
        
        for(char ch : choice)
        {
            if(left == 0 && ch  == '0')    // cant start with zero -> continue
                continue;
            if(left == right && (ch == '6' || ch == '9'))  // if  l==r then we cant have 6 / 9
                continue;
            num[left] = ch;
            
            if(ch == '6')
                num[right] = '9';
            else if( ch == '9')
                num[right] = '6';
            else
                num[right] = ch;
            
            helper(num , choice, left+1, right -1, res);
        }
    }
    
    public static void main (String[] args)
    {
        //isStrobogrammatic(4);
          findStrobogrammatic(4);
          System.out.println(countStrobo(9));
    }
    
    
    
    
    // way 2 - filling inside out // kind of dp
    
    public static List<String> findStrobogrammatic(int n) {
        List<String> s = findStrobogrammaticHelper(n, n);
        System.out.println(n+"====>"+s.size());
        return s;
    }
    
    //
    private static List<String> findStrobogrammaticHelper(int n, int m) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList("")); 
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
        List<String> list = findStrobogrammaticHelper(n - 2, m);
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
    

}
