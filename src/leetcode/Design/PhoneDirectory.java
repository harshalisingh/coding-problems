package leetcode.Design;

import java.util.HashSet;
import java.util.LinkedList;

public class PhoneDirectory {
	int max;
	HashSet<Integer> used;
	LinkedList<Integer> available;

	/** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public PhoneDirectory(int maxNumbers) {
		used = new HashSet<Integer>();
		available = new LinkedList<Integer>();
		max = maxNumbers;
		for(int i=0; i < maxNumbers; i++){
			available.offer(i);
		}
	}

	/** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
	public int get() {
		if(available.isEmpty())
			return -1;

		int e = available.poll();
		used.add(e);
		return e;
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		if (number >= max || number < 0) {
            return false;
        }
        return !used.contains(number);
	}

	/** Recycle or release a number. */
	public void release(int number) {
		if (used.remove(number)) {
            available.offer(number);
        }
	}
}