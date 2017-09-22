package leetcode.Greedy;

/*
 * https://leetcode.com/problems/jump-game/#/description
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
	For example:
	A = [2,3,1,1,4], return true.
	
	A = [3,2,1,0,4], return false.
 */
public class JumpGame {
	enum Index {
		GOOD, BAD, UNKNOWN
	}
	/*
	 * Dynamic Programming Bottom-up
	 * Time complexity : O(n^2)
	 * For every element in the array, say i, we are looking at the next nums[i] elements to its right aiming to find a GOOD index. 
	 * nums[i] can be at most n, where n is the length of array nums.
	 * Space complexity : O(n). This comes from the usage of the memo table.
	 */
	public boolean canJumpDP(int[] nums) {
		Index[] memo = new Index[nums.length];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = Index.UNKNOWN;
		}
		memo[memo.length - 1] = Index.GOOD;

		for (int i = nums.length - 2; i >= 0; i--) {
			int furthestJump = Math.min(i + nums[i], nums.length - 1);
			for (int j = i + 1; j <= furthestJump; j++) {
				if (memo[j] == Index.GOOD) {
					memo[i] = Index.GOOD;
					break;
				}
			}
		}

		return memo[0] == Index.GOOD;
	}
	
	/*
	 * Time complexity : O(n). We are doing a single pass through the nums array, hence n steps, where n is the length of array nums.
	 * Space complexity : O(1). We are not using any extra memory.
	 */
	public boolean canJumpGreedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
	
	/*
	 * Find The minimum number of jumps to reach the last index.
	 * https://leetcode.com/problems/jump-game-ii/#/description
	 * The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], 
	 * curFarthest is the farthest point that all points in [curBegin, curEnd] can reach. 
	 * Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest
	 */
	public int minJumps(int[] A) {
		int curEnd = 0, curFarthest = 0, steps = 0;
		for (int i = 0; i < A.length - 1; i++) {
			curFarthest = Math.max(curFarthest, A[i] + i);
			if (curFarthest >= A.length - 1) {
				steps++;
				break;
			}
			if (i == curEnd) {
				steps++;
				curEnd = curFarthest;
			}
		}
		return steps;
	}

}
