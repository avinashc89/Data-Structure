package com.tool.java.sort;

public class SelectionSort {


	public static void main(String[] args) {

		//find the minimum number and put in the first place. Repeat for next numbers
		int a[] = {8,9,3,7,1,5,4,2,3};

		for(int i =0 ; i < a.length ;i++)
		{
			int minIndex = i;
			
			for (int j=i+1 ; j < a.length ;j++)
			{
				if(a[j]<a[minIndex])
				{
					minIndex= j;
				}
			}
			swap(a,i,minIndex);
		}


		for(int i=0;i<a.length;i++)
			System.out.print(a[i]);
	}

	private static void swap(int[] a, int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

}