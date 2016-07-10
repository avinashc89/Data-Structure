package com.tool.java.arrayString;

public class Testing {

	public static void main(String[] args) {
		subset_That_Sums_To_N_Print_All(new int[]{1,2,3,4,5,6,7} , 0, 0, 7, "");
	}
	
	public static void subset_That_Sums_To_N_Print_All(int[] list, int index, int currSum, int goal, String result)
	{ 
		//if index goes beyond  array length or currSum is greater than given goal sum, just return
		if (list.length < index || currSum>goal)
			return;
		
		//iterate thro' array and add each number to currsum and check with goal sum.
		for (int i = index; i < list.length; i++) {

			if (currSum + list[i]  == goal)   {
				result =  result + " " + list[i];
				System.out.println(result);
				break;
			}
			else if (currSum + list[i] < goal) {
				subset_That_Sums_To_N_Print_All(list, i + 1, currSum + list[i], goal, result + " " + list[i]);
			}
		}
	}
}
