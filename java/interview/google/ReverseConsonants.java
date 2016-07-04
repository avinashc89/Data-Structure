package com.tool.java.interview.google;

public class ReverseConsonants {
	
	public static void main(String[] args) {
		System.out.println(reverseConsonants("Hello World"));
		System.out.println(reverseConsonants("HELLO WORLD"));
		System.out.println(reverseConsonants(""));
		System.out.println(reverseConsonants(null));
		System.out.println(reverseConsonants("H"));
		System.out.println(reverseConsonants("O"));
		System.out.println(reverseConsonants("Oo"));
		System.out.println(reverseConsonants("KL"));
		System.out.println(reverseConsonants("KoL"));
		System.out.println(reverseConsonants("KoLi"));
	}

	public static String reverseConsonants(String a){
		
		
		if(a==null ) return null;
		if(a.length() < 2)
			return a;
		
		char[] s = a.toCharArray();
		
		int left = 0;
		int right = a.length()-1;
		
		while(left<right)
		{
			
			while(left < a.length() &&  isVowel(s[left]))
			{
				left++;
			}
			while(right>=0 && isVowel(s[right]))
			{
				right--;
			}
			if(left < a.length() && right >= 0 && left < right)
			{
				char temp = s[left];
				s[left] = s[right];
				s[right] = temp;
			}
			left ++;
			right-- ;
		}
				
		
		return String.valueOf(s);
		
	}
	
	private static boolean isVowel(char a)
	{
		a = Character.toLowerCase(a);
		if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u')
		{
			return true;
		}
		return false;
	}
}
