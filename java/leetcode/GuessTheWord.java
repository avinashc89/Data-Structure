package com.tool.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GuessTheWord
{

    /*
     
     Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]

        Explanation:
        
        master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
        master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
        master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches. => _c__zz => position and value math
        master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
        master.guess("abcczz") returns 4, because "abcczz" has 4 matches.

        you have 10 guesses to guess the word.
     */
    
    public void findSecretWord(String[] wordlist, Master master) {
        if(wordlist ==null) return;
        int guess =-1;
        List<String> words = new ArrayList<>();
        
        for(String word: wordlist)
            words.add(word);
        
        //not need=> just for better guess
        Collections.sort(words);
            
        for(int i =0; i < 10 && guess!=6; i ++)             // we have 10 tries. and if guess is 6 => we found the secret and stop
        {
            guess = master.guess(words.get(0));         
            words = getLeftCandidates(words, words.get(0), guess); 
            
            //get the score of the first element, lets say guess = 2 => two char in that word X has matched the secret. 
            //now iterate thro the word list and find all the words which has minimum 2 char same as this word X
            // secret = cccccc ;   X = aacaca => guess =2 . 
            // now find all the words that matches the X with at least two places.
            // the resultant word list can have
            //      aaaaaa , first two a matched => 2                   } => all these are potential secret word.
            //      wfcvcc , third, fifth char match => 2          => next time when this word is guess, we get 3
        }   
    }
    
    private List getLeftCandidates(List<String> words, String str, int guess){
        List<String> toReturn = new ArrayList();
        for(String word: words){            
            if(totalMatchCounts(word,str)==guess){
                toReturn.add(word);
            }
        }
        return toReturn;
    }
    
    private int totalMatchCounts(String word1, String word2){
        int count = 0; 
        for(int i=0;i<6;i++){
            if(word1.charAt(i)==word2.charAt(i)){
                count ++;
            }
        }
        return count;
    }
}


//predefined
class Master{
    public int guess(String word) {
        return 0;
    }
}
