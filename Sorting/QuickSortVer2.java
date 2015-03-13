package sort;

public class QuickSortVer2 {
	
	public static void main(String[] args) {

		int a[] = {12,6,31,23,3,45,20,4,17,2};
		quickSort(a,0,a.length-1);
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+",");
	}

	private static void quickSort(int[] a, int left, int right) {
		
		if(left<right)
		{
			int partition = findPartition(a,left,right);
			quickSort(a, left, partition-1);
			quickSort(a,partition+1,right);
		}
	}

	private static int findPartition(int[] a, int left, int right) {
		
		int pivotIndex = (left+right)/2;
		int pivot = a[pivotIndex];
		swap(a,pivotIndex,right);
		
		int incrIndex = left;
		
		for (int i=left ; i<right;i++)
		{
			if(a[i] < pivot)
			{
				swap(a,incrIndex,i);
				incrIndex++;
			}			
		}
		
		swap(a,incrIndex,right);
		return incrIndex;
	}

	private static void swap(int[] a, int i, int j) {
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}


}
