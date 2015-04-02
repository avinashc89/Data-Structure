package com.tool.java.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args)
	{
		int[] a = {45,23,11,89,77,98,4,28,65,43};

		for(int j=0 ; j<a.length;j++)
		{
			for(int i =0 ;i<a.length-1-j;i++)
			{
				if(a[i] > a[i+1])
					swap(a,i,i+1);
			}
			System.out.println(Arrays.toString(a));
		}
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+",");
	}


	private static void swap(int[] a, int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

}
