package com.tool.java.leetcode;

import java.util.*;

public class RemoveComments
{
    
    //https://leetcode.com/problems/remove-comments/discuss/283030/0ms-Beats-100-Java-Solution(Very-Clean-Readable-and-Easy-to-Understand!)
    
//   Input:  source = ["a/*comment", "line", "more_comment*/b"]
//   Output: ["ab"]
//   Explanation: The original source string is "a/*comment\nline\nmore_comment*/b", where we have bolded the newline characters.  After deletion, the implicit newline characters are deleted, leaving the string "ab", which when delimited by newline characters becomes ["ab"].

    

//    iterate through all lines
//     find the index of "//" and "/*"
//        1.1. if both not found, add the line if non-empty
//        1.2. if "//" found first, just delete everything after "//", add the line if non-empty
//        1.3. if "/*" found first, 
                //go find the matching "*/", delete everything in between.
                //move one step back in iteration so that the same line will be parsed again in the next iteration. (since new comment can start again in the same line)

     // if // is found first /* has to be ignored and vice versa.
    // So when for String "main/*void // public" => // would fetch me index but it has to be ignored if /* index is less than that
    
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<String>();
        
        String LC = "//"; // line comment
        String BCS = "/*"; // block comment start
        String BCE = "*/"; // block comment end
        
        for(int i=0 ; i<source.length ; i++)
        {
            int idxLC = source[i].indexOf(LC);
            int idxBCS = source[i].indexOf(BCS);
            
            if (idxLC != -1 || idxBCS != -1) {                                  // found comment
                if (idxLC != -1 && (idxLC < idxBCS || idxBCS == -1)) {          // if // is found and (it is before /* or /* is not found)
                    source[i] = source[i].substring(0, idxLC);
                }
                else                                                            // block element  found first
                {
                    String s = source[i].substring(0, idxBCS);                  //copy first part ( before /*)
                    int fromIndex = idxBCS +2;
                    int idxBCE = -1;
                    while(true)
                    {
                        idxBCE = source[i].indexOf(BCE, fromIndex);
                        if(idxBCE == -1)
                        {
                            i++;
                            fromIndex =0;
                        }
                        else
                        {
                            break;
                        }
                    }
                    s = s + source[i].substring(idxBCE +2,source[i].length());
                    source[i] = s;
                    i--;
                    continue;    // since it can have same string to search the comments
                }
            }
            if(!source[i].isEmpty())
                res.add(source[i]);
        }
        return res;
    }
}
