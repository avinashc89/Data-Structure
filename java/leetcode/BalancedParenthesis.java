package com.tool.java.leetcode;

import java.util.Stack;

public class BalancedParenthesis
{

    /*
     * 
     * 1) Declare a character stack S.
        2) Now traverse the expression string exp.
            a) If ‘(‘ or ‘{‘ or ‘[‘ = push it to stack.
            b) If  ‘)’ or ‘}’ or ‘]’ then pop from stack and 
                if the popped character is the matching starting bracket then fine else parenthesis are "not balanced".
        3) After complete traversal, if there is some starting bracket left in stack then “not balanced”

     */
    
    static boolean areParenthesisBalanced(char exp[]) 
    { 
       /* Declare an empty character stack */
       Stack<Character> st=new Stack(); 
       
       /* Traverse the given expression to  
          check matching parenthesis */
       for(int i=0;i<exp.length;i++) 
       { 
          if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[') 
            st.push(exp[i]); 
       
          if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') 
          { 
             if (st.isEmpty()) 
               { 
                   return false; 
               }  
       
             else if ( !isMatchingPair(st.pop(), exp[i]) ) 
               { 
                   return false; 
               } 
          } 
       } 
       if (st.isEmpty()) 
         return true; /*balanced*/
       else
         {   /*not balanced*/
             return false; 
         }  
    } 
    
    static boolean isMatchingPair(char character1, char character2) 
    { 
       if (character1 == '(' && character2 == ')') 
         return true; 
       else if (character1 == '{' && character2 == '}') 
         return true; 
       else if (character1 == '[' && character2 == ']') 
         return true; 
       else
         return false; 
    } 
}
