package com.tool.java.leetcode;

public class EditDistance
{
    /*
       minimum edits to make s1 to s2
       
       s1 = abcdef s2 = azcef => 3 edits => b->z, delete d, f->d
       
        using DP.
       
     */
    
    
    public int minDistance(String word1, String word2) {
        int temp[][] = new int[word1.length()+1][word2.length()+1];
        
        for(int i=0; i < temp[0].length; i++){
            temp[0][i] = i;
        }
        
        for(int i=0; i < temp.length; i++){
            temp[i][0] = i;
        }
        
        for(int i=1;i <=word1.length(); i++){
            for(int j=1; j <= word2.length(); j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    temp[i][j] = temp[i-1][j-1];
                }else{
                    temp[i][j] = 1 + Math.min(Math.min(temp[i-1][j-1], temp[i-1][j]), temp[i][j-1]);
                }
            }
        }
        //printActualEdits(temp, word1, word2);
        return temp[word1.length()][word2.length()];
    }

    public static void main (String[] args)
    {
        EditDistance d = new EditDistance();
        System.out.println(d.minDistance("abcdef", "azced"));
    }
}
