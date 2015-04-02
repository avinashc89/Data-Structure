package com.tool.java.sort;

public class MergeSortVer2 {


	public static void main(String[] args)
	{
		int[] a = {45,23,11,89,77,98,4,28,65,43};

		mergeSort(a,0 , a.length-1);

		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+",");
	}

	private static void mergeSort(int[] a, int left, int right) {


		if(left < right)
		{
			int middle = (right+left)/2;
			mergeSort(a, left, middle);
			mergeSort(a, middle+1 , right);
			merge(a,left,middle,right);

		}
	}

	private static void merge(int[] a, int left, int middle, int right) {

		int len1 = middle-left+1;
		int len2 = right-middle;
		
		int m[] = new int[len1];
		int n[] = new int[len2];
		
		for(int i =0 ; i < len1 ; i++)
			m[i] = a[left+i];
		for(int i =0 ; i < len2 ; i++)
			n[i] = a[middle+i+1];

		int i=0;
		int j=0;
		int k=left;

		while (i < len1 && j < len2) 
		{
			if(m[i] < n[j]){
				a[k] = m[i];
				i++;
			}
			else if(m[i] >= n[j]){
				a[k] = n[j];
				j++;
			}				
			k++;
		}
		while (i < len1) {
			a[k] = m[i];
			k++;
			i++;
		}
		while (j < len2) {
			a[k] = n[j];
			k++;
			j++;
		}

	}	


}
