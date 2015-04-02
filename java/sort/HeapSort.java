package com.tool.java.sort;

import java.util.Arrays;
 
public class HeapSort {
	
	static int[] a = {2,5,7,6,4,3,8,1};
	
	static int n;
	
	public static void main(String[] args) {
		
		heapSort(a);
		
	}

	private static void heapSort(int[] a) {
		
		 n  = a.length;
		for(int i = n/2-1 ; i>=0 ; i--)
			heapify(a,i);
		
		int len =n;
		for(int i = 0 ; i < len ; i++)
		{
			swap(a,0,n-1);
			n=n-1;
			heapify(a,0);
		}
		
		System.out.println(Arrays.toString(a));
		
	}

	private static void heapify(int[] a, int i) {
		
		int left = 2*i+1;
		int right = 2*i+2;
		int max = i;
		
		if(left < n && a[left] > a[max])
		{
			max = left;
		}
		if(right < n && a[right] > a[max])
		{
			max = right;
		}
		
		if(max!=i)
		{
			swap(a,max,i);
			heapify(a, max);
		}
		
	}
	
	private static void swap(int[] a, int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}


	

}
