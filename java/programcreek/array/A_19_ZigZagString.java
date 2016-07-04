package com.tool.java.programcreek.array;

public class A_19_ZigZagString {
	
	public static void main(String[] args) {
		 	String str = "GEEKSFORGEEKS";
		    int n = 3;
		    printZigZagConcat(str, n);
	}
	
	
	static void printZigZagConcat(String str, int n)
	{
		char[] s = str.toCharArray();
	    // Corner Case (Only one row)
	    if (n == 1) {
	        System.out.println(s);      
	        return;
	    }   
	 
	    // Create an array of strings for all n rows
	    String res[] = new String[n];
	    for(int i=0;i<res.length ;i++)
	    	res[i]="";
	 
	    int row = 0;
	    boolean down = false; // True - down, false - up
	 
	    for (int i = 0; i < s.length; ++i)
	    {
	    	res[row] = res[row]+s[i];		 // append current character to current row
	        
	        if (row == n-1)					// If last row is reached, change direction to 'up'
	          down = false;
	        else if (row == 0)				// If 1st row is reached, change direction to 'down'
	          down = true;
	        
	        if(down)						// If direction is down, increment, else decrement
	        	row++;
	        else
	        	row--;
	    }
	 
	    // Print concatenation of all rows
	    for (int i = 0; i < n; ++i)
	    	 System.out.print(res[i]);      
	}


	/*
	 * 
	 	1) Create an array of n strings, arr[n]
		2) Initialize direction as "down" and row as 0. The 
		   direction indicates whether we need to move up or 
		   down in rows. 
		3) Traverse the input string, do following for every
		   character.
		   a) Append current character to string of current row.
		   b) If row number is n-1, then change direction to 'up'
		   c) If row number is 0, then change direction to 'down'
		   d) If direction is 'down', do row++.  Else do row--.
		4) One by one print all strings of arr[]. 
	 * 
	 */
}
