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
	//	System.out.println(subsetVersion2(new int[]{1,2,3,4,5,6,7,8,9}));
	//	System.out.println(getPermutation("man"));
	//	findAllSubsetThatSumsToN(new int[]{2,3,4,5} , 0, 0, 10, "");
		
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
	static void find_All_Subset_That_Sums_To_N(int[] list, int index, int current, int goal, String result)
	{ 
	  if (list.length < index || current>goal)
	          return;
	   for (int i = index; i < list.length; i++) {
	      if (current + list[i] == goal)   {
	    	  result =  result + " " + list[i];
	         System.out.println(result);
	       }
	       else if (current + list[i] < goal) {
	    	   find_All_Subset_That_Sums_To_N(list, i + 1, current + list[i], goal, result + " " + list[i]);
	        }
	  }
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
		return 0;
	}
	
	
	
	/*****************************************************************************/
	public static HashSet<HashSet<Integer>> subset_in_array1(int[] a)
	{
	//	static int lp = 0;
		//int k = check;
		
	//	int k = boof;
		HashSet<HashSet<Integer>> result = new HashSet<HashSet<Integer>> ();
		HashSet<Integer> set  = new HashSet<Integer>();
		for(int i : a)
			set.add(i);
		return generateSubset(result , set);
		
	}

	private static HashSet<HashSet<Integer>> generateSubset(
			HashSet<HashSet<Integer>> result, HashSet<Integer> set) {

		if(!set.isEmpty())
		{
			result.add(set);
			for(int i : set)
			{
				HashSet<Integer> temp = new HashSet<Integer>();
				temp.addAll(set);
				temp.remove(i);
				generateSubset(result, temp);
			}
		}
		return result;
	}
	
	/*****************************************************************************/
	public static HashSet<HashSet<Integer>>  subset_in_array2(int a[])
	{
		HashSet<HashSet<Integer>> result = new HashSet<HashSet<Integer>> ();
		HashSet<Integer> set  = new HashSet<Integer>();
		result.add(set);

		for(int i=0 ; i< a.length ; i++)
		{
			HashSet<HashSet<Integer>> temp = new HashSet<HashSet<Integer>>(); //cloning result into new temp
			for(HashSet<Integer> h : result)
			{
				HashSet<Integer> newset = new HashSet<Integer>();
				newset.addAll(h);
				temp.add(newset);
			}
			for(HashSet<Integer> h : result) // add a[i] to all hashset in result
			{
				h.add(a[i]);
			}
			result.addAll(temp); // combine temp(old result) and new result
		}
		return result;
	}
	
	/*****************************************************************************/
	public static ArrayList<String> permutation_print_all_perm_in_String(String s)
	{
		if(s == null) return null;
		
		ArrayList<String> perm = new ArrayList<String>();
		if(s.length() == 0){
			perm.add("");
			return perm;
		}
		
		char x  = s.charAt(0); // split the first char
		String remaining = s.substring(1);
		ArrayList<String> wordList = permutation_print_all_perm_in_String(remaining);
		for(String word : wordList)     // append the first char in all the places inside the words available in the list
		{
			for(int i=0 ; i<=word.length() ; i++) //i<=length - to include {} list at the base case
			{
				String first = word.substring(0,i);
				String last = word.substring(i);
				String permWord = first + x + last;
				perm.add(permWord);		
			}
		}
		return perm;
		
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
	public static int Find_Min_In_Rotated_Sorted_Array(int[] arr, int left, int right)
    {
        if (left == right)
            return arr[left];

        if (arr[left] < arr[right])
            return arr[left];

        int middle = (left + right) / 2;

       if(arr[middle] < arr[right])
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
