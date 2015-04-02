package com.tool.java.oops;

import java.util.ArrayList;

public class MarkerInterface {
	
	public static void main(String[] args) {
		
		Apple a = new Apple();
		System.out.println(a instanceof Apple); // true
		System.out.println(a instanceof fruit); //true
		
		
		Banana b = new Banana();
		System.out.println(b instanceof Banana);  // true
		System.out.println(b instanceof Yellow);		// true
		System.out.println(b instanceof fruit);		// true
		
		ArrayList<fruit> list = new ArrayList<fruit>();
		
		list.add(a);
		list.add(b);
		
		//if I dont want to add the yellow fruits, marker interface helps in easy coding. 
		// instead of writing if(obj instanceOf banana || obj Instanceof lemon) => if(obj instanceOf Yellow)
		// in future, any new yellow fruit is added, there is no need to change the logic, just implement marker interface(Yellow)
	}
	
	

}


class fruit
{
}


class Apple extends fruit
{
}

class Banana  extends fruit implements Yellow
{
}

class Lemon  extends fruit implements Yellow
{
}


interface Yellow  //marker interface - with no methods
{
}
