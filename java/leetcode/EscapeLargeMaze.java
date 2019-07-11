package com.tool.java.leetcode;

import java.util.*;

public class EscapeLargeMaze
{
 final int MAX_VISIT = 20000;
    
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        for (int[] ij : blocked) {
            String key = ij[0] + "," + ij[1];
            blockedSet.add(key);
        }
        return canVisit(blockedSet, source, target) && canVisit(blockedSet, target, source);
    }
    
    boolean canVisit(Set<String> blocked, int[] start, int[] end) {
        Set<String> visited = new HashSet<>();
        return dfs(blocked, start[0], start[1], end[0], end[1], visited);
    }
    
    boolean dfs(Set<String> blocked, int i, int j, int m, int n, Set<String> visited) {
        visited.add(i + "," + j);
        if (i == m && j == n || visited.size() >= MAX_VISIT) { return true; }
        for (int[] next : new int[][] {{i-1 ,j}, {i+1, j}, {i, j-1}, {i, j+1}}) {
            String nextKey = next[0] + "," + next[1];
            if (next[0] >= 0 && next[1] >= 0 && next[0] < 1e6 && next[1] < 1e6 && !blocked.contains(nextKey) && !visited.contains(nextKey)) {
                if (dfs(blocked, next[0], next[1], m, n, visited)) { return true; }
            }
        }
        return false;
    }

    public static void main (String[] args)
    {
        EscapeLargeMaze e = new EscapeLargeMaze();
        
        System.out.println(e.isEscapePossible(new int[][]{{1,1},{2,2},{3,3}} , new int[]{0,0}, new int[]{5,5})) ;
    }
}
