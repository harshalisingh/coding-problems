package leetcode.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of closed intervals. Design an efficient algorithm for finding a minimum sized set of numbers
 * that covers all the intervals.
 * e.g. [1,2],[2,3],[3,4],[2,3],[3,4],[4,5] -> {2,4}
 * Time Complexity: O(nlogn)
 */
public class MinimumPointsIntervalCovering {
	public List<Integer> findMinimumVisits(int[][] intervals) {
		if (intervals.length == 0) {
			return Collections.emptyList();
		}
		// Sort intervals based on the right endpoints.
		Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
		List<Integer> visits = new ArrayList<>();
		
		//Select first interval's right endpoint.
		Integer lastVisitTime = intervals[0][1];
		visits.add(lastVisitTime);

		//Iterate through the intervals, looking for the first one not covered by this right endpoint.
		for (int[] interval : intervals) {
			//interval's left is greater than lastVisitTime
			if (interval[0] > lastVisitTime) {
				// The current right endpoint, lastVisitTime, will not cover any more intervals.
				lastVisitTime = interval[1];
				visits.add(lastVisitTime);
			}
		}
		return visits;
	}

	/** Minimum Number of Arrows to Burst Balloons	
	 *  Input: [[10,16], [2,8], [1,6], [7,12]]  Output: 2
	 */
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0;
		}
		// Sort intervals based on the right endpoints.
		Arrays.sort(points, (a,b) -> a[1] - b[1]);

		int arrowCount = 0;
		//Select first balloon's endpoint.
		int lastArrowPos = points[0][1];
		arrowCount++;

		//Iterate through the balloons, looking for the first one not covered by this endpoint.
		for (int[] point : points) {
			if (point[0] > lastArrowPos) {
				// The current endpoint, lastArrowPos, will not cover any more balloons.

				lastArrowPos = point[1]; //new endpoint
				arrowCount++;
			}
		}
		return arrowCount;
	}
	
	public static void main(String[] args){
		MinimumPointsIntervalCovering obj = new MinimumPointsIntervalCovering();
		int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{2,3},{3,4},{4,5}};
		System.out.println(obj.findMinimumVisits(intervals).toString());
		System.out.println(obj.findMinArrowShots(intervals));
	}
}
