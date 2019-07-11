package com.tool.java.interview.google;

public class ElementMoreThanNk {
	
	public static void main(String[] args) {
		
		int arr1[] = {4, 5, 6, 7, 8, 4, 4};
		int k = 3;
		
		 moreThanNdK(arr1, arr1.length, k);
	}
	
	static void moreThanNdK(int arr[], int n, int k)
	{
		
	    if (k < 2)
	       return;
	 
	    EleCount temp[] = new EleCount[k-1];
	    
	    for (int j = 0; j < temp.length; j++) {
			temp[j] = new EleCount();
		}
	    
	    for (int i=0; i<temp.length; i++)
	        temp[i].c = 0;
	 
	    for (int i = 0; i < n; i++)
	    {
	        int j;
	 
	        for (j=0; j<k-1; j++)
	        {
	            if (temp[j].e == arr[i])
	            {
	                 temp[j].c += 1;
	                 break;
	            }
	        }
	 
	        if (j == k-1)
	        {
	            int l;
	             
	            for (l=0; l<k-1; l++)
	            {
	                if (temp[l].c == 0)
	                {
	                    temp[l].e = arr[i];
	                    temp[l].c = 1;
	                    break;
	                }
	            }
	 
	            if (l == k-1)
	                for (l=0; l<k; l++)
	                    temp[l].c -= 1;
	        }
	    }
	 
	    for (int i=0; i<k-1; i++)
	    {
	        int ac = 0;  // actual count
	        for (int j=0; j<n; j++)
	            if (arr[j] == temp[i].e)
	                ac++;
	        if (ac > n/k)
	           System.out.println( temp[i].e +" count:" +ac );
	    }
	}
}

class EleCount
{
    int e;  // Element
    int c;  // Count
};