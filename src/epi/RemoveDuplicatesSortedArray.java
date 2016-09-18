package epi;

public class RemoveDuplicatesSortedArray {

	public int removeDuplicates(int[] nums) {

		int writeIndex = 1;
		for(int i = 1; i < nums.length; i++){
			if(nums[writeIndex-1] != nums[i]){
				nums[writeIndex++] = nums[i];
			}
		}

		return writeIndex;
	}

}
