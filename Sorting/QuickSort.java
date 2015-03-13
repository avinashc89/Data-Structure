package sort;

import java.util.Arrays;

public class QuickSort {
	
	

	public static void main(String[] args) {

		int a[] = {12,6,31,23,3,45,20,4,17,2};
		
		System.out.println(Arrays.toString(a));
		
		quickSort(a,0,a.length-1);
		
		System.out.println(Arrays.toString(a));
	}

	private static void quickSort(int[] a, int left, int right) {


		int index = partition(a,left,right);
		if(index-1 > left)
			quickSort(a,left,index-1);
		if(index < right)
			quickSort(a, index, right);


	}

	private static int partition(int[] a, int left, int right) {

		int i = left ;
		int j = right;	 
		int pivot = a[(left+right)/2];
		while(i<=j)						// for each iteration, the end point is - pivot is swapped.  
		{
			while(pivot > a[i])		 	//Once done, the i stops incrementing and j continues to decrement. Once they meet, the loops terminates
				i++;
			while(pivot < a[j])
				j--;
			if(i<=j)
			{
				swap(a,i,j);
				i++;
				j--;
			}

		}
		
		System.out.println(Arrays.toString(a));
		return i;
	}
	
private static void swap(int[] a, int i, int j) {
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}


}
