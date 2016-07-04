package com.tool.java.DP;

public class RodCutting {
	
	//B(i) = max{ Vk + B(i - k)}  B - Best Cost
			//B(8) = Max(V1 + B(7) !! V2 + B(6) !! V3 + B(5) !! V4 + B(4) !! V5 + B(3) !! V6 + B(2) !! V7 + B(1)}
			//Vk = Cost of k where k denotes cut length
			//Example : V1 = 2, V2 = 3, V3 = 7 , V4 = 8, V5 = 9
	
	
	public static int profitDP(int[] value, int length) {
		int[] solution = new int[length + 1];
		solution[0] = 0;

		for (int i = 1; i <= length; i++) {
			int max = -1;
			for (int j = 0; j < i; j++) {
				max = Math.max(max, value[j] + solution[i - (j + 1)]);
				solution[i] = max;
			}
		}
		return solution[length];
	}

	public static void main(String[] args) {
		int[] value = { 2, 3, 7, 8, 9 };
		int len = 5;
		System.out.println("Max profit for length is " + len + ":"
				+ profitDP(value, len));

	}


}
