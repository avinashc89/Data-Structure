package com.tool.java.leetcode;

import java.util.*;

public class MinimumAreaRectangle
{
    /*
     lines may or maynot be parallel to x&y axis

     Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
    Output: 4

    Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
    Output: 2
    formed by: [3,1],[3,3],[4,1],[4,3]



     */

    //Using diagonal. diagonals of rectangle meets at same point and lengths are equal
    // Here diagonal object contains midpoint and len.
    // any two points having same diagonal object will form a rectangle.
    // take two points calc the diagonal object and put in hashmap.
    // if already exist add those two points to the value set.
    //for each key if value is greater than 2 then we have rectangle and iterate through the values and calc area.


    public static class Diagonal {

        double len;
        double x;
        double y;
        public Diagonal(int x1, int y1, int x2, int y2) {
            this.len = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            this.x = (x1 + x2) / 2d;
            this.y = (y1 + y2) / 2d;
        }

        //comparing len & (x,y)
        @Override
        public boolean equals(Object o) {
            // return this.toString().equals(o.toString());  takes longer time

            if (this == o) return true;
            if (!(o instanceof Diagonal)) return false;

            Diagonal diagonal = (Diagonal) o;

            if (Double.compare(diagonal.len, len) != 0) return false;
            if (Double.compare(diagonal.x, x) != 0) return false;
            return Double.compare(diagonal.y, y) == 0;
        }

        @Override
        public String toString ()
        {
            // TODO Auto-generated method stub
            return len+"-"+x+"-"+y;   
        }

        @Override
        public int hashCode() {

            //return toString ().hashCode(); // take longer time
            int result;
            long temp;
            temp = Double.doubleToLongBits(len);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(x);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(y);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }

    public double minAreaFreeRect(int[][] points) {
        Map<Diagonal, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                Diagonal diagonal = new Diagonal(x1, y1, x2, y2);
                map.putIfAbsent(diagonal, new ArrayList<>());
                map.get(diagonal).add(new int[]{ x1, y1, x2, y2 });
            }
        }
        double min = Integer.MAX_VALUE;
        for (Diagonal diagonal : map.keySet()) {
            List<int[]> ls = map.get(diagonal);
            for (int i = 0; i < ls.size(); i++) {
                for (int j = i + 1; j < ls.size(); j++) {
                    int[] p1 = ls.get(i);
                    int[] p2 = ls.get(j);
                    min = Math.min(min, area(p1[0], p1[1], p1[2], p1[3], p2[0], p2[1], p2[2], p2[3]));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0d : min;
    }

    private double area(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4)
    {
        double width = distance(x1, y1, x3, y3);
        double height = distance(x1, y1, x4, y4);
        return width * height;
    }

    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }



    //method 2 => get three points and calculate the fourth point

    public double minAreaFreeRect1(int[][] points) {
        if (points == null || points.length < 4) {
            return 0;
        }

        // check the fourth point
        Set<String> checker = new HashSet<String>();
        for (int[] point : points) {
            checker.add(point[0] + "-" + point[1]);
        }

        // check rectangle
        double result = Double.MAX_VALUE;
        for (int i = 2; i < points.length; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    int[] p1 = points[i], p2 = points[j], p3 = points[k];
                    // get the fourth point //https://www.youtube.com/watch?v=FB7ZuqR_vao
                    int x = p2[0] + p3[0] - p1[0];
                    int y = p2[1] + p3[1] - p1[1];
                    // two lines needs to be vertical
                    if (checker.contains(x + "-" + y) && checkDirectionHelper(p1, p2, p3)) {
                        result = Math.min(result, getAreaHelper(p1, p2, p3));
                    }
                }
            }
        }
        return result == Double.MAX_VALUE ? 0 : result;
    }

    private double getAreaHelper(int[] p1, int[] p2, int[] p3) {
        double d1 = getDistanceHelper(p1, p2);
        double d2 = getDistanceHelper(p2, p3);
        double d3 = getDistanceHelper(p1, p3);
        List<Double> distances = new ArrayList<Double>();
        distances.add(d1);
        distances.add(d2);
        distances.add(d3);
        Collections.sort(distances);
        return distances.get(0) * distances.get(1);
    }

    private double getDistanceHelper(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }

    private boolean checkDirectionHelper(int[] p1, int[] p2, int[] p3) {
        int x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1], x3 = p3[0], y3 = p3[1];
        return (y2 - y1) * (y3 - y1) + (x2 - x1) * (x3 - x1) == 0;
    }

    public static void main (String[] args)
    {
//        MinimumAreaRectangle m = new MinimumAreaRectangle();
//        m.minAreaFreeRect(new int[][] {{1,2},{2,1},{1,0},{0,1}});
//        m.minAreaFreeRect(new int[][] {{0,3},{1,2},{3,1},{1,3},{2,1}});


        //return toString ().hashCode(); // take longer time
        int result;
        long temp;
        temp = Double.doubleToLongBits(12);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(5);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
    }
}

