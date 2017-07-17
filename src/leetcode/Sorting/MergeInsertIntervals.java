package leetcode.Sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example, Given [1,3],[2,6],[8,10],[15,18],
 *              return [1,6],[8,10],[15,18].
 */
public class MergeInsertIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1)
			return intervals;

		// Sort by ascending starting point using an anonymous Comparator
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

		List<Interval> result = new LinkedList<Interval>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (Interval interval : intervals) {
			if (interval.start <= end) // Overlapping intervals, move the end if needed
				end = Math.max(end, interval.end);
			else {                     // Disjoint intervals, add the previous one and reset bounds
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}

		// Add the last interval
		result.add(new Interval(start, end));
		return result;
	}
}

/**
 * Given a set of non-overlapping & sorted intervals, 
 * insert a new interval into the intervals (merge if necessary).
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		for (Interval i : intervals) {
			if (newInterval == null || i.end < newInterval.start) //interval i ends before newInterval (non-overlapping)
				result.add(i);
			else if (newInterval.end < i.start) { //newInterval ends before interval i (non-overlapping)
				result.add(newInterval);
				result.add(i);
				newInterval = null;
			} else {                            //overlapping
				newInterval.start = Math.min(newInterval.start, i.start);
				newInterval.end = Math.max(newInterval.end, i.end);
			}
		}
		if (newInterval != null)
			result.add(newInterval);
		return result;
	}
}

class Interval {
	int start;
	int end;
	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}
}

