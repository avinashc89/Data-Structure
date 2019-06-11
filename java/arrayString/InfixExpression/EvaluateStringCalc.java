package com.tool.java.arrayString.InfixExpression;

import java.util.Stack; 
  
public class EvaluateStringCalc 
{ 
    public static int evaluate(String expression) 
    { 
        char[] tokens = expression.toCharArray(); 
  
         // Stack for numbers: 'values' 
        Stack<Integer> values = new Stack<Integer>(); 
  
        // Stack for Operators: 'ops' 
        Stack<Character> ops = new Stack<Character>(); 
  
        int i=0;
        while (i< tokens.length) 
        { 
             // Current token is a whitespace, skip it 
            if (tokens[i] == ' ') 
            {
                i++;
                continue; 
            }
  
            // Current token is a number, push it to stack for numbers 
            if (tokens[i] >= '0' && tokens[i] <= '9') 
            { 
                StringBuffer num = new StringBuffer(); 
                // There may be more than one digits in number 
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    num.append(tokens[i]); 
                    i++;
                }
                values.push(Integer.parseInt(num.toString())); 
            } 
  
            // Current token is an opening brace, push it to 'ops' 
            else if (tokens[i] == '(') 
                ops.push(tokens[i++]); 
  
            // Closing brace encountered, solve entire brace 
            else if (tokens[i] == ')') 
            { 
                while (ops.peek() != '(') 
                  values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
                ops.pop(); 
                i++;
            } 
  
            // Current token is an operator. 
            else if (tokens[i] == '+' || tokens[i] == '-' || 
                     tokens[i] == '*' || tokens[i] == '/') 
            { 
                char op = tokens[i];
                i++;
                while (!ops.empty() && getPrecedence(op) < getPrecedence(ops.peek())) 
                {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
                }
                ops.push(op); 
            } 
        } 
  
        // Entire expression has been parsed at this point, apply remaining 
        // ops to remaining values 
        while (!ops.empty()) 
            values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
  
        // Top of 'values' contains result, return it 
        return values.pop(); 
    } 
  
    // Returns true if 'op2' has higher or same precedence as 'op1', 
    // otherwise returns false. 
    public static int getPrecedence(char op) 
    { 
        switch(op)
        {
            case '+':
            case '-': 
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    } 
  
    // A utility method to apply an operator 'op' on operands 'a'  
    // and 'b'. Return the result. 
    public static int applyOp(char op, int b, int a) 
    { 
        switch (op) 
        { 
        case '+': 
            return a + b; 
        case '-': 
            return a - b; 
        case '*': 
            return a * b; 
        case '/': 
            if (b == 0) 
                throw new
                UnsupportedOperationException("Cannot divide by zero"); 
            return a / b; 
        } 
        return 0; 
    } 
  
    // Driver method to test above methods 
    public static void main(String[] args) 
    { 
        System.out.println(EvaluateStringCalc.evaluate("(10*22+10)*6/2+3")); 
        System.out.println(EvaluateStringCalc.evaluate("100 * 2 + 12")); 
//        System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 )")); 
//        System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 ) / 14")); 
    } 
}