package leetcode.BST;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicates {
	/* Time complexity : O(n log(min(n,k))). We iterate through the array of size n. For each iteration, 
	 * it costs O(log(min(k, n)) time (search, insert or delete) in the BST, since the size of the BST is upper bounded by both k and n.
	 * Space complexity : O(min(n,k)). Space is dominated by the size of the BST, which is upper bounded by both k and n.
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length < 2 || k == 0) {
			return false;
		}
	    TreeSet<Integer> set = new TreeSet<>();
	    for (int i = 0; i < nums.length; ++i) {
	        //Find the successor of current element
	    	//Ceiling Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
	        Integer s = set.ceiling(nums[i]);
	        if (s != null && s <= nums[i] + t) return true;

	        //Find the predecessor of current element
	       //Floor Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
	        Integer g = set.floor(nums[i]);
	        if (g != null && nums[i] <= g + t) return true;

	        set.add(nums[i]);
	        if (set.size() > k) {
	            set.remove(nums[i - k]);
	        }
	    }
	    return false;
	}
}
