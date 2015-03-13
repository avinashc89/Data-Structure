package sort;

import java.util.Random;

public class Shellsort 
{
    public static int N = 10;
    public static int[] a = new int[N];
 
    public static void shellSort() 
    {
        int increment = a.length / 2;
        while (increment > 0) 
        {
            for (int i = increment; i < a.length; i++) 	
            {
                int j = i;
                int temp = a[i];
                while (j >= increment && a[j - increment] > temp) 
                {
                    a[j] = a[j - increment];
                    j = j - increment;
                }
                a[j] = temp;
            }
            increment = (int) Math.floor(increment/2);
 
        }
    }
 
    static void printSequence(int[] sorted_sequence) 
    {
        for (int i = 0; i < sorted_sequence.length; i++)
            System.out.print(sorted_sequence[i] + " ");
    }
    
  
 
    public static void main(String args[]) 
    {
        System.out.println("Sorting of randomly generated numbers using SHELL SORT");
        Random random = new Random();
 
        for (int i = 0; i < N; i++)
            a[i] = Math.abs(random.nextInt(20));
 
        System.out.println("\nOriginal Sequence: ");
        printSequence(a);
 
        System.out.println("\nSorted Sequence: ");
        shellSort();
        printSequence(a);
    }
}