package sort;

public class BubbleSortVer2 {
	
	public static void main(String[] args)
	{
		int[] a = {45,23,11,89,77,98,4,28,65,43};

		boolean flag = true;
		while(flag)
		{
			flag = false;
			for(int i =0 ;i<a.length-1;i++)
			{
				if(a[i] > a[i+1])
				{
					swap(a,i,i+1);
					flag=true;
				}
			}
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
