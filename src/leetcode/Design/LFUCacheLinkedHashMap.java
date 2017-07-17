package leetcode.Design;

import java.util.LinkedHashMap;
import java.util.Map;

class CacheEntry {
	public int value;
	public int freq;

	// default constructor
	public CacheEntry(int value, int freq){
		this.value = value;
		this.freq = freq;
	}      

}
public class LFUCacheLinkedHashMap {
	private static int initialCapacity = 10;

	/* LinkedHashMap is used because it has features of both HashMap and LinkedList. 
	 * Thus, we can get an entry in O(1) and also, we can iterate over it easily.
	 */
	private static LinkedHashMap<Integer, CacheEntry> cacheMap = new LinkedHashMap<Integer, CacheEntry>();
	
	public LFUCacheLinkedHashMap(int initialCapacity) {
		LFUCacheLinkedHashMap.initialCapacity = initialCapacity;
	}

	public void put (int key, int value) {
		if(!isFull()) {
			CacheEntry temp = new CacheEntry(value, 0);
			cacheMap.put(key, temp);
		}
		else {
			int entryKeyToBeRemoved = getLFUKey();
			cacheMap.remove(entryKeyToBeRemoved);

			CacheEntry temp = new CacheEntry(value, 0);
			cacheMap.put(key, temp);
		}
	}

	public int getLFUKey() {
		int key = 0;
		int minFreq = Integer.MAX_VALUE;

		for(Map.Entry<Integer, CacheEntry> entry : cacheMap.entrySet()) {
			if(minFreq > entry.getValue().freq){
				key = entry.getKey();
				minFreq = entry.getValue().freq;
			}           
		}

		return key;
	}

	public int get (int key){
		if(cacheMap.containsKey(key)) { // cache hit
			CacheEntry temp = cacheMap.get(key);
			temp.freq++;
			cacheMap.put(key, temp);
			return temp.value;
		}
		return -1; // cache miss
	}

	public static boolean isFull() {
		if(cacheMap.size() == initialCapacity)
			return true;

		return false;
	}

	public static void main(String[] args){
		LFUCacheLinkedHashMap cache = new LFUCacheLinkedHashMap( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.get(3);       // returns 3.
		cache.put(4, 4);    // evicts key 1.
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
	}
}
