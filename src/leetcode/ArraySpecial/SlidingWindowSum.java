package leetcode.ArraySpecial;

public class SlidingWindowSum {
	public static void main(String args[]){
		SlidingWindowSum s = new SlidingWindowSum();
		int num[] = {1,2,4,6};
		int sums[] = s.slidingWindowSum(num,3);
		for(int i = 0;i < sums.length;i++)
			System.out.print(sums[i] + " ");
		System.out.println();
	}

	public int[] slidingWindowSum(int nums[], int k){

		if (nums == null || nums.length == 0 || k <= 0) return new int[] {};

		// current sum, function as a window
		int cur_sum = 0; 

		// check if window_size is greater than num[] size
		if(k > nums.length) {
			for(int i = 0; i < nums.length; i++) cur_sum += nums[i];
			return new int[] {cur_sum};
		}

		// initialize result
		int[] res = new int[nums.length - k + 1];

		// go through nums[]
		for(int i = 0, j = 0; i < nums.length;i++){
			// each time a new number come, add to window
			cur_sum += nums[i];

			// if not the start window, delete the first one from window
			if(i >= k) cur_sum -= nums[i-k];
			
			//size equal to window, add sum to result
			if(i >= k - 1) res[j++] = cur_sum;
		}
		return res;     

	}
}
