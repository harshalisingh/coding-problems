package epi.ArraysAndString;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
	public static void main(String[] args){
		List<Integer> A = new ArrayList<>();
		A.add(9);
		A.add(9);
		A.add(9);
		A.add(9);
		plusOne(A);
		for(Integer a : A){
			System.out.print(a);
		}
	}
	public static List<Integer> plusOne(List<Integer> A){
		int n = A.size() - 1;
		A.set(n, A.get(n) + 1);
		for(int i = n; i > 0 && A.get(i) == 10; i--){
			A.set(i, 0);
			A.set(i-1, A.get(i-1) + 1);
		}		
		if(A.get(0) == 10){
			A.set(0, 1);
			A.add(0);
		}		
		return A;
	}
}
