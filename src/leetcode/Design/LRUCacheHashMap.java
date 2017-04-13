package leetcode.Design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCacheHashMap {
    int capacity;
    HashMap<Integer, Integer> map;
    Queue<Integer> timeLine;
    HashMap<Integer, Integer> freq;
    public LRUCacheHashMap(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.freq = new HashMap<>();
        this.timeLine = new LinkedList<>(); 
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        freq.put(key, freq.get(key) + 1);
        timeLine.offer(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
        timeLine.offer(key);
        freq.put(key, freq.getOrDefault(key, 0) + 1);
        if (map.size() > capacity) {
        	//To remove the duplicate key before the key to be removed
            while (freq.get(timeLine.peek()) > 1) {
                int dupKey = timeLine.poll();
                freq.put(dupKey, freq.get(dupKey) - 1);
            }
            int deadKey = timeLine.poll();
            map.remove(deadKey);
            freq.remove(deadKey); 
        }
    }
}