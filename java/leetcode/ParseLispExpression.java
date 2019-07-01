package com.tool.java.leetcode;

import java.util.*;

public class ParseLispExpression
{
    /*
     
     (mult 3 (add 2 3)) => (mult 3 5) => 15
     
     (add 2 1) => 3
     
     (let a1 3 b2 (add a1 1) b2) => 4
     
     add/mult/let
     
     
     */
    /*hashmap to store LET variables and value
     parse the expression into list. and evalutate accordinly.
         3 type - add / mult / let
         
         if let, put the next two elem in map.
             again when putting in map,<variable,value> , value can 3 types,    
                         2, Y, (mult 1 4)
     */
    
    
    public int evaluate(String expression) {
        
        return eval(expression, new HashMap<String, Integer>());
        
    }    
    
    private int eval(String expression, Map<String, Integer> map) {
       
        // This function evaluates add, mult or let expression.
        List<String> strs = parse(expression.substring(1, expression.length() - 1)); // say we got ["let", "x", "2", "y", "7", "(mult x 5)"]
        
        if(strs.get(0).equals("add")) 
        {
            return cal(strs.get(1), map) + cal(strs.get(2), map);
        } 
        else if(strs.get(0).equals("mult")) 
        {
            return cal(strs.get(1), map) * cal(strs.get(2), map);
        } 
        else //for let
        {
            // if let, second and third must go into map. second would be variable, third is value
            // the value can be 2 or Y or (mult x 5). 
            // let x 2   or  let x (add 1 4) or let x y , where y is already in map
            // for it has to be calculated before putting in map => calc()
            
            Map<String, Integer> next = new HashMap<>(map);
            for(int i = 1; i < strs.size() - 1; i += 2) {
                next.put(strs.get(i), cal(strs.get(i + 1), next));          
            }
            
            //once everything is put in map, eval the last element in list. Again it can be three cases. so send it to calc()
            
            return cal(strs.get(strs.size() - 1), next);
        }
    }
    
    //this resolves three cases
    private int cal(String s, Map<String, Integer> map) {        
        if(s.charAt(0) == '(') {
            // Another let, add or mult expression.
            return eval(s, map);
        } else if(map.containsKey(s)) {
            // Assigned value.
            return map.get(s);
        } else {
            // Integer.
            return Integer.valueOf(s);
        }        
    }
    
    // Breaks down the expression in the current scope, leaving inner scopes untouched.
    // i.e. let x 2 (mult x 5) => ["let", "x", "2", "(mult x 5)"]      
    // let x 2 y 7 (mult x 5) => ["let", "x", "2", "y", "7", "(mult x 5)"] 
    
    //startIndx =0, increment i, whenever ' ' is found, add substring(startIndx,i), make startIndx = i+1.
    // make sure to add only outer expr. ie., total parenthesis count=0
    private List<String> parse(String s) {
        int parenthesis_count = 0, start = 0;
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ' && parenthesis_count == 0) {
                list.add(s.substring(start, i));
                start = i + 1;
            } else if(c == '(') {
                parenthesis_count++;
            } else if(c == ')') {
                parenthesis_count--;
            }
        }
        list.add(s.substring(start));           // to add last read char
        
        return list;
    }
    
    
    public static void main (String[] args)
    {
        ParseLispExpression p = new ParseLispExpression();
       System.out.println( p.evaluate("(let x 2 (mult x 5))"));
    }

}
