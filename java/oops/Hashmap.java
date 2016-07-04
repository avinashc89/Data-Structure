package com.tool.java.oops;

import java.util.HashMap;

public class Hashmap {
	
	public static void main(String[] args) {
		
		
		String s =new String("abc");
		String s1 =new String("abc");
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		
		
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		
		hm.put(10, "Avinash");
		hm.put(345, "Shirram:");
		hm.put(945,"deenash"); //909 //13
		hm.put(567, "harsha");
		hm.put(13, "harsha"); //13 //13
		
		HashMap<Double,String> hm1 = new HashMap<Double,String>();
		hm1.put(0.2, "Avinash");
		
		
		
		System.out.println(hm);
		
		
		int a[] = new int[1];
		a[0] = 5;
		
		runRec(a);
		
		System.out.println(a[0]);
	}
	
	public static void runRec(int[] a)
	{
		a[0] = 30;
	}

}
