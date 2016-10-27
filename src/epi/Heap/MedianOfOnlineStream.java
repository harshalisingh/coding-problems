package epi.Heap;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MedianOfOnlineStream {
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	  public static void onlineMedian(Iterator<Integer> sequence) {
	    // minHeap stores the larger half seen so far.
	    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	    
	    // maxHeap stores the smaller half seen so far.
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
	        DEFAULT_INITIAL_CAPACITY, Collections.reverseOrder());

	    while (sequence.hasNext()) {
	      int x = sequence.next();
	      if (minHeap.isEmpty()) {
	        // This is the very first element.
	        minHeap.add(x);
	      } else {
	        if (x >= minHeap.peek()) {
	          minHeap.add(x);
	        } else {
	          maxHeap.add(x);
	        }
	      }
	      // Ensure minHeap and maxHeap have equal number of elements if
	      // an even number of elements is read; otherwise, minHeap must have
	      // one more element than maxHeap.
	      if (minHeap.size() > maxHeap.size() + 1) {
	        maxHeap.add(minHeap.remove());
	      } else if (maxHeap.size() > minHeap.size()) {
	        minHeap.add(maxHeap.remove());
	      }

	      System.out.println(minHeap.size() == maxHeap.size()
	                             ? 0.5 * (minHeap.peek() + maxHeap.peek())
	                             : minHeap.peek());
	    }
	  }
}
