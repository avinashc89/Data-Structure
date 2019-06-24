package com.tool.java.leetcode;

import java.util.Stack; 

public class EvaluateStringCalc 
{ 
    public static int calculate(String s) 
    { 
        char[] tokens = s.toCharArray(); 

        // Stack for numbers: 'values' 
        Stack<Long> values = new Stack<Long>(); 

        // Stack for Operators: 'ops' 
        Stack<Character> ops = new Stack<Character>(); 
        int sign = 1;
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
                values.push(sign*Long.parseLong(num.toString())); 
                sign = 1;
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
                if((values.isEmpty() || (!ops.isEmpty() && ops.peek()=='(')) && op == '-')
                {
                        sign = -1;
                }
                else {
                    while (!ops.empty() && getPrecedence(op) <= getPrecedence(ops.peek())) 
                    {
                        values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
                    }
                    ops.push(op); 
                }
            } 
        } 

        // Entire s has been parsed at this point, apply remaining 
        // ops to remaining values 
        while (!ops.empty()) 
            values.push(applyOp(ops.pop(), values.pop(), values.pop())); 

        // Top of 'values' contains result, return it 
        return values.pop().intValue(); 
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
    public static long applyOp(char op, long b, long a) 
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
        System.out.println(calculate("10/2/5")); 
        System.out.println(calculate("2-6+2")); 
        System.out.println(calculate("2*6/2")); 
        System.out.println(calculate("(7)-(0)+(4)")); 
        System.out.println(calculate("-1+4*3/3/3")); 
        System.out.println(calculate("1 - (-7)")); 
        System.out.println(calculate("0-2147483648"));
        System.out.println(calculate("(5+5*2)"));

    } 


    public static int calculate1(String s) {
        if(s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        Stack callStack = new Stack<>();               

        s += "+";

        int num = 0;
        char sign = '+';

        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c >= '0' && c <= '9'){
                num = num*10 + (c - '0');
            }else if(c == '('){
                callStack.push(stack);
                callStack.push(sign);

                sign = '+';
                num = 0;
                stack = new Stack<>();
            }else if(c == '+' || c == '-' || c == '*' || c == '/' || c == ')'){
                if(sign == '+') stack.push(num);
                else if(sign == '-') stack.push(-num);
                else if(sign == '*') stack.push(stack.pop() * num);
                else if(sign == '/') stack.push(stack.pop() / num);

                if(c == ')'){
                    num = stack.stream().mapToInt(x -> x).sum();
                    sign = (char) callStack.pop();                
                    stack = (Stack<Integer>) callStack.pop();
                }else{
                    sign = c;
                    num = 0;
                }
            }
        }

        return stack.stream().mapToInt(x -> x).sum();
    }
    
    
    
    public static int calculate2(String s) {
        s = s.concat("#");
        final int n = s.length();
        Object[] stack = new Object[n + 1];
        stack[0] = '#';

        char operator = '#';  // last operator
        int top = 0;

        for (int i = 0; i < n; i ++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                // read a num
                int num = 0;
                while (i < n && (ch = s.charAt(i)) >= '0' && ch <= '9') {
                    num = num * 10 + ch - '0';
                    i++;
                }
                // record last operator
                operator = (char) stack[top];
                // push the number
                stack[++top] = num;
                i--;
            } else if (ch != ' ') {
                int precedence = judgeOperator(operator, ch);

                if (precedence < 0) {
                    stack[++ top] = ch;
                } else if (precedence > 0) {
                    int ret = cal((int) stack[top--], (char) stack[top--], (int) stack[top--]);
                    operator = (char) stack[top];
                    stack[++top] = ret;
                    i --;
                } else if (precedence == 0) {
                    int num = (int) stack[top--];
                    // pop '(' or '#'
                    top--;
                    operator = top >= 0 ? (char) stack[top] : '#';
                    stack[++top] = num;
                } 
            }
        }

        return (int)stack[top];
    }

    private static int judgeOperator(char leftOp, char rightOp) {
        if (leftOp == '*' || leftOp == '/') {
            return 1;
        }

        if ((leftOp == '+' || leftOp == '-') &&
                (rightOp == '+' || rightOp == '-' || rightOp == ')' || rightOp == '#')) {
            return 1;
        }

        if (leftOp == '(' && rightOp == ')' || leftOp == '#' && rightOp == '#') {
            return 0;
        }

        return -1;

    }

    private static int cal(int rightValue, char operator, int leftValue) {
        switch (operator) {
            case '#' : 
            case '+' : return leftValue + rightValue;
            case '-' : return leftValue - rightValue;
            case '*' : return leftValue * rightValue;
            case '/' : return leftValue / rightValue;
            default: return 0;
        }
    }
}


