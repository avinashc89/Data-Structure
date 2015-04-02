package com.tool.java.basic;

public class ConstructorChaining extends Parent {

	
	public ConstructorChaining()
	{
		System.out.println("in Child constructor");
	}
	
	public ConstructorChaining(int a)
	{
		System.out.println("in Child constructor with parameter "+a);
	}
	
	
	public static void main(String[] args) {
		
		ConstructorChaining obj = new ConstructorChaining();
		ConstructorChaining obj1 = new ConstructorChaining(10);
		
	}
}


class Parent
{
	public Parent()
	{
		System.out.println("in parent constructor");
	}
	public Parent(int a)
	{
		System.out.println("in parent constructor  with parameter "+a);
	}
}

/**
 * output
 *
 * 
 * in parent constructor
 * in Child constructor
 * in parent constructor
 * in Child constructor with parameter 10
 * /
 */