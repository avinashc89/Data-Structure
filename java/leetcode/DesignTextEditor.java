package com.tool.java.leetcode;

import java.util.Stack;

public class DesignTextEditor
{
    Stack<Pair> s = new Stack<>();
    //Using stack to keep track of changes.
    
    String moveCursorLeft()   // abc|  => swap | with previous char => ab|c
    {
        Pair curr = s.peek();
        String str = curr.s;
        int ppos = curr.pos;
        int cpos = ppos-1;
        if(ppos > 0){
            str = str.substring(0,cpos)+"|"+str.charAt(cpos)+str.substring(ppos+1);
            s.push(new Pair(str, cpos));
        }
        return s.peek().s;
    }
   
    
    String moveCursorRight()   // a|bc  => swap | with next char => ab|c
    {
        Pair curr = s.peek();
        String str = curr.s;
        int ppos = curr.pos;
        int cpos = ppos+1;
        if(ppos<str.length()-1 ){
            str = (ppos==0? "":str.substring(0,ppos))+str.charAt(cpos)+"|"+str.substring(cpos+1);
            s.push(new Pair(str, cpos));
        }
        return s.peek().s;
    }
   
    
    String insertCharacter(char c)
    {
        if(s.empty())
        {
            s.push(new Pair(c+"|", 1));
        }
        else                                            // ab|c  => add d => abd|c
        {
            Pair curr = s.peek();
            String str = curr.s;
            int ppos = curr.pos;
            str = str.substring(0,ppos)+c+"|"+str.substring(ppos+1);
            s.push(new Pair(str, ppos+1));
        }
        return s.peek().s;
    }
    
    String backspace()              // ab|c  => swap | with previous char => a|c
    {
        Pair curr = s.peek();
        String str = curr.s;
        int ppos = curr.pos;
        int cpos = ppos-1;
        if(cpos >= 0){
            str = str.substring(0,cpos)+"|"+str.substring(ppos+1);
            s.push(new Pair(str, cpos));
        }
        return s.peek().s;
    } 
    
    String undo()           // make sure insert into curr string in stack whenever insert/backspace is called and then update the s.
    {
        if(!s.empty()){
            s.pop();
            if(s.isEmpty())
                return "|";
            else 
                return s.peek().s;
        }
        else{
            return "|";
        }
    }
    
    static class Pair
    {
        String s;
        int pos;
        Pair(String s,int pos) {  this.s=s;this.pos=pos;  }
    }
    
    public static void main (String[] args)
    {
        DesignTextEditor d = new DesignTextEditor();
        System.out.println(d.insertCharacter('a'));
        System.out.println(d.insertCharacter('b'));
        System.out.println(d.insertCharacter('c'));
        System.out.println(d.moveCursorRight());
        System.out.println(d.moveCursorRight());
        System.out.println(d.moveCursorLeft());
        System.out.println(d.moveCursorLeft());
        System.out.println(d.moveCursorLeft());
        System.out.println(d.moveCursorLeft());
        System.out.println(d.moveCursorLeft());
        System.out.println(d.backspace());
        System.out.println(d.insertCharacter('a'));
        System.out.println(d.backspace());
        System.out.println(d.moveCursorRight());
        System.out.println(d.moveCursorRight());
        System.out.println(d.moveCursorRight());
        System.out.println(d.moveCursorRight());
        System.out.println(d.moveCursorRight());
        System.out.println(d.moveCursorRight());
        System.out.println(d.moveCursorRight());
        System.out.println(d.backspace());
        System.out.println(d.backspace());
        System.out.println(d.backspace());
        System.out.println(d.backspace());
        System.out.println(d.undo());
        System.out.println(d.undo());
    }
    /*
     Start with empty text
    text = "|"
    
    insertCharacter('a')
    text = "a|"
    
    insertCharacter('b')
    text = "ab|"
    
    insertCharacter('c')
    text = "abc|"
    
    moveCursorLeft()
    text = "ab|c"
    
    moveCursorLeft()
    text = "a|bc"
    
    backspace()
    text = "|bc"
    
    moveCursorLeft()
    text = "|bc" (nothing happens since cursor was on the leftmost position)
    
    undo()
    text = "a|bc"
    
    undo()
    text = "ab|c"
    
    undo()
    text = "abc|"
    
    undo()
    text = "ab|"
    
    undo()
    text = "a|"
    */
}
