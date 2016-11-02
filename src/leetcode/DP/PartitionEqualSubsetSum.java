package leetcode.DP;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) 
	{
		if(nums == null || nums.length == 0) 
			return true;
		int sum = 0;
		for(int n : nums) sum += n;
		if(sum % 2 != 0 ) return false;
		sum /= 2;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		// replace nums[i-1] with nums[i]
		for(int i = 0; i < nums.length; ++ i)
		{
			for(int j = sum; j >= nums[i] ; --j)
				dp[j] = dp[j] || dp[j - nums[i]];
		}
		return dp[sum];
	}

}
