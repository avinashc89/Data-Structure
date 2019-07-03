package com.tool.java.leetcode;

import java.util.List;

public class MaxFontFrame
{
    /*
     Given a screen with a given width, height and supported min/max font size, 
     determine the max font a given string can be displayed in.
    Word or character can’t be broken. 
    Imagine a method getWidth(char c, int fontSize) and getHeight(int fontSize) are given.
     */
    
    
    int width;
    int height;
    List<Integer> fonts;
    MaxFontFrame (int width, int height, List<Integer> fonts) {
        this.width = width;
        this.height = height;
        this.fonts = fonts;
    }
    public int getWidth (char c, int fontSize) {

        //some calculation
        return 0;
    }
    public int getHeight (int fontSize) {
        
        //some calculation
        return 0;

    }
    public int canFitInt (String input) {
        
        if (input == null || input.length() == 0) {
            return fonts.get(fonts.size() - 1);
        }
        
        //binary search approach
        int left = 0, right = fonts.size() - 1;

        while (left + 1 < right) {
            int mid = (left + right) / 2;
            boolean fits = helper(input, mid);
            if (fits) {                             // if fits move left to increase font
                left = mid;
            } else {
                right = mid;
            }
        }
        
        //when l&r crosses, then we need to check first and last index.
        
        if (helper(input, right)) {
            return right;
        }
        if (helper(input, left)) {
            return left;
        }
        return -1;
    }

    public boolean helper (String input, int fontSize) {
       
        int curHeight = 0;
        int curWidth = 0;
        
        for (int i = 0; i < input.length(); ) {
            // add space 
            while (i < input.length() && input.charAt(i) == ' ') {
                int charSize = getWidth(' ', fontSize);
                if (curWidth + charSize > width) 
                {
                    curHeight += getHeight(fontSize);
                    if (curHeight > height) {
                        return false;
                    }
                    curWidth = 0;
                } else {
                    curWidth += charSize;
                }
                i++;
            }
            // add word
            int wordLen = 0;
            while (i < input.length() && input.charAt(i) != ' ') {
                wordLen += getWidth(input.charAt(i), fontSize);
                i++;
            }
            if (wordLen > width) {
                return false;
            }

            // if cannot fint in one line, and then new a line
            if (curWidth + wordLen > width) {
                curHeight += getHeight(fontSize);
                if (curHeight > height) {
                    return false;
                }
                curWidth = wordLen;
            } else {
                curWidth += wordLen;

            }
            i++;
        }
        return true;
    }
}
