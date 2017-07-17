package leetcode.Arrays.MissingOrDuplicate;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/#/description
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/#/description
 * https://leetcode.com/problems/remove-element/#/description
 */
public class RemoveDuplicatesSortedArray {

	//Remove Duplicates from Sorted Array(no duplicates) :
	public int removeDuplicatesI(int[] nums) {
		int i = 0;
		for(int n : nums) {
			if(i < 1 || n > nums[i - 1]) { //if current is not equal to prev
				nums[i++] = n;
			}
		}
		return i;
	}

	//Remove Duplicates from Sorted Array II (allow duplicates up to 2):
	public int removeDuplicatesII(int[] nums) {
		int i = 0;
		for (int n : nums) {
			if (i < 2 || n > nums[i - 2]) {
				nums[i++] = n;
			}
		}
		return i;
	}


	//Remove Duplicates from Sorted Array K (when duplicates are allowed at most K times)
	public int removeDuplicatesK(int[] nums, int k) {
		int i = 0;
		for (int n : nums) {
			if (i < k || n > nums[i - k]) {
				nums[i++] = n;
			}
		}
		return i;
	}

	//Remove Element
	//Given an array and a value, remove all instances of that value in place and return the new length.
	public int removeElement(int[] nums, int val) {
		int i = 0;
		for(int n : nums) {
			if(n != val) {
				nums[i++] = n;
			}
		}
		return i;
	}

	public static void main(String[] args){
		RemoveDuplicatesSortedArray caller = new RemoveDuplicatesSortedArray();
		int[] nums1 = {1,1,2,2,3,4,4,4,5};
		int[] nums2 = {1,1,2,2,3,4,4,4,5};
		int[] nums3 = {1,1,2,2,3,4,4,4,5,5,5,5};
		System.out.println(caller.removeDuplicatesI(nums1));
		System.out.println(caller.removeDuplicatesII(nums2));
		System.out.println(caller.removeDuplicatesK(nums3, 3));
	}
}
