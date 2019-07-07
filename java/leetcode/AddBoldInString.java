package com.tool.java.leetcode;

public class AddBoldInString
{
    /*
     Input:  s = "abcxyz123"  dict = ["abc","123"]
    Output:  "<b>abc</b>xyz<b>123</b>"

    Input:  s = "aaabbccfill"  dict = ["aaa","aab","bc","fill"]
    Output: "<b>aaabbc</b>c<b>fill</b>"

    we can use merge interval
    => using indexof, we can find the start and end of each interval
    => [0,2], [1,3],[4,5],[7,10] => merge interval => [0,5] [7,10]

    or we can use masking array - boolean array


     */
    final String open = "<b>", close = "</b>";

    public String addBoldTag(String s, String[] dict) {

        boolean[] mask = new boolean[s.length()];

        for (String searched: dict) {
            int a = s.indexOf(searched, 0);
            while (a >= 0) {
                int b = a + searched.length();      //a - start; b- end(excluded)
                int i = a;
                while (i < b) 
                    mask[i++] = true;               // making boolean true for the interval a-b(excluded)
                a = s.indexOf(searched, a + 1);     // again checking if that word is in the string.
            }
        }

        //for input2 => [true, true, true, true, true, true, false, true, true, true, true]
        //if false just append the char.
        //if true, find he end of the true and append => <b> sb.append(s,start,end) </b>
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mask.length ; i++) 
        {
            if (mask[i] == false) 
                sb.append(s.charAt(i));
            else{
                sb.append(open);
                int end = i;
                while (end < mask.length && mask[end]) 
                    end++;
                sb.append(s, i, end);
                sb.append(close);
                i = end-1;
            }
        }
        return sb.toString();
    }

    public static void main (String[] args)
    {
        AddBoldInString a =new AddBoldInString();
        System.out.println( a.addBoldTag("aaabbccfill", new String[] {"aaa","aab","bc","fill"}));
        System.out.println( a.addBoldTag("abcxyz123", new String[] {"abc","123"}));
    }
}
