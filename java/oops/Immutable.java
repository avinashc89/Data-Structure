package com.tool.java.oops;

import java.util.Date;
//import java.sql.Date;

public final class Immutable {    //class as final
	
	private final Integer age ;			// instance variable as final
	private final Employee emp;
	private final String name;
	
	//make sure if instance variable are immutable - If mutable, handle in the constructor accordingly
	
	public Immutable(String name, Integer age, Employee emp)
	{
		System.out.println("const");
		this.name = name;
		this.age = age;
		this.emp = new Employee(emp.getCompany());
	}
	
	//No setter method
	
	public Integer getAge() {
		return age;
	}
	public Employee getEmp() {
		return emp;
	}
	public String getName() {
		return name;
	}
	
	 @Override
	    public String toString() {
	        return name +" - "+ age +" - "+ emp.getCompany();
	    }
	
	
	public static void main(String[] args) {
		
		Employee e = new Employee("tcs");
		Immutable a = new Immutable("abc", 12, e);
		
		System.out.println("first:"+a);
		a.getEmp().setCompany("cts");
		System.out.println("second:"+a);
		
		
		Immutable b = a;	
		a = new Immutable("abc", 32,e);
		System.out.println(a);
		System.out.println(b);
	
		String a1 ="myString";
		String b1 = a1;
		a1 = "myString2";
		System.out.println(b1);
		
	}
	
}



class Employee
{
	public Employee(String company)
	{
		this.company = company;
	}
	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public boolean equals(Object o2)
	{
		Employee e2 = (Employee)o2;
		if(this.getCompany() == e2.getCompany())
			return true;
		return false;
		
	}
	
	
}
