package com.tool.java.arrayString.parenthesis;

import java.util.HashSet;

public class SubsetOfParenthesis
{
    //Print all combinations of balanced parentheses

    /*
     * 
        Input : n=1
        Output: {}
        
        Input : n=2
        Output: 
        {}{}
        {{}}
        
     Keep track of counts of open and close brackets.

        Initialize these counts as 0.
        Recursively call the _printParenthesis() function until open bracket count is less than the given n.
        If open bracket count becomes more than the close bracket count, then put a closing bracket and recursively call for the remaining brackets.
        If open bracket count is less than n, then put an opening bracket and call _printParenthesis() for the remaining brackets.

      
     */
    
    static void printParenthesis(char str[], int pos, int n, int open, int close) 
    { 
        if(close == n)  
        { 
            // print the possible combinations 
            for(int i=0;i<str.length;i++) 
                System.out.print(str[i]); 
            System.out.println(); 
            return; 
        } 
        else
        { 
            if(open > close) { 
                str[pos] = '}'; 
                printParenthesis(str, pos+1, n, open, close+1); 
            } 
            if(open < n) { 
                str[pos] = '{'; 
                printParenthesis(str, pos+1, n, open+1, close); 
            } 
        } 
    } 
    
    static void printParenthesis(char str[], int n) 
    { 
        if(n > 0) 
        printParenthesis(str, 0, n, 0, 0); 
        return; 
    } 
    
    
    
    
    public static HashSet<String> generateParenthesis (int remaining)
    {
        HashSet<String> set = new HashSet<String>();
        if(remaining == 0){
            set.add("");
            return set;
        }
        
        HashSet<String> prevSet = generateParenthesis(remaining -1); 
        for(String s : prevSet)
        {
            for(int i=0 ; i< s.length() ; i++) 
            {
                if(s.charAt(i) == '('){
                    String tempFirst = s.substring(0,i+1);     //include ( char => i+1
                    String tempLast = s.substring(i+1);
                    String newWord = tempFirst + "()" + tempLast;
                    set.add(newWord);
                }
            }
            set.add(s+"()");
        }
        
        return set;
    }
      
    // driver program  
    public static void main (String[] args)  
    { 
        int n = 3; 
        char[] str = new char[2 * n]; 
        printParenthesis(str, n); 
        System.out.println(generateParenthesis(n));
    } 
}
