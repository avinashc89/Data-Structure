package com.tool.java.leetcode;

public class FirstMissingPositiveNUmber
{
    int firstMissingPositiveAnd0(int A[]) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            // when the ith element is not i
            while (A[i] != i) {
                // no need to swap when ith element is out of range [0,n]
                if (A[i] < 0 || A[i] >= n)
                    break;

                //handle duplicate elements
                if(A[i]==A[A[i]])
                    break;
                // swap elements
                int temp = A[i];
                A[i] = A[temp];
                A[temp] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (A[i] != i)
                return i;
        }

        return n;
    }

    public static int firstMissingPositive(int[] A) {
        int n = A.length;

        for (int i = 0; i < n; i++) 
        {
            while (A[i] != i + 1) {
                // no need to swap when ith element is out of range [0,n]
                if (A[i] <= 0 || A[i] >= n)
                    break;

                //already exist in correct location => duplicate
                if(A[i]==A[A[i]-1])
                    break;

                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++){
            if (A[i] != i + 1){
                return i + 1;
            }
        }   

        return n + 1;
    }

    public static void main (String[] args)
    {
        firstMissingPositive(new int[]{4,8,9,11,12});
    }

}
