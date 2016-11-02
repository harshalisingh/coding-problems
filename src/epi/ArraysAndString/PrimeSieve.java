package epi.ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeSieve {
	public static List<Integer> generatePrimes(int n){
		List<Integer> primes = new ArrayList<>();
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int p = 2; p <= n; ++p){
			if(isPrime[p]){
				primes.add(p);
				
				for(int j = p; j <= n; j+=p){
					isPrime[j] = false;
				}
			}
		}
		
		return primes;
	}

}
