package com.tool.java.arrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class String_Array {
	
	static int boof = 10;
	private int check=10;
	
	public static void main(String[] args) {

		
		
		
	//	System.out.println(if_all_character_unique("computer"));
	//	System.out.println(reverseArrayofChar(new char[]{'c','o','m'}));
	//	System.out.println(reverseString("computers"));
	//	System.out.println(wordCompression("aaaassd"));
	//	System.out.println(hopSteps(20));
	//	System.out.println(hopStepsDP(20, new int[20]));
	//	sumofThreeinArray(new int[]{1,5,3,-4,-3,6,2},9);
	System.out.println(Find_Min_In_Rotated_Sorted_Array(new int[]{6,7,8,9,1,2,3,4,5},0,8));
	//	System.out.println(getPermutation("man"));
	//	subset_That_Sums_To_N(new int[]{1,2,3,4,5} , 0, 0, 7, "");
		
		Box b1 = new Box(1,2,3);
		
		Box b2 = new Box(2,3,4);
		Box b3 = new Box(1,4,2);
		Box b4 = new Box(5,6,9);
		Box b5 = new Box(2,5,3);
		Box[] b = new Box[]{b1,b2,b3,b4,b5};
		
	//	System.out.println(stackOfBox(b,b[0]));
	//	System.out.println(generateParenthesis(3));
	}
	/*****************************************************************************/
	public static boolean if_all_character_unique(String s)
	{

		boolean[] a= new boolean[256];
		int i = 0;
		while(i < s.length())
		{
			int x = s.charAt(i);
			if(a[x] == true)
				return false;
			else
				a[x] = true;
			i++;
		}
		return true;
	}
	/*****************************************************************************/
	public static char[] reverse_Array_of_Char(char[] s)
	{
		int i=0;
		int j=s.length-1;
		while ( i < j)
		{
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
		return s;
	}
	/*****************************************************************************/
	public static String reverse_String(String s)
	{
		
		StringBuilder x = new StringBuilder();
		
		for(int  i=s.length()-1 ; i >=0; i--)
			x.append(s.charAt(i));
		
		return x.toString();
	}
	
	/*****************************************************************************/
	
	public static boolean permutation_check(String s1, String s2)
	{
		//int[] x = new  int[256];
		
		//traverse each char in s1 and increment corresponding index in x
		
		
		// traverse each char in s2 and decrement corresponding index in x;
		// if x[i] < 0 return false
		
		
		//traverse all the int in x, if x[i]<0 return false
		return false;
	}
	
	/*****************************************************************************/
	public static String word_Compression(String s)
	{
		if(s==null) return null;
		int count =1;
		char preChar = s.charAt(0);
		StringBuilder x = new StringBuilder();
		
		for(int i=1 ; i< s.length() ; i++)
		{
			char current = s.charAt(i);
			if( current == preChar)
				count++;
			else{
				x.append(preChar).append(count);
				count = 1;
				preChar = current;
			}
		}
		x.append(preChar).append(count);
		if(s.length() > x.length())
			return x.toString();
		else	
			return s;
	}
	/*****************************************************************************/
	public static int hop_Steps(int n)
	{
		if(n < 0) return 0;
		
		if(n == 0) return 1;
		
		return hop_Steps(n-1) + hop_Steps(n-2) + hop_Steps(n-3);
	}
	/*****************************************************************************/
	public static int hop_Steps_DP(int n, int[] map)
	{
		if(n < 0) return 0;
		if(n == 0) return 1;
		if(map[n] > -1) return map[n];
		
		map[n] =  hop_Steps_DP(n-1,map) + hop_Steps_DP(n-2,map) + hop_Steps_DP(n-3,map);
		return map[n];
	}
	
	/*****************************************************************************/
	public static boolean magic_Index(int[] a, int left, int right)
	{
		if(left < right && left < a.length && right > 0){
			
			int mid = (left + right)/2;
			if(a[mid] == mid)
				return true;
			else if(a[mid] > mid)
				return magic_Index(a, left, mid-1);
			else if(a[mid] < mid)
				return magic_Index(a, mid+1, right);
		}
		return false;
	}
	/*****************************************************************************/
	public static int magic_Index_With_Duplicates(int[] a, int left, int right)
	{
		if(left < right && left < a.length && right > 0){
			
			int mid = (left + right)/2;
			if(a[mid] == mid)
				return mid;
			
			int newRight  = Math.min(mid-1 , a[mid]);
			int x = magic_Index_With_Duplicates(a, left , newRight);
			if(x >= 0) return x;
			
			int newLeft  = Math.max(mid+1 , a[mid]);
			int y = magic_Index_With_Duplicates(a, newLeft, right);
			return y;
		}
		return -1;
	}

	/*****************************************************************************/
	public static ArrayList<Box> stackOfBox(Box[] b , Box bottom)
	{
		int max_height =0;
		ArrayList<Box> max_stack = null;
		
		for(int i=0 ; i<b.length ;i++)
		{
			if(b[i].canBeAbove(bottom))
			{
				ArrayList<Box> newStack = stackOfBox(b, b[i]);
				int newHeight = newStack.size();
				if(max_height < newHeight)
				{
					max_height = newHeight;
					max_stack = newStack;
				}
			}
		}
		if(max_stack == null)
			max_stack = new ArrayList<Box>();
		if(bottom !=null)
			max_stack.add(bottom);

		
		
		
		return max_stack;
	}

	/*****************************************************************************/
	@SuppressWarnings("unchecked")
	public static ArrayList<Box> stackOfBox_DynmPrg(Box[] b , Box bottom, HashMap<Box,ArrayList<Box>> h)
	{
		if(bottom !=null && h.containsKey(bottom))
			return (ArrayList<Box>) h.get(bottom).clone();   // get the box max stack if already present in map
		
		int max_height =0;
		ArrayList<Box> max_stack = null;
		
		for(int i=0 ; i<b.length ;i++)
		{
			if(b[i].canBeAbove(bottom))
			{
				ArrayList<Box> newStack = stackOfBox_DynmPrg(b, b[i] , h);
				int newHeight = newStack.size();
				if(max_height < newHeight)				// if new height is greater than max, assign max = new
				{
					max_height = newHeight;
					max_stack = newStack;
				}
			}
		}
		if(max_stack == null)
			max_stack = new ArrayList<Box>();
		if(bottom !=null)
			max_stack.add(0,bottom);
		h.put(bottom , max_stack);	
		
		return max_stack;
	}
	
	/*****************************************************************************/

	//4,6,2,1,5,7,8,3,5  - 1,5,7,8  = startIndex, endIndex, max_count, new_count
	
	//(1,3),(2,4),(2,3),(3,6),(5,7),(3,6),(4,6),(5,7) = use above method
	
	
	/*****************************************************************************/
	// i=0 : ''
	// i =1 : ()
	//i=2 : (()) ()()
	//i=3 : (()()) ((())) (())() ()(()) ()()() derived from i=2
	
	public static HashSet<String> generateParenthesis (int remaining)
	{
		HashSet<String> set = new HashSet<String>();
		if(remaining == 0){
			set.add("");
			return set;
		}
		
		HashSet<String> prevSet = generateParenthesis(remaining -1); 
		for(String s : prevSet)
		{
			for(int i=0 ; i< s.length() ; i++) 
			{
				if(s.charAt(i) == '('){
					String tempFirst = s.substring(0,i+1);     //include ( char => i+1
					String tempLast = s.substring(i+1);
					String newWord = tempFirst + "()" + tempLast;
					set.add(newWord);
				}
			}
			set.add(s+"()");
		}
		
		return set;
	}
	/*****************************************************************************/
	public static int max_benefit(int []s) 
	{
		int maxBenefit = 0;
		int minPrice = s[0];
		for (int i = 1; i < s.length; i++) 
		{
			maxBenefit = Math.max(maxBenefit, s[i] - minPrice);
			minPrice = Math.min(s[i], minPrice);
		}
		return maxBenefit;
	}
	/*****************************************************************************/
	public int maxDiff(int[] a)
	{
		int len = a.length;
	    if (len < 1) return 0;
	    int maxNum = 0;
	    int maxDiff = 0;
	    for(int i = len-1; i >= 0; --i)
	    {
	        if(a[i] > maxNum)
	            maxNum = a[i];
	        int tmpResult = maxNum - a[i];        
	        if(tmpResult > maxDiff)
	            maxDiff = tmpResult;
	    }
	    return maxDiff;
	}
	
	/*****************************************************************************/
	public static int Find_Min_In_Rotated_Sorted_Array(int[] arr, int left, int right)
    {
        if (left == right)    //only one num is present
            return arr[left];

        if (arr[left] < arr[right])  //already sorted with no rotation
            return arr[left];

        int middle = (left + right) / 2;

       if(arr[middle] < arr[right])      //mid to right is sorted- so search left
    	   return Find_Min_In_Rotated_Sorted_Array(arr, left, middle);
       
        else
            return Find_Min_In_Rotated_Sorted_Array(arr, middle + 1, right);
    }
	
	
	/*****************************************************************************/
	public static void sum_of_Three_in_Array(int a[] , int sum)   //o(nlogn + n**2) = o(n**2)
	{
		Arrays.sort(a);   //o(nlogn)
		int n = a.length-1;
		for(int i=0 ; i<n-2 ;i++)
		{
			int j=i+1;
			int k=n;
			while(k>=j)
			{
				int currsum = a[i]+a[j]+a[k];
				if(currsum == sum) 
					{System.out.println(a[i]+" "+a[j]+" "+a[k]);
						j++;
						k--;}
				else
				{
					if(currsum > sum) 
						j++;
					else
						k--;
				}
			}
		}
	}
	
	
	/*****************************************************************************/
	// 10  21  22  100  101  200  300
	//  i                      j    k
	int getCountOfTriangles(int arr[], int n)
	{
		if(n < 3)	return 0;
		
		Arrays.sort(arr);
		
		int totalCount = 0, i = 0, j = 0, k = n - 1;
		while(k > 1) {
			i = 0; j = k - 1;
			
			while(i < j) {
				if(arr[i] + arr[j] <= arr[k])
					++i;
				else {
					totalCount += (j - i);
					--j;
				}
			}
			
			--k;
		}
		
		return totalCount;
	}
	
	
	
	/*****************************************************************************/
	public static boolean isValid(int count[], int k)
	{
	    int val = 0;
	    for (int i=0; i<26; i++)
	        if (count[i] > 0)
	            val++;
	 
	    // Return true if k is greater than or equal to val
	    return (k >= val);
	}
	public static void Substring_with_K_unique_char(char[] s, int k)
	{
	    int u = 0; // number of unique characters
	    int n = s.length;
	 
	    int count[]  = new int[26];
	 
	    for (int i=0; i<n; i++)
	    {
	        if (count[s[i]-'a']==0)
	            u++;
	        count[s[i]-'a']++;
	    }
	 
	    if (u < k)
	    {
	       //"Not enough unique characters";
	        return;
	    }
	 
	    int curr_start = 0, curr_end = 0;
	    int maxlength = 1, max_start = 0;
	 
	   count = new int[26];
	    
	    count[s[0]-'a']++;  // put the first character
	 
	    // Start from the second character and add
	    // characters in window according to above
	    // explanation
	    for (int i=1; i<n; i++)
	    {
	        // Add the character 's[i]' to current window
	        count[s[i]-'a']++;
	        curr_end++;
	 
	        // If there are more than k unique characters in
	        // current window, remove from left side
	        while (!isValid(count, k))
	        {
	            count[s[curr_start]-'a']--;
	            curr_start++;
	        }
	 
	        // Update the max window size if required
	        if (curr_end-curr_start+1 > maxlength)
	        {
	        	maxlength = curr_end-curr_start+1;
	        	max_start = curr_start;
	        }
	    }
	 
	  System.out.println(s.toString().substring(max_start, max_start+maxlength));
	}
	
	
	/*****************************************************************************/
	
	class ListNode {
		int val;
		ListNode next;
	 
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	 
	// Definition for binary tree
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	 
		TreeNode(int x) {
			val = x;
		}
	}
	// get list length
		public int getLength(ListNode head) {
			int len = 0;
			ListNode p = head;
	 
			while (p != null) {
				len++;
				p = p.next;
			}
			return len;
		}
	 
	
	static ListNode h;
	 
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
 
		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}
 
	
	// build tree bottom-up
	public TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
 
		// mid
		int mid = (start + end) / 2;
 
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
	}
	
	
	
	
	
	
	/*
	 * interface: all methods are abstract by default and all variables are final 
	 * abstract class you cant have static methods/variables because static cant be overridden. 
	 * 
	 * Static : static method cant be declared in interface. because method in if has to be overridden. but you cant override static method.
	 * static variable can be declared only inside a class. Used anywhere any method.
	 * instance variable cant be used/declared inside static method. coz, they are non common.
	 * scenarios : utility functions / method's functionality doesnt change or not overridden / no need of creating object. memory save.
	 * static methods are shared bet objects.
	 * static cant be declared inside constructor
	 * 
	 * Final : final class not neeeded to have all variables as final. 
	 * final variable initialised only once. final method : purpose: you dont want the user to give their own functionality for the method.
	 * String, Integer,
	 * JVM can cache final variables -> performance increase.
	 * better optimization by JVM
	 * must be initialized at the time of declaration. final int i; i=10 is wrong - > compilation error
	 * Only final variable is accessible inside anonymous class in Java.
	 * All variable declared inside java interface are implicitly final.
	 * Final methods are bonded during compile time also called static binding.
	 * Making a collection reference variable final means only reference can not be changed but you can add, remove or change object inside collection
	 * final AL<> a = new AL<>(); a = new Vector() -> compilation error
	 * all methods in the final class are implicitly final
	 * 
	 */

}
