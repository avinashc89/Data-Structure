package com.tool.java.leetcode;

public class SentenceScreenFitting
{
    
    public static int wordsTyping(String[] sentence, int rows, int cols) {
        
        
        if(sentence == null || sentence.length ==0 || rows ==0 || cols ==0)
            return 0;
        int N = sentence.length;
        int count = 0;
        int row = 0;
        int column = cols;
        int i=0;
        while (row < rows)
        {
            if(sentence[i].length()  <= column)
            {
                column = column - sentence[i].length();
                i++;
                if(i == N)
                {
                    i=0;
                    count++;
                }
                column --;
            }
            else
            {
                row++;
                column = cols;
            }
        }
        return count;
    }
    
    public static void main (String[] args)
    {
        System.out.println(wordsTyping1(new String[]{"hello", "world"}, 3, 8));
        System.out.println(wordsTyping1(new String[]{"a", "bcd", "e"}, 3, 6));
    }
    
    /*
      how? consider hello_world_hello_world_hel....
      
      for every row fetch cols num of chars => if cols = 8 , fetches till =>hello_wo. 
      Now back track until ' ' is found. hello_ now the current index is at 6.
      
      For next row, window increases by cols. so fetch another cols chars from 6 => 6+8 => 14 chars are read. Again find for ' '.
      
      atlast , total chars read = pos =  32. but actual total length  = 11. 32/11 => 2 times sentence is repeadted.
      
     */
    public static int wordsTyping1(String[] sentence, int rows, int cols) 
    {
        String sent = String.join(" ", sentence) + " ";
        System.out.println(sent);
        
        int pos = 0, len = sent.length();
        for(int i=0; i<rows; i++) 
        {
            pos += cols;
            while(pos >=0 && sent.charAt(pos%len)!=' '){
                pos--;
            }
            pos++;
        }
        return pos / len;
    }
}
