package epi.LinkedList;

public class MergeSortDoublyLinkedList {
	
	 // Split a doubly linked list (DLL) into 2 DLLs of
    // half sizes
    ListNode<Integer> split(ListNode<Integer> head) {
    	ListNode<Integer> fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode<Integer> temp = slow.next;
        slow.next = null;
        return temp;
    }
 
    ListNode<Integer> mergeSort(ListNode<Integer> node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode<Integer> second = split(node);
 
        // Recur for left and right halves
        node = mergeSort(node);
        second = mergeSort(second);
 
        // Merge the two sorted halves
        return merge(node, second);
    }
 
    // Function to merge two linked lists
    ListNode<Integer> merge(ListNode<Integer> first, ListNode<Integer> second) {
        // If first linked list is empty
        if (first == null) {
            return second;
        }
 
        // If second linked list is empty
        if (second == null) {
            return first;
        }
 
        // Pick the smaller value
        if (first.data < second.data) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

}
