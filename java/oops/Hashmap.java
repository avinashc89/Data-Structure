package com.tool.java.oops;

import java.util.HashMap;

public class Hashmap {
	
	public static void main(String[] args) {
		
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		
		hm.put(10, "Avinash");
		hm.put(345, "Shirram:");
		hm.put(945,"deenash"); //909 //13
		hm.put(567, "harsha");
		hm.put(13, "harsha"); //13 //13
		
		HashMap<Double,String> hm1 = new HashMap<Double,String>();
		hm1.put(0.2, "Avinash");
		
		
		
		System.out.println(hm);
	}

}
