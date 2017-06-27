package leetcode.DP;

public class HouseRobber {
	/* For every house k, there are two options: either to rob it (include this house: i) or not rob it (exclude this house: e).
	 * 
	 * Include this house:
	 * include = nums[k] + e (money of this house + money robbed excluding the previous house)
	 * 
	 * Exclude this house:
	 * exclude = max(i, e) (max of money robbed including the previous house or money robbed excluding the previous house)
	 * (note that i and e are from the previous step, to make O(1) space)
	 */
	//HouseRobber I - Rob a row of houses
	public int rob(int[] nums) {
	    int include = 0, exclude = 0;
	    for (int k = 0; k < nums.length; k++) {
	        int i = include, e = exclude;
	        include = nums[k] + e;
	        exclude = Math.max(i, e);
	    }
	    return Math.max(include, exclude);
	}
		
	//HouseRobber II - Rob a circular row of houses
	public int robCircularHouses(int[] nums) {
	    if (nums.length == 1) return nums[0];
	    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}
	private int rob(int[] nums, int lo, int hi) {
	    int include = 0, exclude = 0;
	    for (int k = lo; k <= hi; k++) {
	        int i = include, e = exclude;
	        include = nums[k] + e;
	        exclude = Math.max(i, e);
	    }
	    return Math.max(include, exclude);
	}
}
