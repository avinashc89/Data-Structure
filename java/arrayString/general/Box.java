package com.tool.java.arrayString.general;

public class Box implements Comparable<Box>{
	
	private int length;
	private int width;
	private int height;
	
	public Box(int length , int width ,int height)
	{
		this.length=length;
		this.height=height;
		this.width = width;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	static int i=10;
	public boolean canBeAbove(Box b)
	{
		if(this.length > b.length && this.width > b.length && this.height > b.height)
			return true;
		else
			return false;
	}
	
	public String toString()
	{
		
		return "["+length+","+width+","+height+"]";
		
	}
	
	@Override
	public boolean equals(Object o)
	{
		System.out.println("equals");
		Box b = (Box)o;
		if(this.length == b.length && this.width == b.width && this.height == b.height)
			return true;
		return false;
		
	}
	
	@Override
	public int hashCode()
	{
		System.out.println("hashcode");
		return Integer.parseInt(""+length+""+height+""+width);		
	}

	@Override
	public int compareTo(Box o) {
		if (this.length > o.length) return 1;
		else if(this.length == o.length) return 0;
		return -1;
	}


}
