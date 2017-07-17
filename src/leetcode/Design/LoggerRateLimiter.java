package leetcode.Design;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/** https://leetcode.com/problems/logger-rate-limiter/#/description
 * Design a logger system that receive stream of messages along with its timestamps, 
 * each message should be printed if and only if it is not printed in the last 10 seconds.
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, 
 * otherwise returns false.
 */
/* The problem with this approach is that your map size will keep growing. It will have messages that have come since the beginning 
 * even though we need to keep only the words that have come only 10 seconds before the current timestamp.
 */
public class LoggerRateLimiter {
	private Map<String, Integer> map;

	/** Initialize your data structure here. */
	public LoggerRateLimiter() {
		map = new HashMap<>();
	}

	/** Returns true if the message should be printed in the given timestamp, otherwise returns false. The timestamp is in seconds granularity. */
	public boolean shouldPrintMessage(int timestamp, String message) {
		//update timestamp of the message if the message is coming in for the first time,or the last coming time is earlier than 10 seconds from now
		if(!map.containsKey(message) || timestamp-map.get(message)>=10){
			map.put(message,timestamp);
			return true;
		}
		return false;
	}
}

class Logger {

    public Map<String, Integer> map;
    int lastSecond = 0;
    
    /** Initialize your data structure here. */
    public Logger() {
        map = new LinkedHashMap<String, Integer>(100, 0.6f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return lastSecond - eldest.getValue() > 10;
            }
        };
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        lastSecond = timestamp;
        if(!map.containsKey(message) || timestamp - map.get(message) >= 10){
            map.put(message,timestamp);
            return true;
        }
        return false;
    }
}
