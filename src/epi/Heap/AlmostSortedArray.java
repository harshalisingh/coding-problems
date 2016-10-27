package epi.Heap;

import java.util.PriorityQueue;

public class AlmostSortedArray {
	public static void sortApproximatelySortedData(int[] sequence, int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		// Adds the first k elements into minHeap. Stop if there are fewer than k
		// elements.
		for (int i = 0; i < k && i < sequence.length; ++i) {
			minHeap.add(sequence[i]);
		}

		// For every new element, add it to minHeap and extract the smallest.
		for(int i = k; i < sequence.length; i++) {
			minHeap.add(sequence[i]);
			Integer smallest = minHeap.poll();
			System.out.println(smallest);
		}

		// sequence is exhausted, iteratively extracts the remaining elements.
		while (!minHeap.isEmpty()) {
			Integer smallest = minHeap.poll();
			System.out.println(smallest);
		}
	}
}
