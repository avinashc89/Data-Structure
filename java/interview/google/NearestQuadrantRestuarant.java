package com.tool.java.interview.google;

public class NearestQuadrantRestuarant
{
    
    public NearestQuadrantRestuarant()
    {
        
    }
    
    public Point getNextNearestRestuarant(){
        
        return null;
    }

}

class Quad
{
    public Quad[] children ;
    public Point p;
    
    public int getDistance()
    {
        // returns the distance from Point X to the quadrant. If X is in Quadrant, gives 0
        return 0;
    }
}

class Point 
{
    int x;
    int y;
    
    public int getDistance()
    {
        // returns the distance from Point X to the point.
        return 0;
    }
}
