package com.tool.java.interview.Beepi;

import java.util.HashMap;

public class BeepiCountGroups {


	public static void main (String[] args) throws java.lang.Exception
	{

		int arr[][] ={
				{1,1,1,0,0,1},
				{1,0,1,0,1,0},
				{1,1,1,0,0,0},
				{0,0,0,1,1,1},
				{0,0,0,0,0,0},
				{1,1,1,1,1,1}
		};

		int m[] = {7,1,2,6,3};
		countGroups(arr,m);
	}

	static boolean checkInput(int[][] m,int[] t)
	{
		boolean inputCheck = true;
		if(m==null || m.length==0) return false;
		
		if(t==null || t.length ==0) return false;
		
		
		for(int i=0;i<m.length;i++)
		{

			for(int j=0;j<m[0].length;j++){
				if(m[i][j]!=0 && m[i][j]!=1){
					inputCheck= false;
					System.out.println("Input can be either 1 or 0");
					break;
				}
			}
		}

		return inputCheck;
	}

	static int[] countGroups(int[][] m, int[] t) {

		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		if(checkInput(m,t)){

			System.out.println("came here");
			boolean visited[][] = new boolean[m.length][m[0].length];

			

			for(int i=0 ; i <m.length ;i++)
			{
				for(int j=0 ; j < m[0].length ; j++)
				{
					if(m[i][j] ==1 && visited[i][j]==false)
					{
						int count = countOnes(m,i,j,visited);
						if(map.containsKey(count))
						{
							map.put(count, map.get(count)+1);
						}
						else{
							map.put(count, 1);
						}
						
					}
				}
			}
			int result[] = new int[t.length];
			for(int i=0;i<t.length;i++)
			{
				if(map.containsKey(t[i]))
					result[i]= map.get(t[i]);
			}
			
			for(int i=0;i<result.length; i++)
				System.out.println(result[i]);
			return result;
		}
		else
			return null;
	}

	static int countOnes(int[][] m,int i, int j,boolean visited[][])
	{

		if ((i >= 0) && (i < m.length) && (j >= 0) && (j < m[0].length))
		{
			if(visited[i][j] == false && m[i][j]==1)
			{
				visited[i][j] = true;
				return 1+countOnes(m,i-1,j,visited) + countOnes(m,i,j-1,visited) + countOnes(m,i,j+1,visited) + countOnes(m,i+1,j,visited) ;
			}	
		}
		return 0;
	}




}
