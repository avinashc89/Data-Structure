package com.tool.java.oops;

public class StringPool {
	
	public static void main(String[] args) {
		
		//String pool is a special memory area separate from regular heap memory where these string constants are stored.
		
		
		String str = "abc";
		
		/* Above code causes JVM to verify if there is already a string “abc” (same char sequence). 
		 * If such string exist, JVM simply assign the reference of existing object to variable str, 
		 * otherwise a new object “abc” will be created and its reference will be assigned to variable str.
		 */
		
		String str1 = new String("abc");
		
		/*
		 * This version end up creating two objects in memory. One object in string pool having char sequence “abc” 
		 * and second in heap memory referred by variable str and having same char sequence as “abc”.
		 */
		
		String a ="abc";
		String b = "abc";
		System.out.println(a==b);    // true
		System.out.println(a.equals(b)); //true
		
		System.out.println(a.substring(0,3));
		
		String a1 = new String("abc");
		String b1 = new String("abc");
		System.out.println(a1==b1);    // false
		System.out.println(a1.equals(b1)); //true
	}

}
