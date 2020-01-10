package com.tool.java.arrayString.general;

public class BackspaceCompare
{

    /*
     Input: S = "ab#c", T = "ad#c"
    Output: true
    Explanation: Both S and T become "ac".
    
    Input: S = "a##c", T = "#a#c"
    Output: true
    Explanation: Both S and T become "c".
*/

    
//  Use two stack for each word. when '#' is encountered, pop the char.  Finally compare two stacks
//  Space&time - o(n)
    public boolean backspaceCompare(String S, String T) {
        return getResult(S.toCharArray()).equals(getResult(T.toCharArray()));
    }
    
    //traverse from back, if # is found increment count++, for next iteration, if count>0, decrement (basically omitting the char)
    private String getResult(char[] c) {
        StringBuilder sb = new StringBuilder();
        int n = c.length;
        int cnt = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (c[i] == '#') {
                ++cnt;
            } else if (cnt > 0) {
                --cnt;
            } else {
                sb.append(c[i]);
            }
        }
        return sb.toString();
    }
    
    //same approach. read both string from back with same above approach. when valid char is read, compare. if not same then return false
    //time - o(n) space o(1)
    public boolean backspaceCompare1(String S, String T) {
        int p1 = S.length()-1;
        int p2 = T.length()-1;
        int b1 = 0;
        int b2 = 0;
        while(p1 >= 0 || p2 >= 0){
            while(p1 >= 0 && (S.charAt(p1) == '#' || b1 > 0)){   //*
                if(S.charAt(p1--) == '#') b1++;
                else b1--;
            } 
            
            while(p2 >= 0 && (T.charAt(p2) == '#' || b2 > 0)) {
                if(T.charAt(p2--) == '#') b2++;
                else b2--;
            }
            
            if(p1 < 0 && p2 < 0) return true;
            else if(p1 < 0 || p2 < 0) return false;
            if(S.charAt(p1--) != T.charAt(p2--)) return false;
        }
        return true;
    }
    
    //*if still letters exist, 
    // if #, increment count 1  
    // if not #(say its letter 'x'), then check #count > 1 and decrement => this way we are count letter 'x'.
    //at the end of the inner loop, p1 points to correct(proper) letter 
}
