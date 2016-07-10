package com.tool.java.programcreek.array;

import java.util.Stack;

public class A_36_LargestRectangleHistogramBar {
	
	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[]{2,1,5,6,3,4,6,5,2,3}));
	}
	
	/*
	  2 1 5 6 3 4 6 5 2 3
	        _     _
	      _| |   | |_
	     | | |  _| | |
	     | | |_| | | |  _
	  _  |@|@|@|@|@|@|_| |
	 | |_|@|@|@|@|@|@| | |
	 | | |@|@|@|@|@|@| | |   			@ - max area
	  0 1 2 3 4 5 6 7 8 9
	  
	  for any x, the max area formed around x would be till the boundaries - left : value less that x, right - value less than x
	  for a[8] - 2 - right side - till 9th index and left side till 2nd index
	  
	  using stack for linear time
	  idea- when poping the element from stack, i would have reached the right boundary and stack's top would be the left boundary 
	  
	  area for any x would be = x * (i - top -1)
	 
	 */

	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
	 
		Stack<Integer> stack = new Stack<Integer>();
	 
		int max = 0;
		int i = 0;
	 
		while (i < height.length) {
			//push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
			//calculate max value when the current height is less than the previous one
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}
	 
		}
	 
		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
	 
		return max;
	}
}
