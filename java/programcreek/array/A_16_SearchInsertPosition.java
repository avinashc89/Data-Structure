package com.tool.java.programcreek.array;

public class A_16_SearchInsertPosition {
	
//	using binary search since it is sorted array
	
	
	public int searchInsert(int[] A, int target) {
        if(A==null||A.length==0)
            return 0;
 
        return searchInsert(A,target,0,A.length-1);
    }
 
    public int searchInsert(int[] A, int target, int l, int r){
        int m=(l+r)/2;
 
        if(target==A[m]) 
            return m;
        else if(target<A[m])  // search left
            return l<m?searchInsert(A,target,l,m-1):l; //if left crosses mid then return left
        else 
        	//search right
            return r>m?searchInsert(A,target,m+1,r):(r+1); //if right crosses mid then return right
    }

}
