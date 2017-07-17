package leetcode.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
 * So the median is the mean of the two middle value.
 * 
 * The invariant of the algorithm is two heaps, small and large, each represent half of the current list. 
 * The length of smaller half is kept to be n / 2 at all time and the length of the larger half is either n / 2 or n / 2 + 1 
 * depend on n's parity.
 * 
 * Before we add an element, (total n numbers, k = n / 2):
 * (1) length of (small, large) == (k, k)
   (2) length of (small, large) == (k, k + 1)
   
   After adding the number, total (n + 1) numbers, they will become:
   (1) length of (small, large) == (k, k + 1)
   (2) length of (small, large) == (k + 1, k + 1)
 *
 */
public class MedianFinderStream {
	
	//Max Heap (stores the smaller half of numbers seen so far in descending order)
	private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
	
	//Min Heap (stores the larger half of numbers seen so far in ascending order)
	private PriorityQueue<Integer> large = new PriorityQueue<>();
	
	private boolean even = true;

	public double findMedian() {
	    if (even)
	        return (small.peek() + large.peek()) / 2.0;
	    else
	        return small.peek();
	}

	public void addNum(int num) {
	    if (even) {
	        large.offer(num);
	        small.offer(large.poll());
	    } else {
	        small.offer(num);
	        large.offer(small.poll());
	    }
	    even = !even;
	}
}
