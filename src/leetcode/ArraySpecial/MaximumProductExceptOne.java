package leetcode.ArraySpecial;

/*
 * Compute the maximum product of all entries except one.
 * Time Complexity: O(n), Space Complexity: O(n)
 */
public class MaximumProductExceptOne {
	public static int maximumProductExceptOne(int[] A){
		int[] L = new int[A.length];
		int[] R = new int[A.length];
		
		int product = 1;
		for(int i = 0; i < A.length; ++i){
			product *= A[i];
			L[i] = product;
		}
		
		product = 1;
		for(int i = A.length - 1; i >= 0; --i){
			product *= A[i];
			R[i] = product;
		}

		int maxProduct = Integer.MIN_VALUE;
		for(int i = 0; i < A.length; i++){
			int forward = i > 0 ? L[i - 1] : 1;
			int backward = i + 1 < A.length ? R[i + 1] : 1;
			maxProduct = Math.max(maxProduct, forward * backward);
		}
		
		return maxProduct;
	}
	
	public static void main(String[] args){
		int[] nums = {3, 2, -1, 4};
		System.out.println(maximumProductExceptOne(nums));
	}
}
