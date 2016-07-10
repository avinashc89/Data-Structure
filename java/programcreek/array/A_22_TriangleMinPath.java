package com.tool.java.programcreek.array;

import java.util.ArrayList;
import java.util.Arrays;

public class A_22_TriangleMinPath {

	public static void main(String[] args) {
		
		ArrayList a1 = new ArrayList(){{
			add(2);
		}};
		ArrayList a2 = new ArrayList(){{
			add(3);add(4);
		}};
		ArrayList a3 = new ArrayList(){{
			add(6);add(5);add(7);
		}};
		ArrayList a4 = new ArrayList(){{
			add(4);add(1);add(8);add(7);
		}};
		
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
		triangle.add(a1);
		triangle.add(a2);
		triangle.add(a3);
		triangle.add(a4);
		
		System.out.println(minimumTotal(triangle));
		System.out.println(minimumTotal(new int[][]{{2},{3,4},{6,5,7},{4,1,8,7}}));
	}
	
	
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[] total = new int[triangle.size()];
		int l = triangle.size() - 1;
	 
		for (int i = 0; i < triangle.get(l).size(); i++) {
			total[i] = triangle.get(l).get(i);
		}
		// iterate from last second row
		for (int i = triangle.size() - 2; i >= 0; i--) {				//	size =4 , last line -3; start from 2 => size-2
			for (int j = 0; j < triangle.get(i).size(); j++) {						//curr list size
				System.out.println(triangle.get(i));
				total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
			}
		}
	 
		return total[0];
	}
	
	//idea - adding from below
	/*
	     2
	    3 4
	   6 5 7
	  4 1 8 7 
	 */
	public static int minimumTotal(int[][] triangle) {
		int[] total = new int[triangle.length];
		int last = triangle.length - 1;
	 
		for (int i = 0; i < triangle[last].length; i++) {
			total[i] = triangle[last][i];
		}
		System.out.println(Arrays.toString(total));
		// iterate from last second row
		for (int i = triangle.length - 2; i >= 0; i--) {				//	size =4 , last line -3; start from 2 => size-2
			for (int j = 0; j < triangle[i].length; j++) {						//curr list size
				total[j] = triangle[i][j] + Math.min(total[j], total[j + 1]);
			}
		}
	 
		return total[0];
	}
	
}
