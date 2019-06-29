package com.tool.java.leetcode;

import java.util.Stack;

public class BasicCalculator3
{
    /*Add every number to stack with following rules

        1. if sign is -, then make sign =-1 else sign=1. 
        2. if digit put in num => num=0 =>  num = num*10 + str.charAt(i)='0' and store the previous encountered sign 
        3. when sign is encountered, add the ( num*sign ) in stack..with following rules
            3.1 => if prev sign = * or / , 
                pop the previous number and do the previous encountered sign operation with (num*sign) and put back into stack

       ex - 3-2*15/3+4 => 
       str:  3 => 3,-2 => 
     */
    static int i;
    static String str;
    
    public static int calculate(String s) {
        str = s;
        i = 0;
        return solve();
    }
    
    public static int solve() {
        int num =0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        for(; i< str.length() ;i++)
        {
            if(Character.isDigit(str.charAt(i)))
            {
                num = num*10 + str.charAt(i)-'0';
            }
            else if(str.charAt(i) == ' ')
            {
                continue;
            }
            else if(str.charAt(i) == ')')
            {
                //last number inside the braces
                if(sign == '+')
                    stack.push(num);
                else if(sign == '-')
                    stack.push(-num);
                else if(sign == '*')
                    stack.push(stack.pop()*num);
                else 
                    stack.push(stack.pop() / num);
                
                int sum = 0;
                
                for (int pop : stack) {
                    sum += pop;
                }
                return sum;
            }
            else if(str.charAt(i) == '(')
            {
                i++;
                num = solve();  
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
                
                sign = str.charAt(i);
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
        for (int pop : stack) {
            sum += pop;
        }
        
        return sum;
    }

    public static void main (String[] args)
    {
        System.out.println(calculate("3+5/2"));
        System.out.println(calculate("3-2+2"));
        System.out.println(calculate("2*(5+5*2)/3+(6/2+8)"));
        System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
    }

}
