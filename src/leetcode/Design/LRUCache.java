package leetcode.Design;

import java.util.HashMap;
//LRUcache using HashMap and Doubly Linked List
class Node {
	int key;
	int value;
	Node prev;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class LRUCache {
	HashMap<Integer, Node> cache;
	int capacity, count;
	Node head, tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
		head.prev = null;
		tail.next = null;
		count = 0;
	}

	public void deleteNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public void addToHead(Node node) {
		node.next = head.next;
		node.next.prev = node;
		node.prev = head;
		head.next = node;
	}

	/* get the value of the cache node for the given key */
	public int get(int key) {
		//cache entry exists
		if (cache.get(key) != null) {
			Node node = cache.get(key);
			int result = node.value;
			deleteNode(node);
			addToHead(node);
			return result;
		}
		return -1; //cache miss
	}

	public void set(int key, int value) {
		//cache entry already exists
		if (cache.get(key) != null) {    
			Node node = cache.get(key);
			node.value = value;
			deleteNode(node);
			addToHead(node);
		}
		//new cache entry
		else {                         
			Node node = new Node(key, value);
			cache.put(key, node);
			//if count is less than capacity, add new node to head
			if (count < capacity) {
				count++;
				addToHead(node);
			} 
			//if capacity exceeds, remove node just before tail, add new node to head
			else {
				cache.remove(tail.prev.key);
				deleteNode(tail.prev);
				addToHead(node);
			}
		}
	}
}

