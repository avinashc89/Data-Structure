package com.tool.java.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class SentenceSimilarity2 // transitive
{
    /*
     Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.

        For example, "great acting skills" and "fine drama talent" are similar, if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].

        Note that the similarity relation is transitive. For example, if "great" and "fine" are similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar.

        However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

        Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.

        Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"]. 
     */

    //Using HashMap<String,Set<String>>
    public static boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {

        if (words1.length != words2.length) return false;

        Map<String, Set<String>> map = new HashMap();

        for (List<String> pair : pairs) {
            map.putIfAbsent(pair.get(0), new HashSet());
            map.putIfAbsent(pair.get(1), new HashSet());
            map.get(pair.get(0)).add(pair.get(1));
            map.get(pair.get(1)).add(pair.get(0));
        }

        for (int i = 0; i < words1.length; ++i) {
            if (words1[i].equals(words2[i])) 
                continue;
            if (!map.containsKey(words1[i]))
                return false;
            else
            {
                Queue<String> q = new LinkedList<String>();
                boolean flag = false;
                q.addAll(map.get(words1[i]));
                while(!q.isEmpty())
                {
                    String s = q.remove();
                    if(s.equals(words2[i])){
                        flag = true;
                        break;
                    }
                    else
                        q.addAll(map.get(s));
                    
                }
                if(flag)
                    continue;
                else
                    return false;
            }
        }
        return true;
    }
    
    ///using union compression
    public static Map<String ,String> map = new HashMap<>();
    public static boolean areSentencesSimilarTwo1(String[] words1, String[] words2, List<ArrayList<String>> pairs) {
        if(words1.length!=words2.length) return false;
        
        //making its parent as itself
        for(List<String> p: pairs){
            map.putIfAbsent(p.get(0), p.get(0));
            map.putIfAbsent(p.get(1), p.get(1));
          }
        
        System.out.println(map);
        
        //union set
        for(List<String> p: pairs){
          union(p.get(0), p.get(1));
        }
        
        System.out.println(map);
        
        for(int i=0; i<words1.length; i++){
            String pa = findParent(words1[i]);
            String pb = findParent(words2[i]);
            if(pa!=pb) 
                return false;
        }
        
        System.out.println(map);
        return true;
    }
    
    static String findParent(String a){
        while(a!= map.get(a)) 
            a=map.get(a);
        return map.get(a);
    }
    static void union(String a, String b){
        String pa = findParent(a);
        String pb = findParent(b);
        if(pa!=pb) {
            map.put(pa, b);
        }
    }
    
    
    public static void main (String[] args)
    {
        String[] words1 = {"this","summer","thomas","get","really","very","rich","and","have","any","actually","wonderful","and","good","truck","every","morning","he","drives","an","extraordinary","truck","around","the","nice","city","to","eat","some","extremely","extraordinary","food","as","his","meal","but","he","only","entertain","an","few","well","fruits","as","single","lunch","he","wants","to","eat","single","single","and","really","healthy","life"};
        String[] words2 = {"this","summer","thomas","get","very","extremely","rich","and","possess","the","actually","great","and","wonderful","vehicle","every","morning","he","drives","unique","extraordinary","automobile","around","unique","fine","city","to","drink","single","extremely","nice","meal","as","his","super","but","he","only","entertain","a","few","extraordinary","food","as","some","brunch","he","wants","to","take","any","some","and","really","healthy","life"};
        
        String[][] list = {{"good","wonderful"},{"nice","well"},{"fine","extraordinary"},{"excellent","good"},{"wonderful","nice"},{"well","fine"},{"extraordinary","excellent"},{"great","wonderful"},{"one","the"},{"a","unique"},{"single","some"},{"an","one"},{"the","a"},{"unique","single"},{"some","an"},{"any","the"},{"car","wagon"},{"vehicle","car"},{"auto","vehicle"},{"automobile","auto"},{"wagon","automobile"},{"truck","wagon"},{"have","have"},{"take","take"},{"eat","eat"},{"drink","drink"},{"entertain","entertain"},{"meal","food"},{"lunch","breakfast"},{"super","brunch"},{"dinner","meal"},{"food","lunch"},{"breakfast","super"},{"brunch","dinner"},{"fruits","food"},{"own","own"},{"have","have"},{"keep","keep"},{"possess","own"},{"very","very"},{"super","super"},{"really","really"},{"actually","actually"},{"extremely","extremely"}};
        
        List<ArrayList<String>> pairs  = twoDArrayToList(list);
        
        SentenceSimilarity2 s = new SentenceSimilarity2();
         
        System.out.println(s.areSentencesSimilarTwo1(words1,words2,pairs));
    }
    
    

     public static List<ArrayList<String>> twoDArrayToList(String[][] twoDArray) {
        List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        for (String[] array : twoDArray) {
            ArrayList<String> temp = new ArrayList<String>();
            for(String s : array)
            {
                temp.add(s);
            }
            list.add(temp);
        }
        return list;
    }

}
