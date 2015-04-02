package com.tool.java.oops;

public class JavaPassbyValueOrRef {
	
	public static void main(String[] args) {
		
		Dog d = new Dog();
		
		d.setName("jiffy");
		
		foo(d);
		
		System.out.println(d.getName());  // jiffy
		
		//in java, for primitive type - pass by value
		// for complex type - the reference of the object is passed by value(aka pass by reference)
	}

	private static void foo(Dog d) {
		
		System.out.println(d.getName());  // jiffy
		
		d = new Dog ();
		
		d.setName("maxy");
		
	}
	

}



class Dog{
	
	private String name ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
