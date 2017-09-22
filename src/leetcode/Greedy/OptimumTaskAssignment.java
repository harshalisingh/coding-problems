package leetcode.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Compute an optimum assignment of tasks (minimize how long it takes before all tasks are completed).
 * Design an algorithm that takes as input a set of tasks and returns an optimum assignment.
 * Each worker must be assigned exactly two tasks.
 * Time Complexity: O(n log n)
 */
public class OptimumTaskAssignment {
	private static class PairedTasks {
		public PairedTasks(Integer task1, Integer task2) {
		}
	}

	public static List<PairedTasks> optimumTaskAssignment(int[] taskDurations) {
		Arrays.sort(taskDurations);
		List<PairedTasks> optimumAssignments = new ArrayList<>();
		for (int i = 0, j = taskDurations.length - 1; i < j; ++i, --j) {
			optimumAssignments.add(
					new PairedTasks(taskDurations[i], taskDurations[j]));
		}
		return optimumAssignments;
	}
}
