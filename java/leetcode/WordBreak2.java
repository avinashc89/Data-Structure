package com.tool.java.leetcode;

import java.util.*;

public class WordBreak2
{

    public String breakWordDP(String word, Set<String> dict){
        int T[][] = new int[word.length()][word.length()];
        
        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length ; j++){
                T[i][j] = -1; //-1 indicates string between i to j cannot be split
            }
        }
        
        //fill up the matrix in bottom up manner
        for(int l = 1; l <= word.length(); l++){
            for(int i=0; i < word.length() -l + 1 ; i++){
                int j = i + l-1;
                String str = word.substring(i,j+1);
                //if string between i to j is in dictionary T[i][j] is true
                if(dict.contains(str)){
                    T[i][j] = i;
                    continue;
                }
                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true 
                for(int k=i+1; k <= j; k++){
                    if(T[i][k-1] != -1 && T[k][j] != -1){
                        T[i][j] = k;
                        break;
                    }
                }
            }
        }
        if(T[0][word.length()-1] == -1){
            return null;
        }
        
        //create space separate word from string is possible
        StringBuffer buffer = new StringBuffer();
        int i = 0; int j = word.length() -1;
        while(i < j){
            int k = T[i][j];
            if(i == k){
                buffer.append(word.substring(i, j+1));
                break;
            }
            buffer.append(word.substring(i,k) + " ");
            i = k;
        }
        
        return buffer.toString();
    }
    
    //check if exist. 
    public boolean wordBreakBottomUp(String s, List<String> wordList) {
        boolean[] T = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        T[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(T[j] && set.contains(s.substring(j, i))) {
                    T[i] = true;
                    break;
                }
            }
        }
        return T[s.length()];
    }
    
    
    //word-break-i
    public boolean wordBreakTopDownOneSolution(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<String>(wordDict);
        Map<Integer, Boolean> dp = new HashMap<>();
        int max = 0;
        for (String s1 : wordDict) {
            max = Math.max(max, s1.length());
        }
        boolean res = wordBreakTopDownOneSolutionUtil(s, dict, 0, max, dp);
        return res;
        //{0=true, 4=true, 9=true, 12=true}= >pine apple pen apple
    }

    private boolean wordBreakTopDownOneSolutionUtil(String s, Set<String> dict, int start, int max, Map<Integer, Boolean> dp) {
        if (start == s.length()) {
            return true;
        }

        if (dp.containsKey(start)) {
            return dp.get(start);
        }

        for (int i = start; i < start + max && i < s.length(); i++) {
            String newWord = s.substring(start, i + 1);
            if (!dict.contains(newWord)) {
                continue;
            }
            if (wordBreakTopDownOneSolutionUtil(s, dict, i + 1, max, dp)) {
                dp.put(start, true);
                return true;
            }
        }
        dp.put(start, false);
        return false;
    }
    
    /**
     * Prints all the words possible instead of just one combination.
     * Reference
     * https://leetcode.com/problems/word-break-ii/
     */
    public List<String> wordBreakTopDown(String s, Set<String> wordDict) {
        HashSet<String> dict = new HashSet<String>(wordDict);
        Map<Integer, List<String>> dp = new HashMap<>();
        int max = 0;
        for (String s1 : wordDict) {
            max = Math.max(max, s1.length());
        }
        return wordBreakUtil(s, dict, dp, 0, max);
    }

    private List<String> wordBreakUtil(String s, Set<String> dict, Map<Integer, List<String>> dp, int start, int max) {
        if (start == s.length()) {
            return Collections.singletonList("");
        }

        if (dp.containsKey(start)) {
            return dp.get(start);
        }

        List<String> words = new ArrayList<>();
        for (int i = start; i < start + max && i < s.length(); i++) {
            String newWord = s.substring(start, i + 1);
            if (!dict.contains(newWord)) {
                continue;
            }
            List<String> result = wordBreakUtil(s, dict, dp, i + 1, max);
            for (String word : result) {
                String extraSpace = word.length() == 0 ? "" : " ";
                words.add(newWord + extraSpace + word);
            }
        }
        dp.put(start, words);
        return words;
    }
    
    public static void main (String[] args)
    {
        WordBreak2 w = new WordBreak2();
        String[] s = new String[] {"apple", "pen", "applepen", "pine", "pineapple"};
        System.out.println(w.wordBreakTopDownOneSolution("pineapplepenapple", Arrays.asList(s)));
    }
    
}
