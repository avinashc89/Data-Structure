package com.tool.java.leetcode;

import java.util.*;

public class NumberOfIsland2
{
    /*
     Using DSU & parent[] array
     
     parent index = i*m + j => m is no of columns. Say 1,2=> if row=1, column=2, => p[1*m + 2] => 1*m columns + 2.

     Using parent [n][m] for grid[][].  we can convert 2d array to 1d array like parent[n*m] and i,j in the grid is equivalent to parent[i*m+j]
    
     make the parent as -1 to all the cells. 
     iterate the position i,j and get the parent cell. 
       get the parent index for that i,j => p[i*m+j]
            1. if p[i*m+j] != -1 then its duplicate, since already land exist over there. print the existing count, skip the current iteration
            2. if -1 then its water. 
                  make p[i*m+j] = i*m+j
                  get the neighbors, if any one is not -1, then union this  p[i*m+j] & parent of that neighbor. 
                      => union(indexParent, findParent(neigh));
    
    union(x,y). find the parent x and y => p1 & p2. if they are not equal, then assign parent[p1] = p2 and count-- , since we have joined the current land to existing island
    
    */
    public List<Integer> numIslands2(int n, int m, int[][] positions) 
    {
       
        List<Integer> res = new ArrayList<>();
       
        if (positions == null || positions.length == 0) {
            return res;
        }
        parent = new int[n * m];
        cnt = 0;
        
        for (int i = 0; i < n * m; ++i) {
            parent[i] = -1;
        }
        
        for (int[] pos : positions) {
            
            int indexParent = pos[0] * m + pos[1];
            
            if (parent[indexParent] != -1) {               //if duplicates occur(since land is already there), return the same count.
                res.add(cnt);
                continue;
            }
            parent[indexParent] = indexParent;
            ++cnt;
            for (int i = 0; i < 4; ++i) {
                int x = dx[i] + pos[0];
                int y = dy[i] + pos[1];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    int neigh = x * m + y;
                    if (parent[neigh] != -1) {  
                        union(indexParent, findParent(neigh));
                    }
                }
            }
            res.add(cnt);
        }
        return res;
    }
    
    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{1, 0, -1, 0};
    int[] parent;
    int cnt;
    
    private int findParent(int x) {
        int r = x;
        while (r != parent[r]) {
            r = parent[r];
        }
        //we found the r here, but we need to do compression
        //compression => we found the parent by traversing inside r= parent[r]. Now check again if x's parent is r. if not, update it.
        while (parent[x] != r) {
            int tmp = parent[x];        // before saving x's parents as r, we need to know what is the curr parent it has, so that we can go to that parent and check if its parent is r.
            parent[x] = r;
            x = tmp;
        }
        
        return r;
    }
    
    private void union(int r1, int r2) {
        int f1 = findParent(r1);
        int f2 = findParent(r2);
        if (f1 != f2) {
            parent[f1] = f2;
            --cnt;
        }
    }
    
    public static void main (String[] args)
    {
       int m = 8, n = 2;
       int[][] positions = {{7,0}};
       
       NumberOfIsland2 ni = new NumberOfIsland2();
       System.out.println(ni.numIslands2(m, n, positions));
    }

}
