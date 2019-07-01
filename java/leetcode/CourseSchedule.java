package com.tool.java.leetcode;

import java.util.*;

public class CourseSchedule
{

    // [1,0] => finish 1 and then 0.
    // [0,2] [1,2][2,3][1,4][4,5][3,5][] = > can take => 012435 / 012345 / 014235
    // to get how the course to be table, do topological sorting.
    ArrayList[] graph;
    public  boolean canFinish(int numCourses, int[][] prereq) {


        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<Integer>();

        for(int i=0; i< prereq.length; i++)
        {
            graph[prereq[i][1]].add(prereq[i][0]);
        }

        Set<Integer> whiteSet = new HashSet<>();
        Set<Integer> graySet = new HashSet<>();
        Set<Integer> blackSet = new HashSet<>();
        
        for(int i = 0; i < numCourses; i++){
            whiteSet.add(i);
        }

       for(int i =0; i< numCourses; i++){
            
            if(dfs(whiteSet, graySet, blackSet, i))   
                return false;
        }
        return true;
    }

    public boolean dfs(Set<Integer> whiteSet, Set<Integer> graySet, Set<Integer> blackSet, int course){

        //shift elem from white to gray
        whiteSet.remove(course);
        graySet.add(course);

        //get neighbours
        ArrayList<Integer> adj = graph[course];
      
        //check all nodes from adjacency list
        for(int var: adj){
            if(blackSet.contains(var))  //if a node has completed visitng all child nodes
                continue;
            if(graySet.contains(var))      //if we reach to a node which is in progress
                return true;
            if((dfs(whiteSet, graySet, blackSet, var) ))        //if this calls get true as return that means there is cycle, return true otherwise false
                return true;


        }

        //shift form gray to black
        graySet.remove(course);
        blackSet.add(course);          
        return false;

    }
    
    
    public static void main (String[] args)
    {
        CourseSchedule c = new CourseSchedule();
        ///System.out.println(c.canFinish(6, new int[][]{{0,2}, {1,2},{2,3},{1,4},{4,5},{3,5}}));
        
        System.out.println(c.canFinish(4, new int[][]{{1,0}, {2,0},{3,1},{3,2}}));
    }

}
