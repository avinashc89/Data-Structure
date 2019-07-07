package com.tool.java.leetcode;

public class RobotReturnToOrigin
{

    ///given string like UDLRRLLDU => did robot come to starting position?
    
    public boolean judgeCircle(String moves)        //use grpah x&y axis.
    {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') x++;
            if (c == 'R') x--;
            if (c == 'U') y++;
            if (c == 'D') y--;
        }
        return x == 0 && y == 0;
    }
    
    //basically count(r) == count(l) and Count(d)==count(u)

}
