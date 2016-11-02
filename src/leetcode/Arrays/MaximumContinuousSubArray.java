package leetcode.Arrays;

public class MaximumContinuousSubArray {
	public int maxSubArray(int[] nums) {
        int maxSum = nums[0], max = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxSum = Math.max(nums[i], maxSum + nums[i]);
            max = Math.max(max, maxSum);
        }
        return max;
    }
}
