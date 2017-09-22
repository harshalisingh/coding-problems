package leetcode.ArraySpecial;

import java.util.HashMap;
import java.util.Map;

/*
 * http://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
 * Time Complexity: O(n)
 */
public class SlidingWindowDistinctCount {
	public static void countDistinct(int arr[], int k) {

		// Creates an empty hashMap hM
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		// initialize distinct element  count for current window
		int dist_count = 0;

		// Traverse the first window and store count of every element in hash map
		for (int i = 0; i < k; i++) {
			if (map.get(arr[i]) == null) {
				map.put(arr[i], 1);
				dist_count++;
			} else {
				int count = map.get(arr[i]);
				map.put(arr[i], count+1);
			}
		}

		// Print count of first window
		System.out.println(dist_count);

		// Traverse through the remaining array
		for (int i = k; i < arr.length; i++) {

			// Remove first element of previous window
			// If there was only one occurrence, then reduce distinct count.
			if (map.get(arr[i-k]) == 1) {
				map.remove(arr[i-k]);
				dist_count--;
			} else { // reduce count of the removed element
				int count = map.get(arr[i-k]);
				map.put(arr[i-k], count-1);
			}

			// Add new element of current window
			//If this element appears first time, increment distinct element count
			if (map.get(arr[i]) == null) {
				map.put(arr[i], 1);
				dist_count++;
			} else { // Increment distinct element count
				int count = map.get(arr[i]);
				map.put(arr[i], count+1);
			}
			// Print count of current window
			System.out.println(dist_count);
		}
	}
}
