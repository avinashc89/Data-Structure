package com.tool.java.leetcode;

import java.util.Stack;

public class RemoveAdjacentDuplicates
{
    
    // a,b,b,a,c,a 
    
    public static String removeDuplicates(String s)
    {
        char [] m = s.toCharArray();
        int i = -1;
        int j = 0;
        while(j < m.length) {
            if(i < 0 || m[i] != m[j]) {
                m[++i] = m[j++]; 
            } else {
                i--;
                j++;
            }
        }
   
        return new String(m, 0, i+1);
    }
    
    
    //using stack. Put the char in stack if empty. or check with the top. if equal then pop. else push
    public static String removeDuplicates1(String S) {
        if(S == null || S.length() < 2) return S;
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : S.toCharArray())
        {
            if(!stack.isEmpty() && (stack.peek() == c)) 
                stack.pop();
            else stack.push(c);
        }
        return stack.toString().replaceAll("[^a-zA-Z]", "");
    }
    
    public static void main (String[] args)
    {
       System.out.println( removeDuplicates("abbaca") );
    }
}
