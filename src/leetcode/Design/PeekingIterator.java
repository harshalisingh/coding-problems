package leetcode.Design;

import java.util.Iterator;

/*Java Iterator interface reference:
https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
https://leetcode.com/problems/peeking-iterator/
*/
class PeekingIterator implements Iterator<Integer> {
	private Integer next;
	private Iterator<Integer> itr;
	private boolean done = false;

	public PeekingIterator(Iterator<Integer> iterator) {
		itr = iterator;
		if (iterator.hasNext())
			next = itr.next();
		else
			done = true;
	}

	//Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}

	//hasNext() and next() should behave the same as in the Iterator interface.
	//Override them if needed.
	@Override
	public Integer next() {
		Integer result = next;
		if (itr.hasNext()) {
			next = itr.next();
		} else {
			next = null;
			done = true;
		}
		return result;
	}

	@Override
	public boolean hasNext() {
		return !done;
	}
}
