package leetcode.Greedy;

/*
 * https://leetcode.com/problems/jump-game-ii/#/description
 * The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point 
 * that all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then trigger another jump, 
 * and set the new curEnd with curFarthest, then keep the above steps, as the following:
 * Greedy O(n)
 */
public class JumpGameII {
	// Greedy O(n)
	public int jump(int[] nums) {
		int curEnd = 0, curFarthest = 0, steps = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			curFarthest = Math.max(curFarthest, nums[i] + i);
			if (curFarthest >= nums.length - 1) {
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


	//DP, O(n^2)
	public int minJump(int arr[],int result[]){
		int []jump = new int[arr.length];
		jump[0] = 0;
		for(int i=1; i < arr.length ; i++){
			jump[i] = Integer.MAX_VALUE-1;
		}

		for(int i=1; i < arr.length; i++){
			for(int j=0; j < i; j++){
				if(arr[j] + j >= i){
					if(jump[i] > jump[j] + 1){
						result[i] = j;
						jump[i] = jump[j] + 1;
					}
				}
			}
		}

		return jump[jump.length-1];
	}
}
