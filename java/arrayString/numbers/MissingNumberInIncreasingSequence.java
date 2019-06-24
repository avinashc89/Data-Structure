package com.tool.java.arrayString.numbers;

public class MissingNumberInIncreasingSequence
{
    /*
     
     Input: arr[] = {1, 2, 3, 4, 6, 7, 8}
        Output: 5
      
     */
    public static int findMissingElement(int[] array, int low, int high)
    {
        // Invalid input case: if the array size is 0 or less than 0
        if (low > high)
        {
            System.out.println("Invalid Input");
            return -1;
        }
         
        // if the last element of the given array is correctly placed, then we can say that
        // all the elements of the given array are correctly placed
        if (correctlyPlaced(high, array[high]))
        {
            System.out.println("No missing number. All elements are correctly placed");
            return 0;
        }
         
        // place where element not correctly placed starts => a[4] = 6  => low+1 => a[low] -1
        // Missing number must be this element's value minus 1
        if (low == high)
        {
            return array[low]-1;
        }
         
        int mid = (low + high)/2;
         
        if (!correctlyPlaced(mid, array[mid]))  // move to left half
        {
            high = mid;
        }
        else                                    // move to right half
        {
            low = mid + 1;
        }
         
        return findMissingElement(array, low, high);
    }
    
    private static boolean correctlyPlaced(int index, int number)
    {
        // remember we are using 0 based indexing scheme
        if (number == (index + 1))
        {
            return true;
        }
         
        return false;
    }
    
    public static void main (String[] args)
    {
        int res =findMissingElement(new int[]{1, 2, 3, 4, 6, 7, 8}, 0, 6);
        System.out.println(res);
    }

}
