package leetcode.StackAndQueue;

class Stack{
	private LinkedList listObj;
	public Stack(){
		listObj = new LinkedList(); 
	}
	public boolean isEmpty(){ 
		return listObj.isEmpty(); 
	}
	public void push(int k){ 
		listObj.addFirst(k); 
	}
	public int pop(){ 
		return listObj.removeFirst(); 
	}
	public void display(){
		System.out.print("Stack [start to end]: ");
		listObj.displayList();
	}
}

public class StackUsingLinkedList {
	public static void main(String[] args)
    {
        Stack stack = new Stack(); 
        stack.push(10); 
        stack.push(20); 
        stack.display(); 
        stack.push(30); 
        stack.push(40); 
        stack.display(); 
        stack.pop(); 
        stack.pop(); 
        System.out.println("Two elements are popped");
        stack.display(); 
    } 
}
