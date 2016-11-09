package leetcode.LinkedList;

import java.util.Stack;


/*
 * You are given two linked lists representing two non-negative numbers. 
 * The most significant digit comes first and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */

public class AddTwoNumbersII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) carry += s1.pop();
            if (!s2.empty()) carry += s2.pop();
            list.val = carry % 10;
            ListNode head = new ListNode(carry / 10);
            head.next = list;
            list = head;
            carry /= 10;
        }
        
        return list.val == 0 ? list.next : list;
    }
}
