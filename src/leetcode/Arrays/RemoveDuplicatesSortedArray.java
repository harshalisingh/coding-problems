package leetcode.Arrays;

public class RemoveDuplicatesSortedArray {

	//Remove Duplicates from Sorted Array(no duplicates) :
	public int removeDuplicatesI(int[] nums) {
		int i = 0;
		for(int n : nums)
			if(i < 1 || n > nums[i - 1]) 
				nums[i++] = n;
		return i;
	}

	//Remove Duplicates from Sorted Array II (allow duplicates up to 2):
	public int removeDuplicatesII(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		return i;
	}
}
