package com.tool.java.leetcode;

import java.util.*;

public class CountOfSmallerAfterSelf
{
    class Node {
        int val, sum, count;
        Node left, right;
        Node (int val, int sum, int count) {
            this.val = val;
            this.sum = sum;
            this.count = count;
        }
        @Override
        public String toString ()
        {
            // TODO Auto-generated method stub
            return val+","+sum+","+count;
        }
    }
    
    
    //sum means the number of nodes of a node's left branch. count is the number of duplicate element.
    
    public List<Integer> countSmaller1(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        Node root = new Node(nums[nums.length - 1], 0, 1);
        res.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            res.addFirst(findNum(nums[i], root, 0));
        }
        return res;
    }
    
    private int findNum(int num, Node root, int countBigger) {
        if (num == root.val) {
            root.count++;
            return root.sum + countBigger;
        } else if (num < root.val) {
                root.sum++;
            if (root.left == null) {
                root.left = new Node(num, 0, 1);
                return countBigger;
            }
            else return findNum(num, root.left, countBigger);
        } else {
            if (root.right == null) {
                root.right = new Node(num, 0, 1);
                return countBigger + root.sum + root.count;
            }
            else return findNum(num, root.right, countBigger + root.count + root.sum);
        }
    }
    
    //method 2 : using merge sort
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return res;
        int[][] cs = count_sort(nums, 0, n-1);
        int[] counts = new int[n];
        
        for (int[] A : cs) 
            counts[A[2]] = A[1];
        
        for (int count : counts) 
            res.add(count);
        return res;
    }

    public int[][] count_sort(int[] nums, int start, int end) {
        if (start == end) 
            return new int[][] {{nums[start], 0, start}}; // {value, count smallers, index}
        int mid = (end+start)/2;
        return merge_sort(count_sort(nums, start, mid), count_sort(nums, mid+1, end));
    }

    public int[][] merge_sort(int[][] A, int[][] B) {
        int n = A.length;
        int m = B.length; 
        int  res[][] = new int[n+m][3];
        
        int i = 0;      //index for result
        int mem = 0;
        for (int j = 0, k = 0;  i < n+m; ) {
            if (k >= m || (j <n && A[j][0] <= B[k][0]))   // if we put  >= we get the count of greater number in the left.
            {
                A[j][1] += mem;            // if A is smaller, then we get the processed count to it count.
                res[i] = A[j];
                j++;
            }
            else 
            {
                res[i] = B[k];          //if A is bigger, then we need to process B first to get the count. 
                k++;
                mem++;
            }
            i++;
        }
        return res; // [[2, 0, 1], [5, 1, 0]] puts them in sorted. 2nd itr => [[1, 0, 3], [6, 1, 2]]
    }
    
    public static void main (String[] args)
    {
        CountOfSmallerAfterSelf c = new CountOfSmallerAfterSelf();
        System.out.println(c.countSmaller(new int[]{5,2,6,1}));
    }

}
