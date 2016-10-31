package leetcode.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

public class MergeIntervals {
	public static ArrayList<Interval> merge(ArrayList<Interval> list) {
		Collections.sort(list, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if (i1.start == i2.start) {
					return i1.end - i2.end;
				}
				return i1.start - i2.start;
			}
		});
		System.out.println("Sorted Input: " + list);

		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval prev = list.get(0);
		result.add(prev);
		for (int i = 1; i < list.size(); i++) {
			Interval current = list.get(i);
			if(current.start > prev.end){
				result.add(prev);
				prev = current;
			}else{
				Interval merged = new Interval(prev.start, Math.max(prev.end, current.end));
				current = merged;
			}
		}
		return result;
	}
}
