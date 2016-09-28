package leetcode;

import java.util.HashSet;
import java.util.Set;

class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
        int i = 0, j = 0;
        for (; j < nums.length; j++) {
            if (j - i > k) {
                set.remove(nums[i]);
                i++;
            }
            if (set.contains(nums[j])) return true;
            set.add(nums[j]);
        }
        return false;
	}
}
