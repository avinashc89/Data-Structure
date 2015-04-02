package com.tool.java.arrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetfromThreeArrayList {

	static public void main(String[] args)
	{
	        List<List<Integer>> lst = new ArrayList<List<Integer>>();

	        lst.add(Arrays.asList(1, 2));
	        lst.add(Arrays.asList(3, 4, 4));
	        lst.add(Arrays.asList(6, 7, 8));

	        List<List<Integer>> result = null;

	        result = cartesian(lst);

	        for (List<Integer> r : result) {
	            for (Integer i : r) {
	                System.out.print(i + " ");
	            }
	            System.out.println();
	        }
	}

	static public List<List<Integer>> cartesian(List<List<Integer>> list)
	{
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    int numSets = list.size();
	    Integer[] tmpResult = new Integer[numSets];

	    cartesian(list, 0, tmpResult, result);

	    return result;
	}

	static public void cartesian(List<List<Integer>> list, int n, Integer[] tmpResult, List<List<Integer>> result)
	{
	    if (n == list.size()) {
	        result.add(new ArrayList<Integer>(Arrays.asList(tmpResult)));
	        return;
	    }

	    for (Integer i : list.get(n)) {
	        tmpResult[n] = i;
	        cartesian(list, n + 1, tmpResult, result);
	    }
	}
}
