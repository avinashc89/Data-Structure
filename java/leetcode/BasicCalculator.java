package com.tool.java.leetcode;

import java.util.Stack;

public class BasicCalculator
{
    //"4+(1+(4+5+2)-3)+(6+8)"
    //   idea: Add everything. sum =0 => sum = sum+nextnum  => sum = sum+nextnum.
    //                      if '-' sign apprears make sure to store it so that it can be used to the nextnum digit when adding.
    /*
     * 
     5-7+2-6+3 
         ans =0
         temp =0
         sign = 1 => positive
           
         initially read 5 store in temp => read '-/+' , add to temp to answer. If '-' store it.
         read 7 => read +/- , add temp to answer. But the sign for temp is '-', so add ans + sign*temp => 5 + (-7)..
         and so on.
         if ( encounters, recurse. when ) is encounters retur the ans => this gives the answer for (X-Y+Z)
         
     */
    static int x;
    static String str;
    
    static int solve()
    {
        int ans = 0, temp = 0, b = 1;
        while(x < str.length())
        {
            if(str.charAt(x) == ')')
            {
                ans += b*temp;
                return ans;
            }
            if(str.charAt(x) == '(')
            {
                x++;
                temp = solve();  
            }
            else if(str.charAt(x) == '+' || str.charAt(x) == '-')
            {
                ans += b*temp;
                temp = 0;
                b = (str.charAt(x) == '+') ? 1 : -1;  // to have the sign used for next digit in the next calculation.
            }
            else if(str.charAt(x) >= '0' && str.charAt(x) <= '9')
            {
                temp = (temp*10) + (str.charAt(x) - '0');
            }
            x++;
        }
        ans += b*temp;
        return ans;
    }
    
    static int calculate(String s) {
        str = s;
        x = 0;
        return solve();
    }
    
    //Using stack to store the currsum and sign when ( is encountered.
    public int calculate1(String ss) {
        char[] s = ss.toCharArray();
        int num = 0;
        int sum = 0;
        int sign = 1;
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length; ++i) {
            if (Character.isDigit(s[i])) 
            {
                num = num * 10 + s[i] - '0';
            }
            else if (s[i] == '+' || s[i] == '-') 
            {
                sum += sign * num;
                num = 0;
                sign = s[i] == '+' ? 1: -1;
            } 
            else if (s[i] == '(') 
            {
                stack.push(sum);
                stack.push(sign);
                sign = 1;
                sum = 0;
            } 
            else if (s[i] == ')') 
            {
                sum += sign * num;
                num = 0;
                sum *= stack.pop();  //2-(4+3+4) => 2-(7) => stack -,2 ==> 12*(-)+2 => -12+2 => -10
                sum += stack.pop();
            }
        }
        if (num != 0) {
            sum += num * sign;
        }
        return sum;
    }
    

    public static void main (String[] args)
    {
        System.out.println(calculate("5-7+2"));
        System.out.println(calculate("1+(5-7+2)"));
    }
    
}
