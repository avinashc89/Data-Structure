package com.tool.java.leetcode;

import java.util.Stack;

public class GoogleRhymingWords
{
    /*
     Please find explanation here-
    Let 'n' be the number of lines for which we need to find rhythm.
    To calculate number of rhythms for 'n' lines, we will use solution found for 'n-1' lines.
    We will use each possible rhythm from 'n-1' lines to create rhythms for 'n'.
   
    n = 1
    ({A})
    One line can have only one rhythm. Let's denote the rhythm as 'A'
    Possible Rhythms= A
   
    n=2 :
    You can say that the second line will have the same rhythm as first or it can have a different Rhythm.
    ({A,B}) ({A}{B})
    Let's consider ({A,B}):
    A and B both belong to same set. It means that both A and B have same rhythm and can be represented with string "AA"
    Let's consider ({A}{B}):
    A and B both belong to different sets. It can be represented with string "AB"
    Possible Rhythms= AA, AB
   
    n=3:
    Let's first use ({A,B}) from n=2: This set denotes that both first and second line have same rhythm.
    ({A,B,C}) , ({A,B},{C})
    ({A,B,C}) - You can say that third line will have same rhythm as first and second. So, can be represented as "AAA".
    OR
    ({A,B},{C}) - Third line can have different Rhythm than first and second.So, can be represented as "AAB".
    
    Let's use ({A}{B}) from n=2: This set denotes that first and second line have different rhythm.
    ({A,C},{B}), ({A},{B,C}) ({A}{B}{C})
    ({A,C},{B}) - You can say that third line will have same rhythm as first. So, can be represented as "ABA".
    OR
    ({A},{B,C}) - You can say that third line will have same rhythm as second. So, can be represented as "ABB".
    OR
    ({A}{B}{C})- You can say that third line will have different rhythm than both first and second. So, can be represented as "ABC".
    Possible Rhythms - AAA, AAB, ABA , ABB , ABC 
     
     this is a bell partition.
     
     https://www.geeksforgeeks.org/bell-numbers-number-of-ways-to-partition-a-set/
     
         Input:  n = 3
        Output: Number of ways = 5
        Explanation: Let the set be {1, 2, 3}
             { {1}, {2}, {3} }
             { {1}, {2, 3} }
             { {2}, {1, 3} }
             { {3}, {1, 2} }
             { {1, 2, 3} }. 
           
     Using stack 
     
     1=> A 'A'
     2=> we have A,B => AA,A , AB,B
     3=> we have A,B,C => 
             consider AB 'B' => we can append any characted before the 'B' to AB. since the char exist already, it would form diiferent rhyme. 
                         and we can add only one extra char at the end after B. 
                         lets say we add C => ABC, and we add D => ABD => ABC & ABD are both same. 
                      so add A,B,C at the end of AB
                      ABA, ABB, ABC
             
     */
    
    
    class Pair{
        String rhymePattern;
        char maxPrevChar;
        public Pair(String rhymePattern, char maxPrevChar){
            this.rhymePattern = rhymePattern;
            this.maxPrevChar = maxPrevChar;
        }
        @Override
        public String toString ()
        {
            // TODO Auto-generated method stub
            return rhymePattern+":"+maxPrevChar;
        }
    }

    public void printPossibleRhymes(int n){

        // Base case :     
        if(n == 1){
            System.out.println("A");
            return;
        }

        // Each String will have first char as ‘A’
        // atleast : 
        Stack<Pair> possibleRhymesStack = new Stack<>();
        possibleRhymesStack.push(new Pair("A", 'A'));

        // Count : 
        int count = 0;

        // Loop till stack is not empty : 
        while(!possibleRhymesStack.isEmpty()){
            
            // Pop the top elem from stack : 
            Pair poppedElem = possibleRhymesStack.pop();
            
            // Completed lines with Rhymes : 
            if(poppedElem.rhymePattern.length() == n){
                System.out.println(poppedElem.rhymePattern);
                count++;
                continue;
            }

            // Get the last char from popped elem : 
            char lastChar = poppedElem.maxPrevChar;
            
            // Starting from 'A' till lastChar +1, 
            // Try out all possible combinations : 
            for(char ch = 'A'; ch <= lastChar+1; ch++){
                String pattern = new StringBuilder(poppedElem.rhymePattern).append(ch).toString();
                char prevMaxChar =  ch > lastChar ? ch : lastChar;
                Pair p = new Pair(pattern, prevMaxChar);
                possibleRhymesStack.push(p);
            }
        }
        
        System.out.println("Total : " + count);
    }
    

    public static void main (String[] args)
    {
        GoogleRhymingWords g = new GoogleRhymingWords();
        g.printPossibleRhymes(3);
    }
    
    //find count using bell triangle
    /*
        1
        1 2
        2 3 5
        5 7 10 15
        15 20 27 37 52
        
        X1
        X2  Y  => y = x1+x2
     */
    
    static int bellNumber(int n) 
    { 
        int[][] bell = new int[n+1][n+1]; 
        bell[0][0] = 1; 
          
        for (int i=1; i<=n; i++) 
        { 
            // Explicitly fill for j = 0 
            bell[i][0] = bell[i-1][i-1]; 
   
            // Fill for remaining values of j 
            for (int j=1; j<=i; j++) 
                bell[i][j] = bell[i-1][j-1] + bell[i][j-1]; 
        } 
        return bell[n][0]; 
    } 
}
