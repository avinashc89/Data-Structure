package com.tool.java.programcreek.array;

public class A_20_AddBinaryString {

	//a= "11"(3) and b="1" (1) a+b = "100" (4)
	
	public static void main(String[] args) {
		System.out.println(addBinary("11","1"));
	}
	
	public static String addBinary(String a, String b) {
	    if(a==null || a.length()==0)
	        return b;
	    if(b==null || b.length()==0)
	        return a;
	 
	    int i = a.length()-1;
	    int j = b.length()-1;
	 
	    int carry = 0;
	    StringBuilder sb = new StringBuilder();
	    while(i >= 0 || j >=0){
	        int numA = 0;
	        int numB = 0;
	 
	        if(i >= 0){
	            numA = a.charAt(i)=='0'? 0 : 1;    
	            i--;
	        }
	        if(j >= 0){
	            numB = b.charAt(j)=='0'? 0: 1;
	            j--;
	        }
	 
	        int sum = numA + numB + carry;
	        if(sum >= 2){
	            sb.append(String.valueOf(sum-2));   // subtract 2 from result
	            carry = 1;
	        }else{
	            carry = 0;
	            sb.append(String.valueOf(sum));
	        }
	    }
	 
	    if(carry == 1){
	        sb.append("1");
	    }
	 
	    String reversed = sb.reverse().toString();  // need to reverse
	    
	    return reversed;
	}
}
