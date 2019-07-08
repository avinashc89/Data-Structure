package com.tool.java.leetcode;

import java.util.*;
import com.tool.java.Util;

public class RandomPointInRectangles
{

    /*
     https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/discuss/316890/Trying-to-explain-why-the-intuitive-solution-wont-work
     
     if we can have the chance of getting S1 to be 70 % and chance of getting S2 to be 30 %, 
     then chance of getting p1i in S1 is 1 / 70, and chance of getting p2j in S2 is 1 / 30, we have:

        probality_of_getting_p1i = (70 / 100) * (1 / 70) = 1 / 100
        
        probability_of_getting_p2j = (30 / 100) * (1 / 30) = 1 / 100
        
     so we need to know the probability of choosing the rectangle based on some criteria. say, area.
     since  area can easily say the prob of choosing it. the one with small area has less chances. one with large has more chance.
     
     same as weighted index, so put in map <prefix area , index> in 
     
     now from total area say 1200 choose a random number say 457 => find the nearest area 
     */
    
    private int[][] rects;
    private Random r;
    private TreeMap<Integer, Integer> map;
    private int area;

    
    public RandomPointInRectangles(int[][] rects) {
        this.rects = rects;
        r = new Random();
        map = new TreeMap<>();
        area = 0;
        for (int i = 0; i < rects.length; i++)
        {
            //area(w,x,y,z) = > y-w+1 * z-x+1
            area += (rects[i][2] - rects[i][0]+1) * (rects[i][3] - rects[i][1]+1);
            map.put(area, i);
        }
        System.out.println(map); //=> {16=0, 64=1, 66=2} 
    }
    
    public int[] pick() {
        int randInt = r.nextInt(area);
        int key = map.higherKey(randInt);
        int[] rect = rects[map.get(key)];
        //random.nextInt(high - low) + low
        int x = r.nextInt(rect[2] - rect[0] + 1) + rect[0];
        int y = r.nextInt(rect[3] - rect[1] + 1) + rect[1];

        return new int[]{x, y};
    }
    
    public static void main (String[] args)
    {
        RandomPointInRectangles r = new RandomPointInRectangles(new int[][] {{0,0,5,5},{5,5,10,12},{3,3,4,4}});
        Util.printArray(r.pick());
    }
}
