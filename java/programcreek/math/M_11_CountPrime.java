package com.tool.java.programcreek.math;

public class M_11_CountPrime {

	
	
	public int countPrimes(int n) {
		if (n <= 2)
			return 0;
	 
		boolean[] primes = new boolean[n];
		for (int i = 2; i < n; i++)
			primes[i] = true;
	 
		//making the divisibles false - for any n, prime numbers till n will always be less than sqrt(n)
		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
			if (primes[i]) {
				for (int j = i*2; j < n; j += i)
					primes[j] = false;
			}
		}
	 
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}
	 
		return count;
	}
	
	
}
