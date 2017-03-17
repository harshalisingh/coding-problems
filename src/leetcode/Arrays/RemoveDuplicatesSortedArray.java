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

	//Remove Element
	//Given an array and a value, remove all instances of that value in place and return the new length.
	public int removeElement(int[] nums, int val) {
		int i = 0;
		for(int n : nums)
			if(n != val) 
				nums[i++] = n;
		return i;
	}
}
