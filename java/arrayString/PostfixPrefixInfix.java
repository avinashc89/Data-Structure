import java.util.Stack;

public class PostfixPrefixInfix
{
    
    /*
     Infix -> Postfix
     Algorithm
        1. Scan the infix expression from left to right.
        2. If the scanned character is an operand, output it.
        3. Else,
        …..3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty or the stack contains a ‘(‘ ), push it.
        …..3.2 Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. After doing that Push the scanned operator to the stack. (If you encounter parenthesis while popping then stop there and push the scanned operator in the stack.)
        4. If the scanned character is an ‘(‘, push it to the stack.
        5. If the scanned character is an ‘)’, pop the stack and and output it until a ‘(‘ is encountered, and discard both the parenthesis.
        6. Repeat steps 2-6 until infix expression is scanned.
        7. Print the output
        8. Pop and output from the stack until it is not empty.
     
     
     Infix -> Prefix
      Algorithm
        Step 1: Reverse the infix expression i.e A+B*C will become C*B+A. Note while reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.
        Step 2: Obtain the postfix expression of the modified expression i.e CB*A+.
        Step 3: Reverse the postfix expression. Hence in our example prefix is +A*BC.
     
     
     Postfix -> Infix
     
        Read the Postfix expression in order (from left to right)
        If the symbol is an operand, then push it onto the Stack
        If the symbol is an operator, then pop two operands from the Stack
        Create a string by concatenating the two operands and the operator between them.
        string = (operand1 + operator + operand2)
        And push the resultant string back to Stack
        Repeat the above steps until end of Prefix expression.
            
      Prefix -> Infix
      
        Read the Postfix expression in reverse order (from right to left)
        If the symbol is an operand, then push it onto the Stack
        If the symbol is an operator, then pop two operands from the Stack
        Create a string by concatenating the two operands and the operator between them.
        string = (operand1 + operator + operand2)
        And push the resultant string back to Stack
        Repeat the above steps until end of Prefix expression.
      
     
     
     Postfix -> Prefix
     
        Read the Postfix expression from left to right
        If the symbol is an operand, then push it onto the Stack
        If the symbol is an operator, then pop two operands from the Stack
        Create a string by concatenating the two operands and the operator before them.
        string = operator + operand2 + operand1
        And push the resultant string back to Stack
        Repeat the above steps until end of Prefix expression.
     
     Prefix -> Postfix
     
        Read the Prefix expression in reverse order (from right to left)
        If the symbol is an operand, then push it onto the Stack
        If the symbol is an operator, then pop two operands from the Stack
        Create a string by concatenating the two operands and the operator after them.
        string = operand1 + operand2 + operator
        And push the resultant string back to Stack
        Repeat the above steps until end of Prefix expression.
     
     
     
    
     */
    
    
    static int Prec(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
    } 
    
    
    static String infixToPostfix(String exp) 
    { 
        // initializing empty String for result 
        String result = new String(""); 
          
        // initializing empty stack 
        Stack<Character> stack = new Stack<>(); 
          
        for (int i = 0; i<exp.length(); ++i) 
        { 
            char c = exp.charAt(i); 
              
             // If the scanned character is an operand, add it to output. 
            if (Character.isLetterOrDigit(c)) 
                result += c; 
               
            // If the scanned character is an '(', push it to the stack. 
            else if (c == '(') 
                stack.push(c); 
              
            //  If the scanned character is an ')', pop and output from the stack  
            // until an '(' is encountered. 
            else if (c == ')') 
            { 
                while (!stack.isEmpty() && stack.peek() != '(') 
                    result += stack.pop(); 
                  
                if (stack.isEmpty() || !stack.isEmpty() && stack.peek() != '(') 
                    return "Invalid Expression"; // invalid expression                 
                else
                {
                    stack.pop();
                }
                     
            } 
            else // an operator is encountered 
            { 
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){ 
                    if(stack.peek() == '(') 
                        return "Invalid Expression"; 
                    result += stack.pop(); 
             } 
                stack.push(c); 
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (!stack.isEmpty()){ 
            if(stack.peek() == '(') 
                return "Invalid Expression"; 
            result += stack.pop(); 
         } 
        return result; 
    } 
    
    public static void main (String[] args)
    {
        System.out.println(infixToPostfix("a+*/+b"));
    }
    
    
    

}
