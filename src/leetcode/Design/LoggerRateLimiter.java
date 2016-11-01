package leetcode.Design;

import java.util.HashMap;
import java.util.Map;

/*
 * Design a logger system that receive stream of messages along with its timestamps, 
 * each message should be printed if and only if it is not printed in the last 10 seconds.
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, 
 * otherwise returns false.
 */
public class LoggerRateLimiter {
	private Map<String, Integer> map;

	/** Initialize your data structure here. */
	public LoggerRateLimiter() {
	    map = new HashMap<>();
	}

	/** Returns true if the message should be printed in the given timestamp, otherwise returns false. The timestamp is in seconds granularity. */
	public boolean shouldPrintMessage(int timestamp, String message) {
	    if (map.containsKey(message) && (timestamp - map.get(message)) < 10) {
	        return false;
	    } 
	    map.put(message, timestamp);
	    return true;
	}
}
