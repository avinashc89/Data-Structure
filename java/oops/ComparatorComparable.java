package com.tool.java.oops;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ComparatorComparable {
	
	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(89,"Shaggy"));
		list.add(new Employee(45,"Toru"));
		list.add(new Employee(17,"Myugen"));
		list.add(new Employee(93,"Jack"));
		list.add(new Employee(52,"Jill"));
		list.add(new Employee(32,"Jimmy"));
		
		Collections.sort(list);
		for(Employee e : list)
			System.out.println(e.name);
		
		
		Collections.sort(list, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				
				return o2.name.compareTo(o1.name);
			}
		});
		for(Employee e : list)
			System.out.println(e.name);
		
		
	}
}


class Employee implements Comparable<Employee>{
	
	int id;
	String name;
	
	Employee(int id,String name){
		this.id=id;
		this.name=name;
	}
	
	@Override
	public int compareTo(Employee o) {
		
		return this.name.compareTo(o.name);
		//return this.id-o.id;
	}
	
}
