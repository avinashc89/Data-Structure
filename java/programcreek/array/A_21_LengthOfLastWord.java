package com.tool.java.programcreek.array;

public class A_21_LengthOfLastWord {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("this is data "));
	}
	public static int lengthOfLastWord(String s) { 
	    if(s==null || s.length() == 0)
	        return 0;
	 
	    int result = 0;
	    int len = s.length();
	 
	    boolean flag = false;			// to continue the for loop until a letter is found.  
	    for(int i=len-1; i>=0; i--){
	        char c = s.charAt(i);
	        if((c>='a' && c<='z') || (c>='A' && c<='Z'))
	        {  
	            flag = true;
	            result++;
	        }else{
	            if(flag)					//if last letter is  ' ', FLAG IS STILL FALSE. then we souldn't print result
	            return result;
	        }
	    }
	 
	    return result;
	}
}
