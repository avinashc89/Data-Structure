package com.tool.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParsingBooleanExpression
{
    /*
     Input: expression = "!(f)"
    Output: true
    
    Input: expression = "|(f,t)"
    Output: true
    
    Input: expression = "|(&(t,f,t),!(t))"
    Output: false
     */
    
    public static boolean parseBoolExpr(String expression) {
        
        return eval(expression);
        
    }
    
    private static boolean eval(String expression) {
        
        // This function evaluates add, mult or let expression.
        List<String> strs = parse(expression); // say we got ["let", "x", "2", "y", "7", "(mult x 5)"]
        
        if(strs.get(0).equals("&")) 
        {
            boolean flag = cal(strs.get(1));
            for(int i=2; i< strs.size(); i++)
            {
               flag = flag & cal(strs.get(i));
            }
            return flag;
        } 
        else if( strs.get(0).equals("|")) 
        {
            boolean flag = cal(strs.get(1));
            for(int i=2; i< strs.size(); i++)
            {
               flag = flag | cal(strs.get(i));
            }
            return flag;
        } 
        else // for !
        {
            return !(cal(strs.get(1)));
        }
    }
    
    static private boolean cal(String s) 
    {        
        if(s.charAt(0) == '!' || s.charAt(0) == '&' || s.charAt(0)=='|')
        {
            return eval(s);
        } 
        else {
            boolean d =  s.equals("f")?false:true;
            return d;
        }        
    }
    
    public static  List<String> parse(String s) {
        
        int parenthesis_count = 0, start = 2;
        List<String> list = new ArrayList<String>();
        list.add(s.charAt(0)+"");
        for(int i = 2; i < s.length()-1; i++) {
            char c = s.charAt(i);
            if(c == ',' && parenthesis_count == 0) {
                list.add(s.substring(start, i));
                start = i + 1;
            } else if(c == '(') {
                parenthesis_count++;
            } else if(c == ')') {
                parenthesis_count--;
            }
        }
        list.add(s.substring(start, s.length()-1));           // to add last read char
        
        return list;
    }
    
    public static void main (String[] args)
    {
        System.out.println(parseBoolExpr("|(t,f)"));
        System.out.println(parseBoolExpr("!(t)"));
        System.out.println(parseBoolExpr("&(t,t)"));
        System.out.println(parseBoolExpr("|(&(f,t),!(t),&(f,t,f))"));
    }

}
