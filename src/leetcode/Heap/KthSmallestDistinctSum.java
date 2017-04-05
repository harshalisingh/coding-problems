package leetcode.Heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Comparator;

public class KthSmallestDistinctSum {
	
	class Pair {
		int i;   // index of x[]
		int j;   // index of y[]
		int sum; // x[i] + y[j]

		public Pair(int i, int j, int sum) {
			this.i = i;
			this.j = j;
			this.sum = sum;
		}
	}

	public int findKthDistinctSum(int[] x, int[] y, int k) {
		if (x.length == 0 || y.length == 0) {
			throw new IllegalArgumentException("Can't handle zero-length arrays.");
		}

		// use a min heap to poll the next state that has minimum sum
		PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair a, Pair b) {
				return a.sum - b.sum;
			}
		});

		// use a hash set to avoid duplicate sum
		Set<Integer> set = new HashSet<>();

		// step 1. create initial pair
		int sum = x[0] + y[0];
		heap.offer(new Pair(0, 0, sum));
		set.add(sum);

		// step 2. generate new pairs based on current pair
		// until we get the kth smallest sum
		while (k-- > 1) {
			Pair p = heap.poll();

			// new pair 1: x[i], y[j + 1]
			if (p.j < y.length - 1) {
				sum = x[p.i] + y[p.j + 1];

				if (!set.contains(sum)) {
					heap.offer(new Pair(p.i, p.j + 1, sum));
					set.add(sum);
				}
			}

			// new pair 2: x[i + 1], y[j]
			if (p.i < x.length - 1) {
				sum = x[p.i + 1] + y[p.j];

				if (!set.contains(sum)) {
					heap.offer(new Pair(p.i + 1, p.j, sum));
					set.add(sum);
				}
			}
		}

		return heap.poll().sum;
	}

}
