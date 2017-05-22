package leetcode.Design;

import java.util.HashMap;
//LRUcache using hashMap and Doubly Linked List
class Node {
	int key;
	int value;
	Node pre;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class LRUCache {
	HashMap<Integer, Node> map;
	int capacity, count;
	Node head, tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.pre = head;
		head.pre = null;
		tail.next = null;
		count = 0;
	}

	public void deleteNode(Node node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	public void addToHead(Node node) {
		node.next = head.next;
		node.next.pre = node;
		node.pre = head;
		head.next = node;
	}

	//get the value of the cache node for the given key
	public int get(int key) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			int result = node.value;
			deleteNode(node);
			addToHead(node);
			return result;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			node.value = value;
			deleteNode(node);
			addToHead(node);
		} else {
			Node node = new Node(key, value);
			map.put(key, node);
			//if count is less than capacity, add new node to head
			if (count < capacity) {
				count++;
				addToHead(node);
			} 
			//if capacity exceeds, remove node just before tail, add new node to head
			else {
				map.remove(tail.pre.key);
				deleteNode(tail.pre);
				addToHead(node);
			}
		}
	}
}

