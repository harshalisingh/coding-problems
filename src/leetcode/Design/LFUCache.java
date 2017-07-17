package leetcode.Design;

import java.util.HashMap;
import java.util.LinkedHashSet;

/** LFU Cache
 * https://leetcode.com/problems/lfu-cache/#/description
 */
class CacheElement {
	public int count = 0;
	public LinkedHashSet<Integer> keys = null;
	public CacheElement prev = null, next = null;

	public CacheElement(int _count) {
		count = _count;
		keys = new LinkedHashSet<Integer>();
		prev = next = null;
	}
}
public class LFUCache {
	private CacheElement head = null;
	private int capacity = 0;
	private HashMap<Integer, Integer> valueHash = null;
	private HashMap<Integer, CacheElement> cache = null;

	public LFUCache(int _capacity) {
		capacity = _capacity;
		valueHash = new HashMap<Integer, Integer>();
		cache = new HashMap<Integer, CacheElement>();
	}

	public int get(int key) {
		if (valueHash.containsKey(key)) {
			refreshUsage(key);
			return valueHash.get(key);
		}
		return -1;
	}

	public void put(int key, int value) {
		if ( capacity == 0 ) return;
		if (valueHash.containsKey(key)) {
			valueHash.put(key, value);
		} else {
			if (valueHash.size() < capacity) {
				valueHash.put(key, value);
			} else {
				removeOne();
				valueHash.put(key, value);
			}
			addToHead(key);
		}
		refreshUsage(key);
	}

	private void addToHead(int key) {
		if (head == null) {
			head = new CacheElement(0);
			head.keys.add(key);
		} else if (head.count > 0) {
			CacheElement element = new CacheElement(0);
			element.keys.add(key);
			element.next = head;
			head.prev = element;
			head = element;
		} else {
			head.keys.add(key);
		}
		cache.put(key, head);      
	}

	private void refreshUsage(int key) {
		CacheElement element = cache.get(key);
		element.keys.remove(key);

		if (element.next == null) {
			element.next = new CacheElement(element.count+1);
			element.next.prev = element;
			element.next.keys.add(key);
		} else if (element.next.count == element.count+1) {
			element.next.keys.add(key);
		} else {
			CacheElement tmp = new CacheElement(element.count+1);
			tmp.keys.add(key);
			tmp.prev = element;
			tmp.next = element.next;
			element.next.prev = tmp;
			element.next = tmp;
		}
		cache.put(key, element.next);
		if (element.keys.size() == 0) remove(element);
	}

	private void removeOne() {
		if (head == null) return;
		int old = 0;
		for (int n: head.keys) {
			old = n;
			break;
		}
		head.keys.remove(old);
		if (head.keys.size() == 0) remove(head);
		cache.remove(old);
		valueHash.remove(old);
	}

	private void remove(CacheElement element) {
		if (element.prev == null) {
			head = element.next;
		} else {
			element.prev.next = element.next;
		} 
		if (element.next != null) {
			element.next.prev = element.prev;
		}
	}


}
