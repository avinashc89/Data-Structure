package sort;

public class InsertionSort {


	//comparing the befre numbers and insert in the correct place
	public static void main(String[] args) {

		int[] a =  {45,23,11,89,77,98,4,28,65,43};

		for(int i=1; i<a.length;i++)
		{
			if(a[i] < a[i-1]){
				int key = a[i];
				int j=i;

				while(j>0 && a[j-1]>key)
				{
					a[j] = a[j-1];
					j--;

				}
				a[j] = key;
			}
		}

		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+",");

	}

}
