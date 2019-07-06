package com.tool.java.leetcode;

import java.util.List;

public class LongestWordInDictionaryViaDeleting
{
    
    /*
        Input: s = "abpcplea", d = ["ale","apple","monkey","plea"]
        Output:  "apple"
        
        Input:  s = "abpcplea", d = ["a","b","c"]
        Output:  "a"
     */

    //no need to continue loop if word len is less than current ans len. even if its equal we can skip if its alphabetically lower. 
    //since, even it is in answer we wont choose.
    //Also, skip the word if its len is greater than s 
    
    public String findLongestWord(String s, List<String> d) {
        String ans = new String();
        for(String word : d)
        {
            if(word.length() < ans.length() || word.length() > s.length()
              || (word.length() == ans.length() && word.compareTo(ans) > 0))
                continue; //Special case, no need to check.
            
            if(isSubSequence(s, word) && betterAns(word, ans))
                ans = word;
        }
        return ans;
    }
    
    //indexof(char x, 4) => search char x from index 4 to len-1.
    //Using indexOf method. find the first char, if found at n, then search next char at indexof(s[i], n+1)
    private boolean isSubSequence(String s, String word){
        int startPointer = 0;
        for(int i=0; i<word.length(); i++){
            int location = s.indexOf(word.charAt(i), startPointer);
            if(location < 0)
                return false;
            startPointer = location+1;
        }
        return true;
    }
    
    private boolean betterAns(String word, String ans){
        if(word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0))
            return true;
        return false;
    }
}
