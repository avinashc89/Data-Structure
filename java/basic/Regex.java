package com.tool.java.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		
		
		String pattern = "[\\w]*@\\w[\\w.]+\\w";  //regex email 
		
		String ss = "How are you ";
		Pattern p = Pattern.compile("[a-zA-Z0-9]*\\s");
		
		Matcher m = p.matcher(ss);
		
		System.out.println(m.regionEnd());
		
		int count =0;
		while(m.find())
		{
			System.out.println(m.group());
			count++;
		}
		System.out.println(count);
		
	}
}
