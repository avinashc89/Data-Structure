package sort;

public class MergeSort {

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

		int temp[] = new int[right+1];
		for(int idx =left ; idx <= right ; idx++)
			temp[idx] = a[idx];

		int i=left;
		int j=middle+1;
		int k=left;

		while (i <= middle && j <= right) 
		{
			if(temp[i] < temp[j]){
				a[k] = temp[i];
				i++;
			}
			else if(temp[i] >= temp[j]){
				a[k] = temp[j];
				j++;
			}				
			k++;
		}
		while (i <= middle) {
			a[k] = temp[i];
			k++;
			i++;
		}
		while (j <= right) {
			a[k] = temp[j];
			k++;
			j++;
		}

	}	
}
