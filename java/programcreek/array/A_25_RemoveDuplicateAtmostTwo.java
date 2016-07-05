package com.tool.java.programcreek.array;

public class A_25_RemoveDuplicateAtmostTwo {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,1,1,1,2,2,2,2,3,3,3,3,3,4,5,5,6}));
	}
	public static int removeDuplicates(int[] A) {
		if (A.length <= 2)
			return A.length;
 
		int prev = 1; // point to previous
		int curr = 2; // point to current
 
		while (curr < A.length) {
			if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {				// prev doesnt move until this fails. when curr doesn't match with prev or prev-1, new elem is found incr prev and copy the new elem to prev.
				curr++;
			} else {
				prev++;
				A[prev] = A[curr];
				curr++;
			}
		}
 
		return prev + 1;
	}
}
