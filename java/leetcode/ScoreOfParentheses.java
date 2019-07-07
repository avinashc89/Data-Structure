package com.tool.java.leetcode;

import java.util.Stack;

public class ScoreOfParentheses
{
/*
        () has score 1
        AB has score A + B, where A and B are balanced parentheses strings.
        (A) has score 2 * A, where A is a balanced parentheses string.
        
        using stack. if open push to stack
        for every char in string
        if ( is found, check if stack top is ), 
            say sum=0
            if not,
             iterate till you get ) or stack is empty,
                 each time pop the integer value and add it to sum => sum = sum + s.pop()       => (()()) => (11) => (1+1) => (2)
            if yes,
                if sum =0 (ie., () is found)
                    stack.pop(); and stack.push(1) => push  the value of the ().
                if sum > 0
                    stack.pop, stack.push(2*sum) =>ie.,  push  the value of the (()()) => (2) => 2*2 => 4
      
      sometimes stack is not empty -> ()()(()) => [1,1,2] => we need to process this.
         
            
                
        
        
 */
    public int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();
        int ans=0;
        // Solving for the whole string using stack
        for (char cc : S.toCharArray()) {
            // If opening bracket, just push it.
            if (cc == '(') {
                stack.push(cc + "");
            } else {
                // If closing bracket, then depending upon the 'type' compute sum between braces,
                // and push the new result to the stack
                if (cc == ')') {
                    int sum = 0;
                    while (stack.size() > 0 && !stack.peek().equals("(")) {
                        sum += (Integer.valueOf(stack.pop()));
                    }
                    stack.pop(); // remove the opening bracket now
                    if (sum == 0) {
                        stack.push("1");
                    } else {
                        stack.push(String.valueOf(2 * sum));
                    }
                }
            }
        }
        
        // Since we may have many expressions : Eg -> ()()(()) => [1,1,2] => we need to process this.
        while(stack.size()>0){
            ans+=Integer.valueOf(stack.pop());
        }
        return ans;
    }
    
    public static void main (String[] args)
    {
        
        ScoreOfParentheses s = new ScoreOfParentheses();
        s.scoreOfParentheses("(()(()))");
    }
}
