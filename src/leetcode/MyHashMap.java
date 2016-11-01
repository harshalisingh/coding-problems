package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class MyHashMap<K, T> {

	public static void main(String[] args) {
		MyHashMap<String, String> map = new MyHashMap<String, String>();
		map.put("CA", "California");
		map.put("TX", "Texas");
		map.put("TX", "Texas1");
		map.put("TX", "Texas2");
		map.put("GA", "Georgia");
		String s = map.get("CA");
		System.out.println(map.get("CA"));
		System.out.println(map.get("TX"));
		System.out.println(map.get("GA"));

	}

	static class Pair<K, T> {
		K key;
		T value;

		Pair(K k, T v) {
			key = k;
			value = v;
		}
	}

	int size = 10;
	LinkedList<Pair> buckets[] = new LinkedList[size];

	int hash(K key) {
		return key.hashCode() % size;
	}

	void put(K key, T value) {
		int index = hash(key);
		if (buckets[index] == null) {
			buckets[index] = new LinkedList();
		}
		for (Object p : buckets[index]) {
			Pair<K, T> pair = (Pair<K, T>) p;
			if (pair.key.equals(key)) {
				pair.value = value;
				return;
			}
		}
		buckets[index].add(new Pair<K, T>(key, value));
	}

	T get(K key) {
		int index = hash(key);
		if (buckets[index] == null)
			return null;
		for (Object p : buckets[index]) {
			Pair<K, T> pair = (Pair<K, T>) p;
			if (pair.key.equals(key))
				return pair.value;
		}
		return null;
	}

	//If your data structure has many-to-one mapping between keys and values,
	//you should iterate over entries and pick all suitable keys:
	public static <K, T> Set<K> getKeysByValue(Map<K, T> map, T value) {
		Set<K> keys = new HashSet<K>();
		for (Entry<K, T> entry : map.entrySet()) {
			if (Objects.equals(value, entry.getValue())) {
				keys.add(entry.getKey());
			}
		}
		return keys;
	}

	//In case of one-to-one relationship, you can return the first matched key:
	public static <K, T> K getKeyByValue(Map<K, T> map, T value) {
		for (Entry<K, T> entry : map.entrySet()) {
			if (Objects.equals(value, entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}
}