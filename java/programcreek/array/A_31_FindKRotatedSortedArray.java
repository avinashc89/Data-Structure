package com.tool.java.programcreek.array;

public class A_31_FindKRotatedSortedArray {


	public int search(int[] nums, int target) {
		int left = 0;
		int right= nums.length-1;

		while(left<=right){
			int mid = left + (right-left)/2;
			if(target==nums[mid])
				return mid;

			if(nums[left]<=nums[mid]){
				if(nums[left]<=target&& target<nums[mid]){
					right=mid-1;
				}else{
					left=mid+1;
				}
			}else{
				if(nums[mid]<target&& target<=nums[right]){
					left=mid+1;
				}else{
					right=mid-1;
				}
			}    
		}

		return -1;
	}


	//if duplicate exists
	public boolean searchDup(int[] nums, int target) {
		int left=0;
		int right=nums.length-1;

		while(left<=right){
			int mid = (left+right)/2;
			if(nums[mid]==target)
				return true;

			if(nums[left]<nums[mid]){
				if(nums[left]<=target&& target<nums[mid]){
					right=mid-1;
				}else{
					left=mid+1;
				}
			}else if(nums[left]>nums[mid]){							//a[m]<a[r]
				if(nums[mid]<target&&target<=nums[right]){
					left=mid+1;
				}else{
					right=mid-1;
				}
			}else{
				left++;
			}    
		}

		return false;
	}


}