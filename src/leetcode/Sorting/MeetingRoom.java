package leetcode.Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom {
	class Interval{
		int start;
		int end;
	}
	public boolean canAttendMeetings(Interval[] intervals) {
	    Arrays.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval a, Interval b){
	            return a.start-b.start;
	        }
	    });
	 
	    for(int i=0; i < intervals.length - 1; i++){
	        if(intervals[i].end > intervals[i+1].start){
	            return false;
	        }
	    }
	 
	    return true;
	}
	
	/*
	 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
	 * find the minimum number of conference rooms required.
	 * Average time complexity is O(nlogn).
	 */
	public int minMeetingRooms(Interval[] intervals) {
	    if(intervals==null||intervals.length==0)
	        return 0;
	 
	 // Sort the intervals by start time
	    Arrays.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval i1, Interval i2){
	            return i1.start-i2.start;
	        }
	    });
	 
	 // Use a min heap to track the minimum end time of merged intervals
	    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	    int count = 1;
	    pq.offer(intervals[0].end);
	 
	    for(int i=1; i<intervals.length; i++){
	        if(intervals[i].start < pq.peek()){
	            count++; 
	        }else{
	        	pq.poll();
	        }
	        pq.offer(intervals[i].end);
	    }
	    return count;
	}
}
