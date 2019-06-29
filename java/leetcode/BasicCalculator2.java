package com.tool.java.leetcode;

import java.util.Stack;

public class BasicCalculator2
{
    /*Add every number to stack with following rules

        1. if sign is -, then make sign =-1 else sign=1. 
        2. if digit put in num => num=0 =>  num = num*10 + s.charAt(i)='0' and store the previous encountered sign 
        3. when sign is encountered, add the ( num*sign ) in stack..with following rules
            3.1 => if prev sign = * or / , 
                pop the previous number and do the previous encountered sign operation with (num*sign) and put back into stack

       ex - 3-2*15/3+4 => 
       s:  3 => 3,-2 => 
     */
    public static int calculate(String s) {
        int num =0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        for(int i=0 ; i< s.length() ;i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                num = num*10 + s.charAt(i)-'0';
            }
            else if(s.charAt(i) == ' ')
            {
                continue;
            }
            else //opr
            {
                if(sign == '+')
                    stack.push(num);
                else if(sign == '-')
                    stack.push(-num);
                else if(sign == '*')
                    stack.push(stack.pop()*num);
                else 
                    stack.push(stack.pop() / num);
                
                sign = s.charAt(i);
                num = 0;
            }
        }
        
        //last number
        if(sign == '+')
            stack.push(num);
        else if(sign == '-')
            stack.push(-num);
        else if(sign == '*')
            stack.push(stack.pop()*num);
        else 
            stack.push(stack.pop() / num);
        
    
        
        
        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        
        return sum;
    }

    public static void main (String[] args)
    {
        System.out.println(calculate("3+5/2"));
        System.out.println(calculate("3-2+2"));
    }

}
