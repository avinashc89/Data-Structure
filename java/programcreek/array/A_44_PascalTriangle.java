package com.tool.java.programcreek.array;

import java.util.ArrayList;

public class A_44_PascalTriangle {
	
	/*
	  if n =5 then generate 
	
			 1
			1 1
		   1 2 1
		  1 3 3 1
		 1 4 6 4 1
	 */
	
	public static void main(String[] args) {
		
	}
	
	//idea: add 1 to pre arraylist - calculate the next row using pre arraylist - add to result - now this will act as pre fo next row
	public static ArrayList<ArrayList<Integer>>  generate(int numRows) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows <= 0)
			return result;
	 
		ArrayList<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		result.add(pre);
	 
		for (int i = 2; i <= numRows; i++) {
			ArrayList<Integer> cur = new ArrayList<Integer>();
	 
			cur.add(1); //first
			for (int j = 0; j < pre.size() - 1; j++) {
				cur.add(pre.get(j) + pre.get(j + 1)); //middle
			}
			cur.add(1);//last
	 
			result.add(cur);
			pre = cur;
		}
	 
		return result;
	}
	
	
	// when index is given i=4 then return the 4th row => 1 3 3 1. here no need to use pre/curr.. the result the overwritten with new value
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
	 
		if (rowIndex < 0)
			return result;
	 
		result.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = result.size() - 2; j >= 0; j--) {
				result.set(j + 1, result.get(j) + result.get(j + 1));
			}
			result.add(1);
		}
		return result;
	}

}
