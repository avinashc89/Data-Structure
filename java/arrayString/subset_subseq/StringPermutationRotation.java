package com.tool.java.arrayString.subset_subseq;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.tool.java.matrix_Graph.Util;

public class StringPermutationRotation {

    
  //-----------------Using swap------------------------------------------------//
    
    private void swap(char arr[],int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
    
    public void permute(char[] str,int pos){
        if(pos == str.length){
            Util.printArray(str);
            return;
        }
        for(int i=pos; i < str.length; i++){
            swap(str,pos,i);
            permute(str,pos+1);
            swap(str,pos,i);
        }
    }
    
 //---------------------using substring - removing ith char and merging remaining--------------------------------------------//  
 // Function to print all the permutations of str 
    static void printPermutn(String str, String ans) 
    { 
        // If string is empty 
        if (str.length() == 0) { 
            System.out.print(ans + " "); 
            return; 
        } 
  
        for (int i = 0; i < str.length(); i++) { 
  
            // ith character of str 
            char ch = str.charAt(i); 
  
            // Rest of the string after excluding  
            // the ith character 
            String ros = str.substring(0, i) +  
                         str.substring(i + 1); 
  
            // Recurvise call 
            printPermutn(ros, ans + ch); 
        } 
    } 
    
  //---------------------using hashmap count--------------------------------------------//  
    
    public List<String> permute(char input[]) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            countMap.compute(ch, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        char result[] = new char[input.length];
        permuteUtil(str, count, result, 0, resultList);
        return resultList;
    }
    
    public void permuteUtil(char str[], int count[], char result[], int level, List<String> resultList) {
        if (level == result.length) {
            resultList.add(new String(result));
            return;
        }

        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1, resultList);
            count[i]++;
        }
    }

    //-----------------------------------------------------------------//  

    
    public static void main(String args[]){
        String str = "AABC";
     //   StringPermutationRotation sp = new StringPermutationRotation();
       // sp.permute(str.toCharArray(),0);
        
        printPermutn(str,"");
    }
}