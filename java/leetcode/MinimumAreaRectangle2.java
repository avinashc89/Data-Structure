package com.tool.java.leetcode;

import java.util.*;

public class MinimumAreaRectangle2
{
    /*
     lines are parallel to x&y axis
     
     Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
    Output: 4

    Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
    Output: 2
    formed by: [3,1],[3,3],[4,1],[4,3]

    use hash map

     */
    public int minAreaRect(int[][] points)
    {
        int minArea = Integer.MAX_VALUE;
        boolean rectangleExists = false;
        Map<Integer, Set<Integer>>map = new HashMap<>();
        for (int[]point:points)
        {
            if (!map.containsKey(point[0]))
            {
                Set<Integer>y=new HashSet<>();
                y.add(point[1]);
                map.put(point[0],y);
            }
            else 
                map.get(point[0]).add(point[1]);
        }
        for (int i=0; i<points.length; i++)
        {
            int point1[] = points[i];
            for (int j=i+1; j<points.length; j++)
            {
                int point2[] = points[j];
                if (point1[0]==point2[0]||point1[1]==point2[1]) // ignoring the points if they are in same line. 
                    continue;
                else {
                    if (map.get(point1[0]).contains(point2[1]) &&
                        (map.get(point2[0]).contains(point1[1])))    // ex: 1,1 & 3,3. we need to check if there exist a point such that 1,3 & 3,1 exist. if does rectangle can be formed.
                    {
                        //area = (x1-x2)*(y1-y2)
                        minArea = Math.min(minArea, Math.abs((point2[0]-point1[0])*(point2[1]-point1[1])));
                        rectangleExists=true;
                    }
                }
            }
        }
        return rectangleExists?minArea:0;
    }

}
