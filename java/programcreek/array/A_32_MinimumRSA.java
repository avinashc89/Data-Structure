package com.tool.java.programcreek.array;

public class A_32_MinimumRSA {

	public static void main(String[] args) {
		System.out.println(findMinWithDup(new int[]{12,15,16, 18 ,22,9,10},0,6));
//		System.out.println(findMin(new int[]{18,22,9, 10 ,12,15,16 }));
//		System.out.println(findMin(null));
//		System.out.println(findMin(new int[]{18}));
//		System.out.println(findMin(new int[]{18,22}));
	}
	
	public static int findMin(int[] nums) {
		
		if(nums==null || nums.length==0) return -1;
	    if(nums.length==1)
	        return nums[0];
	    if(nums.length ==2)
	    	Math.min(nums[0], nums[1]);
	 
	    int left=0;
	    int right=nums.length-1;
	 
	    if(nums[right]>nums[left])			//not rotated
	        return nums[left];
	 
	    int l = nums.length ;
	    while(left <= right){

	    	if(left>=0  && right >=0 && left<l && right<l){
	    		if(right-left==1){				//[22,9]
	    			return nums[right];				//return numx[left] for FindMax in RSA 
	    		}

	    		int m = (left + right)/2;

	    		if(nums[m] > nums[right]) 			//12,15,16, 18 ,22,9,10  
	    			left = m;
	    		else
	    			right = m;						//18,22,9, 10 ,12,15,16   
	    	}
	    }
	    
	    return nums[left];
	}
	
	
	public static int findMinWithDup(int[] num, int l, int r){
	    if(r==l){
	        return num[l];
	    }
	    if(r == l +1){
	        return Math.min(num[l], num[r]);
	    }
	    // 3 3 1 3 3 3
	 
	    int m = (r+l)/2;
	    // already sorted
	    if(r-l==1){
	        return num[l];
	    //right shift one
	    }else if(num[r] == num[l]){
	        return findMinWithDup(num, l+1, r);
	    //go right    
	    }else if(num[m] >= num[l]){
	        return findMinWithDup(num, m, r);
	    //go left    
	    }else{
	        return findMinWithDup(num, l, m);
	    }
	}
}
