package leetcode.Sorting;

import java.util.ArrayList;
import java.util.List;

//O(m+n)
public class IntersectionOfSortedArrays {
	public List<Integer> intersection(int[] A, int[] B) {
		List<Integer> result = new ArrayList<>();
		int i = 0, j = 0;
		while(i < A.length && j < B.length){
			if(A[i] == B[j] && (i == 0 || A[i] != A[i-1])){
				result.add(A[i]);
			} else if(A[i] < B[j]){
				i++;
			} else { //A[i] > B[j]
				j++;
			}
		}
		return result;
	}
}
