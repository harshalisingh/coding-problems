package leetcode.LinkedList;

/**
 * http://www.geeksforgeeks.org/sorted-insert-for-circular-linked-list/
 * Test cases
 * Insert 2nd element smaller than head
 * Insert 2nd element larger than head
 * Insert element larger than tail
 * Insert element just before tail
 * Insert element somewhere between head and tail
 */
public class InsertNodeCyclicLL {

    public ListNode add(ListNode head,int data){
    	
    	//Node node becomes head
        if(head == null){
            head = new ListNode(data);
            head.next = head;
            return head;
        }
        
        //New node inserted before head
        ListNode node = new ListNode(data);
        ListNode tail = getTail(head);
        if(node.val < head.val){
            node.next = head;
            tail.next = node;
            return node;
        }
        ListNode current = head;
        ListNode pre = null;
        while(current != tail && node.val >= current.val){
            pre = current;
            current = current.next;
        }
        //Insert element just before tail
        if(node.val < current.val){
            node.next = current;
            pre.next = node;
        }
        
        //Insert element somewhere between head and tail
        else{
            node.next = tail.next;
            tail.next = node;
        }
        return head;
    }
    
    private ListNode getTail(ListNode head){
    	ListNode temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        return temp;
    }
    
    public void printList(ListNode head){
        if(head == null){
            return;
        }
        ListNode current = head.next;
        System.out.println(head.val);
        while(current != head){
            System.out.println(current.val);
            current = current.next;
        }
    }
    
    public static void main(String args[]){
    	InsertNodeCyclicLL scll = new InsertNodeCyclicLL();
        ListNode head = null;
        head = scll.add(head, 10);
        head = scll.add(head, 12);
        head = scll.add(head, -1);
        head = scll.add(head, -5);
        head = scll.add(head, 11);
        head = scll.add(head, 7);
        
        scll.printList(head);
    }
}
