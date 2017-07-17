package leetcode.Arrays.MissingOrDuplicate;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * https://leetcode.com/problems/find-the-duplicate-number/#/description
 */
public class FindTheDuplicateNumber {

	/* Linked List Cycle Detection, Time: O(n), Space: O(1)
	 * http://keithschwarz.com/interesting/code/?dir=find-duplicate
	 */
	public int findDuplicateCycleDetection(int[] nums){
		int slow = 0, fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while(slow != fast);

		slow = 0;
		while(slow != fast){
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
	
	//Binary Search, Time: O(n logn), Space: O(1)
	public int findDuplicateBinarySearch(int[] nums) {
		int low = 1, high = nums.length - 1;
		while(low < high){
			int mid = low + (high - low)/2;
			int count = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= mid)
					count++;
			}
			if(count <= mid)
				low = mid+1;
			else 
				high = mid;
		}
		return low;
	}

	
	//Similar to Missing Number, Time: O(n), Space: O(1), However modifies the input array
	public int findDuplicateModifyingAray(int[] nums) {
        int answer = -1;
        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0){
                nums[val] = -nums[val];
            }
            else{
                answer = Math.abs(nums[i]);
            }
        }
        return answer;
    }

	public static void main(String[] args){
		FindTheDuplicateNumber fd = new FindTheDuplicateNumber();
		int[] nums = new int[]{1,3,4,2,5,4};
		System.out.println(fd.findDuplicateBinarySearch(nums));
		System.out.println(fd.findDuplicateCycleDetection(nums));
		System.out.println(fd.findDuplicateModifyingAray(nums));
	}
}
