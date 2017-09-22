package leetcode.Greedy;

import java.util.Arrays;

/**
 * Given service times for a set of queries, compute a schedule for processing the queries 
 * that minimizes the total waiting time.
 * e.g. serviceTimes = [2,5,1,3]
 * min total waiting time = (0) + (1) + (1+2) + (1+2+3) = 10
 * Time Complexity: O(nlogn)
 */
public class MinimumWaitingTime {
	public static int minimumTotalWaitingTime(int[] serviceTimes) {
	    // Sort the service times in increasing order.
	    Arrays.sort(serviceTimes);

	    int totalWaitingTime = 0;
	    for (int i = 0; i < serviceTimes.length; ++i) {
	      int numRemainingQueries = serviceTimes.length - (i + 1);
	      totalWaitingTime += serviceTimes[i] * numRemainingQueries;
	    }
	    return totalWaitingTime;
	  }
}
