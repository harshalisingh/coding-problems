package leetcode.Design;

import java.util.ArrayList;
import java.util.HashMap;

public class InsertDeleteGetRandom {
	class RandomizedSet {
		ArrayList<Integer> nums;
		HashMap<Integer, Integer> locs;
		java.util.Random rand = new java.util.Random();
		/** Initialize your data structure here. */
		public RandomizedSet() {
			nums = new ArrayList<Integer>();
			locs = new HashMap<Integer, Integer>();
		}

		/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
		public boolean insert(int val) {
			boolean contain = locs.containsKey(val);
			if ( contain ) return false;
			locs.put( val, nums.size());
			nums.add(val);
			return true;
		}

		/** Removes a value from the set. Returns true if the set contained the specified element. */
		public boolean remove(int val) {
			boolean contain = locs.containsKey(val);
			if ( ! contain ) return false;
			int loc = locs.get(val); //get val's location in arraylist nums
			if (loc < nums.size() - 1) {                  // not the last one then swap the last one with this val
				int lastNum = nums.get(nums.size() - 1);  //get last num in nums
				nums.set( loc , lastNum);                 //swap with val's location
				locs.put(lastNum, loc);                   //update lastNum location in locs
			}
			locs.remove(val);
			nums.remove(nums.size() - 1);
			return true;
		}

		/** Get a random element from the set. */
		public int getRandom() {
			return nums.get( rand.nextInt(nums.size()) );
		}
	}
}
