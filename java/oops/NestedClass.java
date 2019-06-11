package com.tool.java.oops;



import com.apple.tesla.PeopleServiceTest.actionTest.NestedClass.InnerClassPublic;

public class NestedClass {
	
	private int id;
	static int nums; // static member variable can be access from all inner class
	
	private class InnerClassPrivate{
		
		public void print(){
			System.out.println("THis is private inner class with Id:"+id);
			System.out.println("THis is private inner class with num:"+nums);
		}
	}
	
	public  class InnerClassPublic{
		
		public void print(){
			System.out.println("THis is public inner class with Id:"+id);
			System.out.println("THis is public inner class with num:"+nums);
		}
	}
	static class InnerClassStatic{
		
		public void print(){
			System.out.println("THis is static inner class with Id:");//+id); Cant access non static member variable
			System.out.println("THis is static inner class with num:"+nums);
		}
	}
	
	void getInstance()
	{
		InnerClassPrivate obj = new InnerClassPrivate(); // private inner class instance can be created only inside nested classs
		obj.print();
		
		InnerClassPublic obj1 = new InnerClassPublic();
		obj1.print();
	}
	
	void createLocalClass()
	{
		//this is local variable
		final int localVar = 10;
		
		//this is to create local class
		class LocalClass{
			public void print(){
				System.out.println("THis is local class with Id:");
				System.out.println("THis is local class with num:"+nums);
				System.out.println("THis is local class with num:"+localVar); // localVar must be final. scope is different. the value might change inside local method.
			}
		}
		
		LocalClass l = new LocalClass();
		l.print();
	}

}

class Testing
{
public static void main(String[] args) {
	
	NestedClass n = new NestedClass();
	InnerClassPublic obj = n.new InnerClassPublic();
	obj.print();
	
	//cant create InnerClassPrivate from outside NestedClass. since it is private to it.
	//non static public class instance is created with object of Nested Class
	
	NestedClass.InnerClassStatic obj2 = new NestedClass.InnerClassStatic();
	
	//creating instance of static inner class using NestedClass.InnerClassStatic
	
	
}	

}
