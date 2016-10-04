package leetcode.StackAndQueue;

class ListNode {
	int data;
	ListNode next;
	ListNode(int x) { data = x; }
	void displayNode(){ 
		System.out.print("[" + data + "]"); 
	}
} 
class LinkedList{
	private ListNode first;
	private ListNode last;
	public LinkedList(){
		first = null;
		last = null;
	}
	public boolean isEmpty(){ 
		return first==null; 
	}
	public void addFirst(int val){//inserts at beginning of list
		ListNode newNode = new ListNode(val);
		newNode.next = first;
		first = newNode;
		
	}
	public void addLast(int val){//Insert node at the end of list
		ListNode newNode = new ListNode(val);
		if( isEmpty() )
			first = newNode;
		else
			last.next = newNode;
		last = newNode;
	}
	public int removeFirst(){//delete the node from the beginning of the list
		int temp = first.data;
		if(first.next == null)
			last = null;
		first = first.next;
		return temp;
	}
	public void displayList(){
		ListNode current = first;
		while(current != null)
		{
			current.displayNode();
			current = current.next;
		}
		System.out.println("");
	}
}
class Queue{
	private LinkedList listObj;
	public Queue(){
		listObj = new LinkedList(); 
	}
	public boolean isEmpty(){ 
		return listObj.isEmpty(); 
	}
	public void add(int k){ 
		listObj.addLast(k); 
	}
	public int remove(){ 
		return listObj.removeFirst(); 
	}
	public void display(){
		System.out.print("Queue [start to end]: ");
		listObj.displayList();
	}
}

public class QueueUsingLinkedList {
	public static void main(String[] args){ 
		Queue queue = new Queue();
		System.out.println("Inserting two elements into the queue");
		queue.add(10);
		queue.add(20);
		queue.display();
		System.out.println("Inserting one more element into the queue at the end");
		queue.add(30);
		queue.display();
		System.out.println("Deleting one element from the front");
		queue.remove();
		queue.display(); 
	} 
}
