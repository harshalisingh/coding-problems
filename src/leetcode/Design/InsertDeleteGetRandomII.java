package leetcode.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class InsertDeleteGetRandomII {
}
class RandomizedCollection {
	ArrayList<Integer> nums;
	HashMap<Integer, LinkedHashSet<Integer>> locs;
	java.util.Random rand = new java.util.Random();
	/** Initialize your data structure here. */
	public RandomizedCollection() {
		nums = new ArrayList<Integer>();
		locs = new HashMap<Integer, LinkedHashSet<Integer>>();
	}

	/** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	public boolean insert(int val) {
		boolean contain = locs.containsKey(val);
		if ( ! contain ) locs.put( val, new LinkedHashSet<Integer>() ); 
		locs.get(val).add(nums.size());        
		nums.add(val);
		return ! contain ;
	}

	/** Removes a value from the collection. Returns true if the collection contained the specified element. */
	public boolean remove(int val) {
		boolean contain = locs.containsKey(val);
		if ( ! contain ) return false;
		int loc = locs.get(val).iterator().next();    // get val's arraylist index from linkedhashset
		locs.get(val).remove(loc);                    //remove that index from set
		if (loc < nums.size() - 1 ) {                 //if it is not the last index
			int lastNum = nums.get( nums.size()-1 );  //get the last number
			nums.set( loc , lastNum );                //set the lastNum in loc index in the arraylist
			locs.get(lastNum).remove( nums.size()-1); //remove lastNum location from set
			locs.get(lastNum).add(loc);               //update lastNum location in set
		}
		nums.remove(nums.size() - 1);                 //remove lastNum sfrom arraylist

		if (locs.get(val).isEmpty()) locs.remove(val);
		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return nums.get( rand.nextInt(nums.size()) );
	}
}
