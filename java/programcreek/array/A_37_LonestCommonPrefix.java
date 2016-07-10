package com.tool.java.programcreek.array;

public class A_37_LonestCommonPrefix {


	public static void main(String args[]) {
		String x = "Sumit Summation Summit Sum";
		String[] a = x.split(" ");
		System.out.println("Original String : " + x);
		System.out.println("Common Prefix is : " + findPrefix(a));
	}
	
	//idea: assign the first string as longest prefix. - res
	// find the common prefix with 0th string and 1st string. comparison goes till res (length of prefix found earlier)
	// update the res.
	//finally res will have length of common prefix

	public static String findPrefix(String[] a) {
		int resultLen = a[0].length();
		int curr;
		for (int i = 1; i < a.length; i++) {
			curr = 0;
			while (curr < resultLen && curr < a[i].length()
					&& a[0].charAt(curr) == a[i].charAt(curr)) {
				curr++;
			}
			resultLen = curr;
		}
		return a[0].substring(0, resultLen);
	}

	
	
}
